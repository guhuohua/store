package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.entity.BusinessType;
import com.ch.service.SysBusinessTypeService;
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
public class SysBusinessTypeController {

    @Autowired
    SysBusinessTypeService sysBusinessTypeService;

    @PostMapping("editBusinessType")
    @ApiOperation("编辑经营范围")
    @RequiresPermissions(logical = Logical.OR, value = {"business_parent_type_add","business_parent_type_edit","business_parent_type"})
    public ResponseResult editBusinessType(@RequestBody BusinessType businessType) {
        ResponseResult result = new ResponseResult();
        try {
            if (BeanUtils.isNotEmpty(businessType.getId())) {
                sysBusinessTypeService.upBusinessType(businessType);
            } else {
                sysBusinessTypeService.addBusinessType(businessType);
            }
        } catch (Exception e) {
            log.error("编辑经营范围失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑经营范围失败");
        }
        return result;
    }


    @PostMapping("listBusinessType")
    @ApiOperation("经营范围列表")
    @RequiresPermissions(logical = Logical.OR, value = {"business_parent_type_see","business_parent_type"})
    public ResponseResult listDecorateType() {
        ResponseResult result = new ResponseResult();
        try {
            result = sysBusinessTypeService.listBusinessType();

        } catch (Exception e) {
            log.error("经营范围表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("经营范围失败");
        }
        return result;
    }

    @GetMapping("deleBusinessType")
    @ApiOperation("删除经营范围")
    @RequiresPermissions(logical = Logical.OR, value = {"business_parent_type_dele","business_parent_type"})
    public ResponseResult deleBusinessType(@RequestParam Long id)  {
        ResponseResult result = new ResponseResult();
        try {
            sysBusinessTypeService.deleBusinessType(id);
        } catch (Exception e) {
            log.error("删除经营范围" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除经营范围");
        }
        return result;
    }

}
