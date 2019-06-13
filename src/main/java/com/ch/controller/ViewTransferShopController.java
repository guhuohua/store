package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.model.FastTransferShopParam;
import com.ch.model.ViewTransferShopListParam;
import com.ch.model.ViewTransferShopParam;
import com.ch.service.ViewTransferShopService;
import com.ch.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/view/transferShop")
@Slf4j
@Api(value = "转铺接口")
public class ViewTransferShopController {

    @Autowired
    ViewTransferShopService viewTransferShopService;

    @PostMapping("/add")
    @ApiOperation("新增转铺")
    public ResponseResult addTransferShop(HttpServletRequest req, @RequestBody ViewTransferShopParam param) {
        ResponseResult result = new ResponseResult();
        String token = req.getHeader("Authorization");
        if (BeanUtils.isEmpty(token)) {
            result.setCode(999);
            result.setError("token失效请重新登录");
            result.setError_description("token失效请重新登录");
            return result;
        }
        Long userId = TokenUtil.getUserId(token);
        if (BeanUtils.isEmpty(userId)) {
            result.setCode(999);
            result.setError("token失效请重新登录");
            result.setError_description("token失效请重新登录");
            return result;
        }
        try {
            result = viewTransferShopService.addTransferShop(param, userId);
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
    public ResponseResult transferShopList(ViewTransferShopListParam param) {
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

    @PostMapping("/fastTransferShop")
    @ApiOperation("急速转铺")
    public ResponseResult fastTransferShop(@RequestBody FastTransferShopParam param) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.fastTransferShop(param);
        } catch (Exception e) {
            log.error("急速转铺失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("急速转铺失败");
        }
        return result;
    }

    @GetMapping("/myTransferShopList")
    @ApiOperation("我的转铺列表")
    public ResponseResult fastTransferShop(HttpServletRequest req) {
        ResponseResult result = new ResponseResult();
        String token = req.getHeader("Authorization");
        if (BeanUtils.isEmpty(token)) {
            result.setCode(999);
            result.setError("token失效请重新登录");
            result.setError_description("token失效请重新登录");
            return result;
        }
        Long userId = TokenUtil.getUserId(token);
        if (BeanUtils.isEmpty(userId)) {
            result.setCode(999);
            result.setError("token失效请重新登录");
            result.setError_description("token失效请重新登录");
            return result;
        }
        try {
            result = viewTransferShopService.myTransferShopList(userId);
        } catch (Exception e) {
            log.error("获取我的转铺列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取我的转铺列表失败");
        }
        return result;
    }
}
