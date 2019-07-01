package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.dto.CityDTO;
import com.ch.dto.SysUserDTO;
import com.ch.dto.UserParms;
import com.ch.model.PasswordParam;
import com.ch.service.SysUserService;
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
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/sys/user")
@Slf4j
@Api(value = "人员管理")
@RestController
public class SysUserController {

    @Autowired
    SysUserService sysUserService;


    private static final Logger LOGGER = LogManager.getLogger(SysUserController.class);


    @PostMapping(value = "insert_or_update")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_person_mange_add","sys_person_mange_edit","sys_person_mange"})
    @ApiOperation("新增编辑人员")
    public ResponseResult insertOrUpdate(HttpServletRequest req, HttpServletResponse res, @RequestBody SysUserDTO sysUserDTO) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.updateOrInsertUser(sysUserDTO);
        } catch (Exception e) {
            LOGGER.error("新增或编辑人员失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }



    @PostMapping(value = "insertUpdateAgent")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_mediation_add","sys_mediation_edit","sys_mediation_in"})
    @ApiOperation("新增编辑中介")
    public ResponseResult insertUpdateAgent(HttpServletRequest req, HttpServletResponse res, @RequestBody SysUserDTO sysUserDTO) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.updateOrInsertUser(sysUserDTO);
        } catch (Exception e) {
            LOGGER.error("新增编辑中介失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }

    @PostMapping(value = "userList")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_person_mange_see","sys_person_mange"})
    @ApiOperation("展示人员列表")
    public ResponseResult userList(HttpServletRequest req, HttpServletResponse res, @RequestBody UserParms userParms) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.userList(userParms);
        } catch (Exception e) {
            LOGGER.error("展示人员列表失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }


    @PostMapping(value = "agentList")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_mediation_see","sys_mediation_in"})
    @ApiOperation("展示中介列表")
    public ResponseResult agentList(HttpServletRequest req, HttpServletResponse res, @RequestBody UserParms userParms) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.agentList(userParms);
        } catch (Exception e) {
            LOGGER.error("展示中介列表失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }



    @GetMapping(value = "resetPassword")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_person_mange_reset","sys_person_mange"})
    @ApiOperation("重置密码")
    public ResponseResult resetPassword( @RequestParam  Long userId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.resetPassword(userId);
        }
        catch (Exception e) {
        LOGGER.error("重置密码失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());

            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }


    @GetMapping(value = "updateUserStatus")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_person_mange_edit","sys_person_mange"})
    @ApiOperation("修改人员状态失败")
    public ResponseResult updateUserStatus( @RequestParam Long userId,@RequestParam int status) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.updateUserStatus(userId,status);
        }
        catch (Exception e) {
            LOGGER.error("修改人员状态失败失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }


    @GetMapping(value = "findRoleList")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_person_mange_see","sys_person_mange"})
    @ApiOperation("查询所有角色")
    public ResponseResult findRoleList() {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.findRoleList();
        }
        catch (Exception e) {
            LOGGER.error("查询所有角色失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }


    @PostMapping(value = "updatePassword")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_person_mange_edit_password","sys_person_mange"})
    @ApiOperation("修改密码")
    public ResponseResult updatePassword(@RequestBody PasswordParam passwordParam) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.updatePassword(passwordParam);
        }
        catch (Exception e) {
            LOGGER.error("修改密码失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }
    @GetMapping(value = "deleUser")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_person_mange_dele","sys_person_mange"})
    @ApiOperation("删除人员")
    public ResponseResult delePassword(@RequestParam Long userId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysUserService.dele(userId);
        }
        catch (Exception e) {
            LOGGER.error("删除人员失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }


    @GetMapping(value = "getCity")
    @ApiOperation("获取城市")
    public ResponseResult getCity() {
        ResponseResult result = new ResponseResult();
        try {
            List list = new ArrayList();
            CityDTO cityDTO = new CityDTO(169,"武汉");
            list.add(cityDTO);
            result.setData(list);
            return  result;
        }
        catch (Exception e) {
            LOGGER.error("获取城市失败" + e.getMessage(), e);
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("服务异常，请稍后重试");
        }
        return result;
    }
}
