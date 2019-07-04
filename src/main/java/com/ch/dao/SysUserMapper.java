package com.ch.dao;


import com.ch.dao.provider.BtSysUserProvider;
import com.ch.dao.provider.SysUserMapperProvider;
import com.ch.dto.SysUserMangerDTO;
import com.ch.dto.ViewExpertInfoDTO;
import com.ch.dto.ViewExpertOnlineDTO;
import com.ch.entity.SysUser;
import com.ch.entity.SysUserExample;
import com.ch.model.RolePermissionModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long userId);

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
            @Result(column = "user_id", property = "userId", javaType = Long.class),
            @Result(column = "role_id", property = "roleId", javaType = Integer.class)
    })
    List<SysUserMangerDTO> btUserList(@Param("userName") String userName, @Param("phone") String phone);




    @SelectProvider(type = BtSysUserProvider.class, method = "getAgentList")
    @Results({
            @Result(column = "username", property = "userName", javaType = String.class),
            @Result(column = "phone", property = "phone", javaType = String.class),
            @Result(column = "role_desc", property = "roleName", javaType = String.class),
            @Result(column = "account", property = "account", javaType = String.class),
            @Result(column = "status", property = "status", javaType = Integer.class),
            @Result(column = "update_time", property = "createDate", javaType = String.class),
            @Result(column = "user_id", property = "userId", javaType = Long.class),
            @Result(column = "role_id", property = "roleId", javaType = Integer.class),
            @Result(column = "city_id", property = "cityId", javaType = Integer.class)

    })
    List<SysUserMangerDTO> btAgentList(@Param("userName") String userName, @Param("phone") String phone);

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


    /**
     * 查询所有角色权限
     * @return
     */
    @Select("select permission_id,name,parent_id,sort from sys_permission")
    @Results({
            @Result(column = "permission_id", property = "permissionId", javaType = Integer.class),
            @Result(column = "name", property = "permissionName", javaType = String.class),
            @Result(column = "parent_id", property = "parentId", javaType = Integer.class),
            @Result(column = "sort", property = "sortOrder", javaType = Integer.class)
    })
    List<RolePermissionModel> findAll();


    /**
     * 根据角色ID查询对应权限
     * @param roleId
     * @return
     */
    @Select("select bsrp.role_id,bsp.permission_id,bsp.name,bsp.parent_id,bsp.sort from sys_role_permission bsrp" +
            "  left join sys_permission bsp on bsp.permission_id = bsrp.permission_id where bsrp.role_id = #{roleId}")
    @Results({
            @Result(column = "role_id", property = "roleId", javaType = Integer.class),
            @Result(column = "permission_id", property = "permissionId", javaType = Integer.class),
            @Result(column = "name", property = "permissionName", javaType = String.class),
            @Result(column = "parent_id", property = "parentId", javaType = Integer.class),
            @Result(column = "sort", property = "sortOrder", javaType = Integer.class)
    })
    List<RolePermissionModel> findAllByRoleId(@Param("roleId") Integer roleId);


    @SelectProvider(type = SysUserMapperProvider.class, method = "getUserList")
    List<ViewExpertOnlineDTO> expertOnlineList(@Param("businessId") Long businessId, @Param("index") Integer index, @Param("size") Integer size);

    @SelectProvider(type = SysUserMapperProvider.class, method = "getUserListCount")
    int expertOnlineListCount();

    @Select("select su.user_id as id, su.head_image, su.username as name, su.phone ,su.serviceCount as count from sys_user su where su.user_id = #{id}")
    ViewExpertInfoDTO info(@Param("id") Long id);
}