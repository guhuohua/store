package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysUserDTO;
import com.ch.dto.UserDTO;

public interface SysUserService {
    /**
     * 根据主键ID进行查找实体对象
     * @param userId
     * @return
     */
   UserDTO findById(Integer userId);

    /**
     * 登录
     * @param userDTO
     * @return
     */
    ResponseResult login(UserDTO userDTO);


    /**
     * 人员管理
     * @param sysUserDTO
     * @return
     */

    ResponseResult updateOrInsertUser(SysUserDTO sysUserDTO);
}
