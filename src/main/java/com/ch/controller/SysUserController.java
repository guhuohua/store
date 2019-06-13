package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.dto.SysUserDTO;
import com.ch.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysUserController {

    @Autowired
    SysUserService sysUserService;


    private static final Logger LOGGER = LogManager.getLogger(SysUserController.class);


    @PostMapping(value = "insert_or_update")
    @RequiresPermissions(logical = Logical.OR, value = {"sys_person_mange_insert","sys_person_mange_edit","sys_person_mange_mange"})
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
}
