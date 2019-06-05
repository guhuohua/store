/**
 * Author: 常富文
 * Date:   2019/6/5 14:40
 * Description:
 */

package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.service.SysLookShopService;
import com.ch.service.ViewLookShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/sys/lookShop")
@Slf4j
@Api(value = "后台找铺列表")
@RestController

public class SysLookShopController {

    @Autowired
    SysLookShopService sysLookShopService;
    @Autowired
    ViewLookShopService viewLookShopService;
    @GetMapping("showLookShopList")
    @ApiOperation("展示后台找铺列表")
    public ResponseResult showLookShopList() {
        ResponseResult result = new ResponseResult();
        try {
            result = sysLookShopService.showLookShopList();
        } catch (Exception e) {
            log.error("获取找铺详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取找铺详情失败");
        }
        return result;
    }


    @GetMapping("showLookShopInfo")
    @ApiOperation("展示后台找铺详情")
    public ResponseResult showLookShopInfo(Long storeId) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewLookShopService.lookShopInfo(storeId);
        } catch (Exception e) {
            log.error("获取找铺详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取找铺详情失败");
        }
        return result;
    }
}
