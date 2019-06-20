package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.PropertyType;
import com.ch.service.SysPropertyTypeService;
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
public class SysPropertyTypeController {
    @Autowired
    SysPropertyTypeService sysPropertyTypeService;

    @PostMapping("editPropertyType")
    @ApiOperation("编辑物业类型")
    @RequiresPermissions(logical = Logical.OR, value = {"property_add","property_edit","property_type"})
    public ResponseResult editPropertyType(@RequestBody PropertyType propertyType) {
        ResponseResult result = new ResponseResult();
        try {
            if (BeanUtils.isNotEmpty(propertyType.getId())) {
                sysPropertyTypeService.updatePropertyType(propertyType);
            } else {
                sysPropertyTypeService.addPropertyType(propertyType);
            }
        } catch (Exception e) {
            log.error("编辑物业类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑物业类型失败");
        }
        return result;
    }


    @PostMapping("listPropertyType")
    @ApiOperation("物业类型列表")
    @RequiresPermissions(logical = Logical.OR, value = {"property_see","property_type"})
    public ResponseResult listPropertyType( @RequestBody SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
            result =  sysPropertyTypeService.listPropertyType(sysBaseDTO);

        } catch (Exception e) {
            log.error("物业类型列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("物业类型列表失败");
        }
        return result;
    }

    @GetMapping("delePropertyType")
    @ApiOperation("删除物业类型")
    @RequiresPermissions(logical = Logical.OR, value = {"property_dele","property_type"})
    public ResponseResult delePropertyType(@RequestParam Long id)  {
        ResponseResult result = new ResponseResult();
        try {
            sysPropertyTypeService.delePropertyType(id);
        } catch (Exception e) {
            log.error("删除物业类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除物业类型失败");
        }
        return result;
    }


}
