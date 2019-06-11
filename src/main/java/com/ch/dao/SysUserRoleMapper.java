package com.ch.dao;


import java.util.List;

import com.ch.entity.SysUserRole;
import com.ch.entity.SysUserRoleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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
    @Update("update bt_sys_user_role set role_id = #{roleId} where user_id = #{userId}")
    int updateByUserId(@Param("userId") Integer userId, @Param("roleId") Integer roleId);


}