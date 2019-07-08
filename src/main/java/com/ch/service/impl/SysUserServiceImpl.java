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
import com.ch.dto.SysUserMangerDTO;
import com.ch.dto.UserDTO;
import com.ch.dto.UserParms;
import com.ch.entity.*;
import com.ch.model.PasswordParam;
import com.ch.service.SysUserService;
import com.ch.util.IdUtil;
import com.ch.util.PasswordUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    BusinessTypeMapper businessTypeMapper;
    @Autowired
    SysUserBusinessMapper sysUserBusinessMapper;
    @Autowired
    BsCityMapper bsCityMapper;


    @Override
    @Cacheable(value = "findById", key = "'userId'+#userId")
    public UserDTO findById(Long userId) {
        UserDTO dto = (UserDTO) redisTemplate.boundHashOps("userDto").get(userId);
        if (null == dto) {
            dto = new UserDTO();
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
            if (sysUser != null) {
                dto.setUserId(sysUser.getUserId());
                dto.setUsername(sysUser.getUsername());
                SysUserRoleExample example = new SysUserRoleExample();
                SysUserRoleExample.Criteria criteria = example.createCriteria();
                criteria.andUserIdEqualTo(userId);
                List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(example);
                Set<String> roles = new HashSet<>();
                Set<String> permissions = new HashSet<>();
                for (SysUserRole role : sysUserRoles) {
                    if (role != null) {
                        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(role.getRoleId());
                        SysRolePermissionExample example1 = new SysRolePermissionExample();
                        SysRolePermissionExample.Criteria criteria1 = example1.createCriteria();
                        criteria1.andRoleIdEqualTo(role.getRoleId());
                        List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(example1);
                        dto.setSysRolePermissions(sysRolePermissions);
                        for (SysRolePermission rolePermission : sysRolePermissions) {
                            SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(rolePermission.getPermissionId());
                            // System.out.println(sysPermission);
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
            redisTemplate.boundHashOps("userDto").put(userId, dto);
            return dto;
        } else {
            return dto;
        }


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
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(userDto.getUsername());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if (sysUsers.size() > 0) {
            SysUser sysUser = sysUsers.get(0);
            if (sysUser.getStatus() == 0) {
                result.setCode(500);
                result.setError("该用户已被禁用，请联系管理员");
                result.setError_description("该用户已被禁用，请联系管理员");
                return result;
            }
            PasswordUtil encoderMd5 = new PasswordUtil(sysUser.getSalt(), "sha-256");
            String encodedPassword = encoderMd5.encode(userDto.getPassword());
            if (sysUser.getPassword().equals(encodedPassword)) {
                // System.out.println(sysUser.getUserId());

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

        } else {
            result.setCode(500);
            result.setError("该用户不存在，请重新输入");
            result.setError_description("该用户不存在，请重新输入");
            return result;

        }
    }

    @Override
    @Transactional
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
                btSysUser.setHeadImage(sysUserDTO.getHeadImage());
                btSysUser.setServiceCount(0);
                if (BeanUtils.isNotEmpty(sysUserDTO.getCityId())) {
                    btSysUser.setCityId(sysUserDTO.getCityId());
                }
                for (Long businessTypeId : sysUserDTO.getBusinessTypeId()) {
                    SysUserBusiness sysUserBusiness = new SysUserBusiness();
                    sysUserBusiness.setId(IdUtil.getId());
                    sysUserBusiness.setSysUserId(userId);
                    sysUserBusiness.setBusinessTypeId(businessTypeId);
                    sysUserBusinessMapper.insert(sysUserBusiness);

                }

                sysUserMapper.insert(btSysUser);
                SysUserRole userRole = new SysUserRole();
                userRole.setRoleId(12);
                userRole.setUserId(userId);
                sysUserRoleMapper.insert(userRole);
            } catch (Exception e) {
                LOGGER.error("新增人员失败" + e.getMessage(), e);
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
            SysUser sysUser1 = sysUserMapper.selectByPrimaryKey(sysUserDTO.getUserId());

            sysUser1.setAccount(sysUserDTO.getAccount());
           /* if (BeanUtils.isNotEmpty(sysUserDTO.getPassword())) {
                String salt = UUID.randomUUID().toString();
                PasswordUtil encoderMd5 = new PasswordUtil(salt, "sha-256");
                String encodedPassword = encoderMd5.encode(sysUserDTO.getPassword());
                sysUser.setSalt(salt);
                sysUser.setPassword(encodedPassword);
            }*/
            sysUser1.setPhone(sysUserDTO.getPhone());
            sysUser1.setUpdateTime(new Date());
            sysUser1.setUsername(sysUserDTO.getUserName());
            sysUser1.setUserId(sysUserDTO.getUserId());
            sysUser1.setStatus(sysUserDTO.getStatus());
            sysUser1.setHeadImage(sysUserDTO.getHeadImage());


            if (BeanUtils.isNotEmpty(sysUserDTO.getBusinessTypeId())){
                SysUserBusinessExample example4 = new SysUserBusinessExample();
                SysUserBusinessExample.Criteria criteria = example4.createCriteria();
                criteria.andSysUserIdEqualTo(sysUser1.getUserId());
                sysUserBusinessMapper.deleteByExample(example4);

                for (Long businessTypeId : sysUserDTO.getBusinessTypeId()) {
                    SysUserBusiness sysUserBusiness = new SysUserBusiness();
                    sysUserBusiness.setId(IdUtil.getId());
                    sysUserBusiness.setSysUserId(sysUser1.getUserId());
                    sysUserBusiness.setBusinessTypeId(businessTypeId);
                    sysUserBusinessMapper.insert(sysUserBusiness);

                }
            }



           if (BeanUtils.isNotEmpty(sysUserDTO.getCityId())) {
                sysUser1.setCityId(sysUserDTO.getCityId());
            }
            try {
                sysUserMapper.updateByPrimaryKey(sysUser1);
                sysUserRoleMapper.updateByUserId1(sysUserDTO.getUserId());
            } catch (Exception e) {
                LOGGER.error("编辑人员失败" + e.getMessage(), e);
                result.setCode(500);
                result.setError(e.getMessage());
                result.setError_description("编辑人员失败");
                return result;
            }
        }
        return result;
    }

    @Override
    public ResponseResult userList(UserParms userParms) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(userParms.getPageNum(), userParms.getPageSize());
        List<SysUserMangerDTO> sysUserMangerDTOs = sysUserMapper.btUserList(userParms.getUserName(), userParms.getPhone());

        PageInfo<SysUserMangerDTO> btSysRolePageInfo = new PageInfo<>(sysUserMangerDTOs);
        result.setData(btSysRolePageInfo);
        return result;
    }

    @Override
    public ResponseResult agentList(UserParms userParms) {
        ResponseResult result = new ResponseResult();

        PageHelper.startPage(userParms.getPageNum(), userParms.getPageSize());
        List<SysUserMangerDTO> sysUserMangerDTOs = sysUserMapper.btAgentList(userParms.getUserName(), userParms.getPhone());

        PageInfo<SysUserMangerDTO> btSysRolePageInfo = new PageInfo<>(sysUserMangerDTOs);
        result.setData(btSysRolePageInfo);
        return result;

    }

    @Override
    public ResponseResult resetPassword(Long userId) {

        ResponseResult result = new ResponseResult();
        int resetPassword = sysUserMapper.resetPassword(userId);
        if (resetPassword > 0) {
            return result;
        } else {
            result.setCode(500);
            result.setError("重置密码失败");
            result.setError_description("重置密码失败");
            return result;
        }
    }

    @Override
    public ResponseResult updateUserStatus(Long userId, int status) {
        ResponseResult result = new ResponseResult();
        int resetPassword = sysUserMapper.updateStatus(userId, status);
        if (resetPassword > 0) {
            return result;
        } else {
            result.setCode(500);
            result.setError("修改人员状态失败");
            result.setError_description("修改人员状态失败");
            return result;
        }
    }

    @Override
    public ResponseResult findRoleList() {
        ResponseResult result = new ResponseResult();
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(null);
        result.setData(sysRoles);
        return result;
    }

    @Override
    public ResponseResult updatePassword(PasswordParam passwordParam) {
        ResponseResult result = new ResponseResult();
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(passwordParam.getUserId());
        PasswordUtil encoderMd5 = new PasswordUtil(sysUser.getSalt(), "sha-256");
        String encodedPassword = encoderMd5.encode(passwordParam.getOldPassword());
        if (!encodedPassword.equals(sysUser.getPassword())) {
            result.setCode(600);
            result.setError("请输入正确密码");
            result.setError_description("请输入正确密码");
        } else {
            String salt1 = UUID.randomUUID().toString();
            PasswordUtil encoderMd51 = new PasswordUtil(salt1, "sha-256");
            String encodedPassword1 = encoderMd51.encode(passwordParam.getNewPassword());
            sysUser.setSalt(salt1);
            sysUser.setPassword(encodedPassword1);
            sysUserMapper.updateByPrimaryKey(sysUser);

        }
        return result;
    }

    @Override
    public ResponseResult dele(Long userId) {
        ResponseResult result = new ResponseResult();
        sysUserMapper.deleteByPrimaryKey(userId);
        return result;
    }

    @Override
    public ResponseResult findBusiness() {
        ResponseResult result = new ResponseResult();
        BusinessTypeExample example = new BusinessTypeExample();
        BusinessTypeExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(0L);
        List<BusinessType> businessTypes = businessTypeMapper.selectByExample(example);
        result.setData(businessTypes);
        return result;
    }

    @Override
    public ResponseResult findByUserId(Long userId) {
        ResponseResult result = new ResponseResult();
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        List<Long> BusinessTypeId = new ArrayList<>();
        SysUserBusinessExample example = new SysUserBusinessExample();
        SysUserBusinessExample.Criteria criteria = example.createCriteria();
        criteria.andSysUserIdEqualTo(userId);
        List<SysUserBusiness> sysUserBusinesses = sysUserBusinessMapper.selectByExample(example);
        for (SysUserBusiness sysUserBusiness : sysUserBusinesses) {
            BusinessTypeId.add(sysUserBusiness.getBusinessTypeId());
        }
        BsCity bsCity = bsCityMapper.selectByPrimaryKey(sysUser.getCityId());
        SysUserRoleExample example1 = new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUserIdEqualTo(sysUser.getUserId());
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(example1);
        SysUserRole sysUserRole = null;
        if (sysUserRoles.size() > 0) {
            sysUserRole = sysUserRoles.get(0);
        }
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(sysUserRole.getRoleId());

        SysUserMangerDTO sysUserDTO = new SysUserMangerDTO();
        sysUserDTO.setUserId(sysUser.getUserId());
        sysUserDTO.setUserName(sysUser.getUsername());
        sysUserDTO.setPhone(sysUser.getPhone());
        sysUserDTO.setAccount(sysUser.getAccount());
        sysUserDTO.setStatus(sysUser.getStatus());
        sysUserDTO.setCityId(sysUser.getCityId());
        sysUserDTO.setCityName(bsCity.getCityName());
        sysUserDTO.setHeadImage(sysUser.getHeadImage());
        sysUserDTO.setBusinessTypeId(BusinessTypeId);
        sysUserDTO.setRoleId(sysRole.getRoleId());
        sysUserDTO.setRoleName(sysRole.getRoleName());

        result.setData(sysUserDTO);
        return result;
    }


}
