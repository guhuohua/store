package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.model.ViewTransferShopListParam;
import com.ch.model.ViewTransferShopParam;
import com.ch.service.ViewTransferShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/view/transferShop")
@Slf4j
@Api(value = "转铺接口")
public class ViewTransferShopController {

    @Autowired
    ViewTransferShopService viewTransferShopService;

    @PostMapping("/add")
    @ApiOperation("新增转铺")
    public ResponseResult addTransferShop(@RequestBody ViewTransferShopParam param) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.addTransferShop(param);
        } catch (Exception e) {
            log.error("新增转铺失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("新增转铺失败");
        }
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("转铺列表")
    public ResponseResult addTransferShop(@RequestParam ViewTransferShopListParam param) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.transferShopList(param);
        } catch (Exception e) {
            log.error("获取转铺列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取转铺列表失败");
        }
        return result;
    }

    @GetMapping("/info")
    @ApiOperation("转铺详情")
    public ResponseResult transferShopInfo(@RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.transferShopInfo(id);
        } catch (Exception e) {
            log.error("获取转铺详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取转铺详情失败");
        }
        return result;
    }
}
