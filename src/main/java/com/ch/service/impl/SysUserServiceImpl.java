/**
 * Author: 常富文
 * Date:   2019/6/3 17:06
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.dto.UserDTO;
import com.ch.entity.*;
import com.ch.service.SysUserService;
import com.ch.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class SysUserServiceImpl implements SysUserService {


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
    public UserDTO findById(Integer userId) {
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
}
