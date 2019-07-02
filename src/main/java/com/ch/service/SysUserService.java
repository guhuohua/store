package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysUserDTO;
import com.ch.dto.UserDTO;
import com.ch.dto.UserParms;
import com.ch.model.PasswordParam;

public interface SysUserService {
    /**
     * 根据主键ID进行查找实体对象
     *
     * @param userId
     * @return
     */
    UserDTO findById(Long userId);

    /**
     * 登录
     *
     * @param userDTO
     * @return
     */
    ResponseResult login(UserDTO userDTO);


    /**
     * 修改添加人员
     *
     * @param sysUserDTO
     * @return
     */

    ResponseResult updateOrInsertUser(SysUserDTO sysUserDTO);

    /**
     * 展示人员列表
     *
     * @param userParms
     * @return
     */
    ResponseResult userList(UserParms userParms);



    /**
     * 展示中介列表
     *
     * @param userParms
     * @return
     */
    ResponseResult agentList(UserParms userParms);


    /**
     * 重置密码
     *
     * @param userId
     * @return
     */
    ResponseResult resetPassword(Long userId);

    /**
     * 修改人员状态
     *
     * @param userId
     * @param status
     * @return
     */
    ResponseResult updateUserStatus(Long userId, int status);


    ResponseResult findRoleList();

    ResponseResult updatePassword(PasswordParam passwordParam);

    /**
     * @param userId
     * @return
     */
    ResponseResult dele(Long userId);

    /**
     * 经营范围
     * @return
     */
    ResponseResult findBusiness();


    /**
     * 根据id查询人员信息
     * @param userId
     * @return
     */
    ResponseResult findByUserId(Long userId);

}
