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
     * 修改添加人员
     * @param sysUserDTO
     * @return
     */

    ResponseResult updateOrInsertUser(SysUserDTO sysUserDTO);

    /**
     * 展示人员列表
     *
     * @param sysUserDTO
     * @return
     */
    ResponseResult userList(SysUserDTO sysUserDTO);
}
