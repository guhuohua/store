package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.model.FastTransferShopParam;
import com.ch.model.ViewLookShopAddParam;
import com.ch.service.ViewLookShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/view/lookshop")
@Slf4j
@Api(value = "选址接口")
public class ViewLookShopController {

    @Autowired
    ViewLookShopService viewLookShopService;

    @PostMapping("/add")
    @ApiOperation("新增选址")
    public ResponseResult addLookShop(@RequestBody ViewLookShopAddParam param) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewLookShopService.addLookShop(param);
        } catch (Exception e) {
            log.error("新增选址失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("新增选址失败");
        }
        return result;
    }

    @GetMapping("/info")
    @ApiOperation("选址详情")
    public ResponseResult lookShopInfo(@RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewLookShopService.lookShopInfo(id);
        } catch (Exception e) {
            log.error("获取选址详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取选址详情失败");
        }
        return result;
    }

    @PostMapping("/fastLookShop")
    @ApiOperation("急速选址")
    public ResponseResult fastLookShop(@RequestBody FastTransferShopParam param) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewLookShopService.fastLookShop(param);
        } catch (Exception e) {
            log.error("急速选址失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("急速选址失败");
        }
        return result;
    }
}
