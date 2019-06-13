package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.ShopRentType;
import com.ch.service.SysRentShopService;
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
public class SysShopRentTypeController {
    @Autowired
    SysRentShopService sysRentShopService;

    @PostMapping("editRentShopType")
    @ApiOperation("编辑店铺类型")
    public ResponseResult editShopType(ShopRentType shopRentType) {
        ResponseResult result = new ResponseResult();
        try {
            if (BeanUtils.isNotEmpty(shopRentType.getId())) {
                sysRentShopService.updateShopRentType(shopRentType);
            } else {
                sysRentShopService.addShopRentType(shopRentType);
            }
        } catch (Exception e) {
            log.error("编辑租铺店铺类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑租铺店铺类型失败");
        }
        return result;
    }


    @PostMapping("listRentShopType")
    @ApiOperation("物业类型列表")
    public ResponseResult listRentShopType(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        try {
            sysRentShopService.listShopRentType(sysBaseDTO);

        } catch (Exception e) {
            log.error("物业类型列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("物业类型列表失败");
        }
        return result;
    }

    @GetMapping("deleRentShopType")
    @ApiOperation("删除租铺类型")
    public ResponseResult delRentShopType(Long id)  {
        ResponseResult result = new ResponseResult();
        try {
            sysRentShopService.deleShopRentType(id);
        } catch (Exception e) {
            log.error("删除租铺类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除租铺类型失败");
        }
        return result;
    }
}
