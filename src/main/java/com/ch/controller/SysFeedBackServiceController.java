package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.service.SysFeedBackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "feedBack")
@Api(value = "意见反馈")
public class SysFeedBackServiceController {

    @Autowired
    SysFeedBackService sysFeedBackService;


    @PostMapping("list")
    @ApiOperation("意见反馈列表")
    @RequiresPermissions(logical = Logical.OR, value = {"apply_list_see","apply_list"})
    public ResponseResult list(@RequestBody SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysFeedBackService.list(sysBaseDTO);
        } catch (Exception e) {
            log.error("展示意见反馈列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("展示意见反馈列表失败");
        }
        return result;
    }



    @GetMapping("dele")
    @ApiOperation("删除意见反馈")
    @RequiresPermissions(logical = Logical.OR, value = {"apply_list_see","apply_list"})
    public ResponseResult dele(@RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysFeedBackService.dele(id);
        } catch (Exception e) {
            log.error("删除意见反馈失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除意见反馈失败");
        }
        return result;
    }
}
