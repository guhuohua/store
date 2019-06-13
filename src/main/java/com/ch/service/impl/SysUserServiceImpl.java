/**
 * Author: 常富文
 * Date:   2019/6/3 17:06
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.dto.SysUserDTO;
import com.ch.dto.UserDTO;
import com.ch.entity.*;
import com.ch.service.SysUserService;
import com.ch.util.IdUtil;
import com.ch.util.PasswordUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysUserServiceImpl implements SysUserService {
    private static final Logger LOGGER = LogManager.getLogger(SysUserServiceImpl.class);

    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Autowired
    SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public UserDTO findById(Long userId) {
        UserDTO dto = new UserDTO();
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        if(sysUser!=null){
            dto.setUserId(sysUser.getUserId());
            dto.setUsername(sysUser.getUsername());

            SysUserRoleExample example = new SysUserRoleExample();
            SysUserRoleExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(example);
            Set<String> roles = new HashSet<>();
            Set<String> permissions = new HashSet<>();
            for (SysUserRole role : sysUserRoles){
                if (role != null){
                    SysRole sysRole = sysRoleMapper.selectByPrimaryKey(role.getRoleId());
                    SysRolePermissionExample example1 = new SysRolePermissionExample();
                    SysRolePermissionExample.Criteria criteria1 = example1.createCriteria();
                    criteria1.andRoleIdEqualTo(role.getRoleId());
                    List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(example1);
                    for (SysRolePermission rolePermission: sysRolePermissions ){
                        SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(rolePermission.getPermissionId());
                        System.out.println(sysPermission);
                        if (BeanUtils.isNotEmpty(sysPermission)) {
                            permissions.add(sysPermission.getPermissionDesc());
                        }
                    }
                    roles.add(sysRole.getRoleName());
                }
            }
            dto.setRoles(roles);
            dto.setPermissions(permissions);
        }
        return dto;
    }

    @Override
    public ResponseResult login(UserDTO userDto) {
        ResponseResult result = new ResponseResult();
        if (userDto.getUsername() == null) {
            result.setCode(500);
            result.setError("用户名不能为空");
            result.setError_description("用户名不能为空");
            return result;
        }
        if (userDto.getPassword() == null) {
            result.setCode(500);
            result.setError("密码不能为空");
            result.setError_description("密码不能为空");
            return result;
        }
        SysUserExample example  = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(userDto.getUsername());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if(sysUsers.size()>0){
            SysUser sysUser = sysUsers.get(0);
            if(sysUser.getStatus()==0){
                result.setCode(500);
                result.setError("该用户已被禁用，请联系管理员");
                result.setError_description("该用户已被禁用，请联系管理员");
                return result;
            }
            PasswordUtil encoderMd5 = new PasswordUtil(sysUser.getSalt(), "sha-256");
            String encodedPassword = encoderMd5.encode(userDto.getPassword());
            if (sysUser.getPassword().equals(encodedPassword)) {
                System.out.println(sysUser.getUserId());

                /* UserDTO dto = new UserDTO();
                dto.setUserId(sysUser.getUserId());*/
                result.setData(sysUser.getUserId());
                return result;
            } else {
                result.setCode(500);
                result.setError("账号或者密码输入错误请重新输入");
                result.setError_description("账号或者密码输入错误请重新输入");
                return result;
            }

        }else {
            result.setCode(500);
            result.setError("该用户不存在，请重新输入");
            result.setError_description("该用户不存在，请重新输入");
            return result;

        }
    }

    @Override
    public ResponseResult updateOrInsertUser(SysUserDTO sysUserDTO) {
        ResponseResult result = new ResponseResult();
        if (sysUserDTO.getUserId() == null || sysUserDTO.getUserId().equals("")) {
            SysUserExample example = new SysUserExample();
            example.createCriteria().andUsernameEqualTo(sysUserDTO.getUserName());
            List<SysUser> btSysUsers = sysUserMapper.selectByExample(example);
            SysUserExample example2 = new SysUserExample();
            example2.createCriteria().andAccountEqualTo(sysUserDTO.getAccount());
            List<SysUser> btSysUsers2 = sysUserMapper.selectByExample(example2);
            SysUserExample example3 = new SysUserExample();
            example3.createCriteria().andPhoneEqualTo(sysUserDTO.getPhone());
            List<SysUser> btSysUsers3 = sysUserMapper.selectByExample(example3);
            if (btSysUsers.size() > 0) {
                result.setCode(500);
                result.setError("用户名不能重复");
                result.setError_description("用户名不能重复");
                return result;
            }
            if (btSysUsers2.size() > 0) {
                result.setCode(500);
                result.setError("登录账户不能重复");
                result.setError_description("登录账户不能重复");
                return result;
            }
            if (btSysUsers3.size() > 0) {
                result.setCode(500);
                result.setError("手机号不能重复");
                result.setError_description("手机号不能重复");
                return result;
            }
            try {
                SysUser btSysUser = new SysUser();
                Long userId = IdUtil.getId();
                btSysUser.setUserId(userId);
                btSysUser.setAccount(sysUserDTO.getAccount());
                String salt = UUID.randomUUID().toString();
                PasswordUtil encoderMd5 = new PasswordUtil(salt, "sha-256");
                String encodedPassword = encoderMd5.encode(sysUserDTO.getPassword());
                btSysUser.setSalt(salt);
                btSysUser.setPassword(encodedPassword);
                btSysUser.setPhone(sysUserDTO.getPhone());
                btSysUser.setUpdateTime(new Date());
                btSysUser.setUsername(sysUserDTO.getUserName());
                btSysUser.setStatus(sysUserDTO.getStatus());
                sysUserMapper.insert(btSysUser);
                SysUserRole userRole = new SysUserRole();
                userRole.setRoleId(sysUserDTO.getRoleId());
                userRole.setUserId(userId);
                sysUserRoleMapper.insert(userRole);
            } catch (Exception e) {
                LOGGER.error("新增人员失败" + e.getMessage(),e);
                result.setCode(500);
                result.setError(e.getMessage());
                result.setError_description("新增人员失败");
                return result;
            }
        } else {
            SysUserExample example = new SysUserExample();
            example.createCriteria().andUsernameEqualTo(sysUserDTO.getUserName()).andUserIdNotEqualTo(sysUserDTO.getUserId());
            List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
            SysUserExample example2 = new SysUserExample();
            example2.createCriteria().andAccountEqualTo(sysUserDTO.getAccount()).andUserIdNotEqualTo(sysUserDTO.getUserId());
            List<SysUser> sysUsers2 = sysUserMapper.selectByExample(example2);
            SysUserExample example3 = new SysUserExample();
            example3.createCriteria().andPhoneEqualTo(sysUserDTO.getPhone()).andUserIdNotEqualTo(sysUserDTO.getUserId());
            List<SysUser> sysUsers3 = sysUserMapper.selectByExample(example3);
            if (sysUsers.size() > 0) {
                result.setCode(500);
                result.setError("用户名不能重复");
                result.setError_description("用户名不能重复");
                return result;
            }
            if (sysUsers2.size() > 0) {
                result.setCode(500);
                result.setError("登录账户不能重复");
                result.setError_description("登录账户不能重复");
                return result;
            }
            if (sysUsers3.size() > 0) {
                result.setCode(500);
                result.setError("手机号不能重复");
                result.setError_description("手机号不能重复");
                return result;
            }
            SysUser sysUser = new SysUser();
            sysUser.setAccount(sysUserDTO.getAccount());
            if (BeanUtils.isNotEmpty(sysUserDTO.getPassword())) {
                String salt = UUID.randomUUID().toString();
                PasswordUtil encoderMd5 = new PasswordUtil(salt, "sha-256");
                String encodedPassword = encoderMd5.encode(sysUserDTO.getPassword());
                sysUser.setSalt(salt);
                sysUser.setPassword(encodedPassword);
            }
            sysUser.setPhone(sysUserDTO.getPhone());
            sysUser.setUpdateTime(new Date());
            sysUser.setUsername(sysUserDTO.getUserName());
            sysUser.setUserId(sysUserDTO.getUserId());
            sysUser.setStatus(sysUserDTO.getStatus());
            try {
                sysUserMapper.updateByPrimaryKey(sysUser);
                sysUserRoleMapper.updateByUserId(sysUserDTO.getUserId(),sysUserDTO.getRoleId());
            } catch (Exception e) {
                LOGGER.error("编辑人员失败" + e.getMessage(),e);
                result.setCode(500);
                result.setError(e.getMessage());
                result.setError_description("编辑人员失败");
                return result;
            }
        }
        return result;
    }

    @Override
    public ResponseResult userList(SysUserDTO sysUserDTO) {
       ResponseResult result = new ResponseResult();
        List<SysUser> sysUsers = sysUserMapper.selectByExample(null);
        for (SysUser sysUser : sysUsers) {
            SysUserRole sysUserRole = sysUserRoleMapper.findByUserId(sysUser.getUserId());

        }

        return null;
    }


}
