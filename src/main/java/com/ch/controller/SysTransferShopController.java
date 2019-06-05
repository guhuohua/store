/**
 * Author: 常富文
 * Date:   2019/6/5 10:38
 * Description:
 */

package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.service.SysTransferShopService;
import com.ch.service.ViewTransferShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/sys/transferShop")
@Slf4j
@Api(value = "后台转铺列表")
@RestController

public class SysTransferShopController {

    @Autowired
    SysTransferShopService sysTransferShopService;
    @Autowired
    ViewTransferShopService viewTransferShopService;


    @GetMapping("showTransferShopList")
    @ApiOperation("展示后台转铺列表")
    public ResponseResult showTransferShopList() {
        ResponseResult result = new ResponseResult();
        try {
            result = sysTransferShopService.showTransferShopList();
        } catch (Exception e) {
            log.error("获取转铺详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取转铺详情失败");
        }
        return result;
    }


    @GetMapping("showTransferShopInfo")
    @ApiOperation("展示后台转铺详情")
    public ResponseResult showTransferShopInfo(Long storeId) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.transferShopInfo(storeId);
        } catch (Exception e) {
            log.error("获取转铺详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取转铺详情失败");
        }
        return result;
    }


    @GetMapping("updateStatus")
    @ApiOperation("审核状态")
    public ResponseResult updateStatus(Long storeId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysTransferShopService.updateStatus(storeId);
        } catch (Exception e) {
            log.error("审核状态失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("审核状态失败");
        }
        return result;
    }


}
