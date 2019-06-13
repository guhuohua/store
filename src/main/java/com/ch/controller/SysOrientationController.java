package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.Orientation;
import com.ch.service.SysOrientationService;
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
public class SysOrientationController {
    @Autowired
    SysOrientationService sysOrientationService;

    @PostMapping("editOrientation")
    @ApiOperation("编辑朝向")
    public ResponseResult editOrientation(Orientation orientation) {
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
    public ResponseResult listOrientation(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
            sysOrientationService.listOrientation(sysBaseDTO);

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
    public ResponseResult deleOrientation(Long id)  {
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
