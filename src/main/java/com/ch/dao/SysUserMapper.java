package com.ch.dao;


import com.ch.dao.provider.BtSysUserProvider;
import com.ch.dto.SysUserMangerDTO;
import com.ch.entity.SysUser;
import com.ch.entity.SysUserExample;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    @SelectProvider(type = BtSysUserProvider.class, method = "getUserList")
    @Results({
            @Result(column = "username", property = "userName", javaType = String.class),
            @Result(column = "phone", property = "phone", javaType = String.class),
            @Result(column = "role_desc", property = "roleName", javaType = String.class),
            @Result(column = "account", property = "account", javaType = String.class),
            @Result(column = "status", property = "status", javaType = Integer.class),
            @Result(column = "update_time", property = "createDate", javaType = String.class),
            @Result(column = "user_id", property = "userId", javaType = String.class),
            @Result(column = "role_id", property = "roleId", javaType = String.class)
    })
    List<SysUserMangerDTO> btUserList(@Param("userName") String userName, @Param("phone") String phone);



    /**
     * 后台重置密码
     * @param userId
     * @return
     */
    @Update("update sys_user set password = '@g0c211aa0bc22ccb@0g5F4*1fcf3@24c@#@2g1aa06a2dc20@66#*d0@4c2c216', salt = '0bdf8d16-159d-4ebe-8a93-506a14d1df2d' where user_id = #{userId}")
    int resetPassword(@Param("userId") Long userId);


    /**
     * 后台修改人员状态
     * @param userId
     * @return
     */
    @Update("update sys_user set password = #{status} where user_id = #{userId}")
    int updateStatus(@Param("userId") Long userId, @Param("status") int status);

}