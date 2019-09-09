package com.ch.dao;


import com.ch.entity.SysUserRole;
import com.ch.entity.SysUserRoleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleMapper {
    int countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(SysUserRole key);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    /**
     * 根据用户ID修改角色ID
     * @param userId
     * @param roleId
     * @return
     */
    @Update("update sys_user_role set role_id = #{roleId} where user_id = #{userId}")
    int updateByUserId(@Param("userId") Long userId, @Param("roleId") Integer roleId);


    /**
     * 根据用户ID修改角色ID
     * @param userId
     * @param
     * @return
     */
    @Update("update sys_user_role set role_id = 12 where user_id = #{userId}")
    int updateByUserId1(@Param("userId") Long userId);

    @Select("select * from sys_user_role t  where t.user_id = #{userId}")
    SysUserRole findByUserId(@Param("userId") Long userId);



}