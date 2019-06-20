package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.RoleDTO;
import com.ch.model.RoleParam;
import com.ch.model.RolePermissionDTO;

public interface SysRoleService {
   /**
    * 获取角色列表
    * @param
    * @return
    */
   ResponseResult findRoleList(RoleParam roleParam);


   /**
    * 增加角色
    * @param roleDTO
    * @return
    */
   ResponseResult insertRole(RoleDTO roleDTO);


   /**
    * 批量删除或单个删除
    * @param
    * @return
    */
   ResponseResult deleteRoles(Integer roleId);

   /**
    * 根据ID进行编辑
    * @param roleDTO
    * @return
    */
   ResponseResult editRole(RoleDTO roleDTO);

   /**
    * 根据角色查询对应权限
    * @param roleId
    * @return
    */
   ResponseResult findPermissionByRoleId(Integer roleId);

   /**
    * 给角色添加权限
    * @param rolePermissionDTO
    * @return
    */
   ResponseResult insertPermission(RolePermissionDTO rolePermissionDTO);

   /**
    * 查询角色
    * @return
    */
   ResponseResult roleList();
}
