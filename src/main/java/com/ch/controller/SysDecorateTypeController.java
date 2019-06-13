package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.DecorateType;
import com.ch.service.SysDecorateTypeService;
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
public class SysDecorateTypeController {
   
   @Autowired
    SysDecorateTypeService sysDecorateTypeService;
   
   
    @PostMapping("editDecorateType")
    @ApiOperation("编辑装修类型")
    public ResponseResult editDecorateType(DecorateType decorateType) {
        ResponseResult result = new ResponseResult();
        try {
            if (BeanUtils.isNotEmpty(decorateType.getId())) {
                sysDecorateTypeService.updateDecorateType(decorateType);
            } else {
                sysDecorateTypeService.addDecorateType(decorateType);
            }
        } catch (Exception e) {
            log.error("编辑装修类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑装修类型失败");
        }
        return result;
    }


    @PostMapping("listDecorateType")
    @ApiOperation("装修类型列表")
    public ResponseResult listDecorateType(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
            sysDecorateTypeService.listDecorateType(sysBaseDTO);

        } catch (Exception e) {
            log.error("装修类型列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("装修类型列表失败");
        }
        return result;
    }

    @GetMapping("deleDecorateType")
    @ApiOperation("删除装修类型")
    public ResponseResult deleDecorateType(Long id)  {
        ResponseResult result = new ResponseResult();
        try {
            sysDecorateTypeService.deleDecorateType(id);
        } catch (Exception e) {
            log.error("删除装修类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除装修类型失败");
        }
        return result;
    }


}
