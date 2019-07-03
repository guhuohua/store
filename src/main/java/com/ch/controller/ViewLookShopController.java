package com.ch.controller;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
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

    @PostMapping("/updateShop")
    @ApiOperation("修改选址")
    public ResponseResult updateShop(HttpServletRequest req, @RequestBody ViewLookShopAddParam param) {
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
            result = viewLookShopService.updateShop(param, userId);
        } catch (Exception e) {
            log.error("修改选址失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("修改选址失败");
        }
        return result;
    }

    @GetMapping("/info")
    @ApiOperation("选址详情")
    public ResponseResult lookShopInfo(HttpServletRequest req, @RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        try {
            String token = req.getHeader("Authorization");
            Long userId = null;
            if (BeanUtils.isNotEmpty(token)) {
                userId = TokenUtil.getUserId(token);
            }
            result = viewLookShopService.lookShopInfo(userId, id);
        } catch (Exception e) {
            log.error("获取选址详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取选址详情失败");
        }
        return result;
    }

    @GetMapping("/myBrowesLookShopList")
    @ApiOperation("我的浏览找铺列表")
    public ResponseResult myBrowesLookShopList(HttpServletRequest req) {
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
            result = viewLookShopService.myBrowesLookShopList(userId);
        } catch (Exception e) {
            log.error("获取我的浏览找铺列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取我的浏览找铺列表失败");
        }
        return result;
    }

    @GetMapping("/myHouseLookShopList")
    @ApiOperation("我的收藏找铺列表")
    public ResponseResult myHouseLookShopList(HttpServletRequest req) {
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
            result = viewLookShopService.myHouseLookShopList(userId);
        } catch (Exception e) {
            log.error("获取我的收藏找铺列表" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取我的收藏找铺列表");
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

    @GetMapping("/deleteShop")
    @ApiOperation("删除我的找铺")
    public ResponseResult myLookShopList(HttpServletRequest req, @RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewLookShopService.deleteShop(id);
        } catch (Exception e) {
            log.error ("删除我的找铺失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除我的找铺失败");
        }
        return result;
    }
}
