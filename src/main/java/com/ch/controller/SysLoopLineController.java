package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.LoopLine;
import com.ch.service.SysLoopLineService;
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
public class SysLoopLineController {
    @Autowired
    SysLoopLineService sysLoopLineService;

    @PostMapping("editLoopLine")
    @ApiOperation("编辑换线")
    @RequiresPermissions(logical = Logical.OR, value = {"loop_line_add","loop_line_edit","loop_line"})
    public ResponseResult editShopType(@RequestBody LoopLine loopLine) {
        ResponseResult result = new ResponseResult();
        try {
            if (BeanUtils.isNotEmpty(loopLine.getId())) {
                sysLoopLineService.updateLoopLine(loopLine);
            } else {
                sysLoopLineService.addLoopLine(loopLine);
            }
        } catch (Exception e) {
            log.error("编辑换线失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑换线失败");
        }
        return result;
    }


    @PostMapping("listLoopLine")
    @ApiOperation("换线列表")
    @RequiresPermissions(logical = Logical.OR, value = {"loop_line_see","loop_line"})
    public ResponseResult listLoopLine(@RequestBody SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
          result =   sysLoopLineService.list(sysBaseDTO);

        } catch (Exception e) {
            log.error("环线列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("环线列表失败");
        }
        return result;
    }

    @GetMapping("deleLoopLine")
    @ApiOperation("删除环线")
    @RequiresPermissions(logical = Logical.OR, value = {"loop_line_dele","loop_line"})
    public ResponseResult deleLoopLine(@RequestParam Long id)  {
        ResponseResult result = new ResponseResult();
        try {
            sysLoopLineService.deleShopType(id);
        } catch (Exception e) {
            log.error("删除环线失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除环线失败");
        }
        return result;
    }
}
