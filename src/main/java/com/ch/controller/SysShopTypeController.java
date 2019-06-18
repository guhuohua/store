package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.ShopType;
import com.ch.service.SysShopTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "base")
@Api(value = "基础配置")
public class SysShopTypeController {

    @Autowired
    SysShopTypeService sysShopTypeService;

    @PostMapping("editShopType")
    @ApiOperation("编辑店铺类型")
    public ResponseResult editShopType(@RequestBody ShopType shopType) {
        ResponseResult result = new ResponseResult();
        try {
            if (BeanUtils.isNotEmpty(shopType.getId())) {
                sysShopTypeService.updateShopType(shopType);
            } else {
                sysShopTypeService.addShopType(shopType);
            }
        } catch (Exception e) {
            log.error("编辑店铺类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑店铺类型失败");
        }
        return result;
    }


    @PostMapping("listShopType")
    @ApiOperation("店铺类型列表")
    public ResponseResult listShopType(@RequestBody SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
          result =  sysShopTypeService.listShopType(sysBaseDTO);

        } catch (Exception e) {
            log.error("店铺类型列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("店铺类型列表失败");
        }
        return result;
    }

    @GetMapping("deleShopType")
    @ApiOperation("删除店铺类型")
    public ResponseResult delShopType(@RequestParam Long id)  {
        ResponseResult result = new ResponseResult();
        try {
            sysShopTypeService.deleShopType(id);
        } catch (Exception e) {
            log.error("删除店铺类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除店铺类型失败");
        }
        return result;
    }
}
