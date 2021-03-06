package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.SubwayLine;
import com.ch.service.SysSubwayService;
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
public class SysSubwayController {
    @Autowired
    SysSubwayService sysSubwayService;

    @PostMapping("editSubwayLine")
    @ApiOperation("编辑地铁线")
    @RequiresPermissions(logical = Logical.OR, value = {"subway_line_add","subway_line_edit","subway_line"})
    public ResponseResult editSubwayLine(@RequestBody SubwayLine subwayLine) {
        ResponseResult result = new ResponseResult();
        try {
            if (BeanUtils.isNotEmpty(subwayLine.getId())) {
                sysSubwayService.updateSubwayLine(subwayLine);
            } else {
                sysSubwayService.addSubwayLine(subwayLine);
            }
        } catch (Exception e) {
            log.error("编辑地铁线失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑地铁线失败");
        }
        return result;
    }


    @PostMapping("listSubwayLine")
    @ApiOperation("地铁线列表")
    @RequiresPermissions(logical = Logical.OR, value = {"subway_line_see","subway_line"})
    public ResponseResult listSubwayLine(@RequestBody SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
           result =  sysSubwayService.listSubwayLine(sysBaseDTO);

        } catch (Exception e) {
            log.error("地铁线列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("地铁线列表失败");
        }
        return result;
    }

    @GetMapping("deleSubwayLine")
    @ApiOperation("删除地铁线")
    @RequiresPermissions(logical = Logical.OR, value = {"subway_line_dele","subway_line"})
    public ResponseResult deleLoopLine(@RequestParam Long id)  {
        ResponseResult result = new ResponseResult();
        try {
            sysSubwayService.deleSubwayLine(id);
        } catch (Exception e) {
            log.error("deleSubwayLine失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("deleSubwayLine 失败");
        }
        return result;
    }
}
