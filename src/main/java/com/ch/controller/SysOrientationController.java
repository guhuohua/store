package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.Orientation;
import com.ch.service.SysOrientationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "base")
@Api(value = "基础配置")
public class SysOrientationController {
    @Autowired
    SysOrientationService sysOrientationService;

    @PostMapping("editOrientation")
    @ApiOperation("编辑朝向")
    @RequiresPermissions(logical = Logical.OR, value = {"orientation_add","orientation_edit","orientation"})
    public ResponseResult editOrientation(@RequestBody Orientation orientation) {
        ResponseResult result = new ResponseResult();
        try {
            if (BeanUtils.isNotEmpty(orientation.getId())) {
                sysOrientationService.updateOrientation(orientation);
            } else {
                sysOrientationService.addOrientation(orientation);
            }
        } catch (Exception e) {
            log.error("编辑朝向失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑朝向失败");
        }
        return result;
    }


    @PostMapping("listOrientation")
    @ApiOperation("朝向列表")
    @RequiresPermissions(logical = Logical.OR, value = {"orientation_see","orientation"})
    public ResponseResult listOrientation(@RequestBody SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
         result =    sysOrientationService.listOrientation(sysBaseDTO);

        } catch (Exception e) {
            log.error("朝向列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("朝向列表失败");
        }
        return result;
    }

    @GetMapping("deleOrientation")
    @ApiOperation("删除朝向类型")
    @RequiresPermissions(logical = Logical.OR, value = {"orientation_dele","orientation"})
    public ResponseResult deleOrientation(@RequestParam Long id)  {
        ResponseResult result = new ResponseResult();
        try {
            sysOrientationService.deleOrientation(id);
        } catch (Exception e) {
            log.error("删除朝向类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除朝向类型失败");
        }
        return result;
    }
}
