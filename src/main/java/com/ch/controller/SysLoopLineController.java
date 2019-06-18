package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.LoopLine;
import com.ch.service.SysLoopLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseResult listLoopLine(@RequestBody SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
          result =   sysLoopLineService.list(sysBaseDTO);

        } catch (Exception e) {
            log.error("换线列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("换线列表失败");
        }
        return result;
    }

    @GetMapping("deleLoopLine")
    @ApiOperation("删除环线")
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
