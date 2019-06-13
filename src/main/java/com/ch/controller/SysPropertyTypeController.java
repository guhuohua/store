package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.PropertyType;
import com.ch.service.SysPropertyTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "base")
@Api(value = "基础配置")
public class SysPropertyTypeController {
    @Autowired
    SysPropertyTypeService sysPropertyTypeService;

    @PostMapping("editPropertyType")
    @ApiOperation("编辑物业类型")
    public ResponseResult editPropertyType(PropertyType propertyType) {
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
    public ResponseResult listPropertyType(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
            sysPropertyTypeService.listPropertyType(sysBaseDTO);

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
    public ResponseResult delePropertyType(Long id)  {
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
