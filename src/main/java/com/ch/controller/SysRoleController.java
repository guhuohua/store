package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.dto.RoleDTO;
import com.ch.model.RoleParam;
import com.ch.model.RolePermissionDTO;
import com.ch.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping(value = "sys/role")
@Api(value = "角色管理")
public class SysRoleController {

    private static final Logger LOGGER = LogManager.getLogger(SysRoleController.class);
    @Autowired
    SysRoleService sysRoleService;

    @PostMapping(value = "editRole")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_mange_role_add","sys_mange_role"})
    @ApiOperation("编辑角色")
    public ResponseResult insertRole(HttpServletRequest req, HttpServletResponse res, @RequestBody RoleDTO roleDTO) {
        ResponseResult result = new ResponseResult();
        try {
           if (null != roleDTO.getRoleId()){
               sysRoleService.editRole(roleDTO);
           }else {
               sysRoleService.insertRole(roleDTO);
           }
        } catch (Exception e) {
            LOGGER.error("新增角色失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("新增角色失败");
        }
        return result;
    }



    @PostMapping(value = "roleList")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_mange_role_see","sys_mange_role"})
    @ApiOperation("获取角色列表")
    public ResponseResult roleList(HttpServletRequest req, HttpServletResponse res, @RequestBody RoleParam roleParam) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysRoleService.findRoleList(roleParam);
        } catch (Exception e) {
            LOGGER.error("获取角色列表失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("获取角色列表失败");
        }
        return result;
    }

    @GetMapping (value = "deleteRoles")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_mange_role_dele","sys_mange_role"})
    @ApiOperation("删除角色")
    public ResponseResult deleteRoles(HttpServletRequest req, HttpServletResponse res, @RequestParam Integer roleId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysRoleService.deleteRoles(roleId);
        } catch (Exception e) {
            LOGGER.error("删除角色失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("删除角色失败");
        }
        return result;
    }

    @GetMapping(value = "findPermission")
    @ApiOperation("查询权限")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_mange_role_setup","sys_mange_role"})

    public ResponseResult findPermission(HttpServletRequest req, HttpServletResponse res, @RequestParam Integer roleId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysRoleService.findPermissionByRoleId(roleId);
        } catch (Exception e) {
            LOGGER.error("查询权限失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("查询权限失败");
        }
        return result;
    }


    @PostMapping(value = "savePermission")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_mange_role_setup_new","sys_mange_role_setup"})
    @ApiOperation("添加权限")
    public ResponseResult savePermission(HttpServletRequest req, HttpServletResponse res, @RequestBody RolePermissionDTO rolePermissionDTO) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysRoleService.insertPermission(rolePermissionDTO);
        } catch (Exception e) {
            LOGGER.error("添加权限失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("添加权限失败");
        }
        return result;
    }
}
