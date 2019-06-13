package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.model.FastTransferShopParam;
import com.ch.model.ViewLookShopAddParam;
import com.ch.service.ViewLookShopService;
import com.ch.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/view/lookshop")
@Slf4j
@Api(value = "选址接口")
public class ViewLookShopController {

    @Autowired
    ViewLookShopService viewLookShopService;

    @PostMapping("/add")
    @ApiOperation("新增选址")
    public ResponseResult addLookShop(HttpServletRequest req, @RequestBody ViewLookShopAddParam param) {
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
            result = viewLookShopService.addLookShop(param, userId);
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

    @GetMapping("/myLookShopList")
    @ApiOperation("我的找铺列表")
    public ResponseResult myLookShopList(HttpServletRequest req) {
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
            result = viewLookShopService.myLookShopList(userId);
        } catch (Exception e) {
            log.error("获取我的找铺列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取我的找铺列表失败");
        }
        return result;
    }
}
