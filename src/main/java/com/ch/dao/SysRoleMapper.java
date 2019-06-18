package com.ch.dao;


import com.ch.entity.SysRole;
import com.ch.entity.SysRoleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    /**
     * 根据ID修改实体对象
     * @param btSysRole
     * @return
     */
    @Update("update sys_role set role_name = #{btSysRole.roleName}, role_desc = #{btSysRole.roleDesc}, update_time = now() where role_id = #{btSysRole.roleId}")
    int update(@Param("btSysRole") SysRole btSysRole);
}