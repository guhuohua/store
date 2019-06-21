/**
 * Author: 常富文
 * Date:   2019/6/5 14:40
 * Description:
 */

package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.dto.ShowShopDto;
import com.ch.service.SysLookShopService;
import com.ch.service.ViewLookShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/sys/lookShop")
@Slf4j
@Api(value = "后台找铺列表")
@RestController

public class SysLookShopController {

    @Autowired
    SysLookShopService sysLookShopService;
    @Autowired
    ViewLookShopService viewLookShopService;
    @PostMapping ("showLookShopList")
    @ApiOperation("展示后台找铺列表")
    @RequiresPermissions(logical = Logical.OR, value = {"look_shop_manage_list","look_shop_manage_see_list"})
    public ResponseResult showLookShopList(@RequestBody ShowShopDto pageInfo) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysLookShopService.showLookShopList( pageInfo);
        } catch (Exception e) {
            log.error("获取找铺列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取找铺列表失败");
        }
        return result;
    }


    @GetMapping("showLookShopInfo")
    @ApiOperation("展示后台找铺详情")
    public ResponseResult showLookShopInfo(@RequestParam Long storeId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysLookShopService.lookShopInfo(storeId);
        } catch (Exception e) {
            log.error("获取找铺详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取找铺详情失败");
        }
        return result;
    }




}
