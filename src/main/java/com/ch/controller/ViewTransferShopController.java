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

    @PostMapping("/update")
    @ApiOperation("修改转铺")
    public ResponseResult updateShop(HttpServletRequest req, @RequestBody ViewTransferShopParam param) {
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
            result = viewTransferShopService.updateShop(param, userId);
        } catch (Exception e) {
            log.error("修改转铺失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("修改转铺失败");
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
    public ResponseResult transferShopInfo(HttpServletRequest req, @RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        String token = req.getHeader("Authorization");
        Long userId = null;
        if (BeanUtils.isNotEmpty(token)) {
            userId = TokenUtil.getUserId(token);
        }
         try {
            result = viewTransferShopService.transferShopInfo(userId, id);
        } catch (Exception e) {
            log.error("获取转铺详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取转铺详情失败");
        }
        return result;
    }

    @GetMapping("/updateShopInfo")
    @ApiOperation("修改转铺详情")
    public ResponseResult updateShopInfo(HttpServletRequest req, @RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        String token = req.getHeader("Authorization");
        Long userId = null;
        if (BeanUtils.isNotEmpty(token)) {
            userId = TokenUtil.getUserId(token);
        }
        try {
            result = viewTransferShopService.updateShopInfo(userId, id);
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

    @GetMapping("/nearbyShop")
    @ApiOperation("附近的转铺")
    public ResponseResult nearbyShop(@RequestParam String lon, @RequestParam String lat, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.nearbyShop(lon, lat, pageNum, pageSize);
        } catch (Exception e) {
            log.error("获取附近的店铺失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取附近的店铺失败");
        }
        return result;
    }

    @GetMapping("/dealTransferShopList")
    @ApiOperation("成交案例")
    public ResponseResult nearbyShop(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.dealTransferShopList(pageNum, pageSize);
        } catch (Exception e) {
            log.error("获取成交案例失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取成交案例失败");
        }
        return result;
    }

    @GetMapping("/intermediaryList")
    @ApiOperation("中介成交案例")
    public ResponseResult nearbyShop(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.intermediaryList(id, pageNum, pageSize);
        } catch (Exception e) {
            log.error("获取中介成交案例列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取中介成交案例列表失败");
        }
        return result;
    }

    @GetMapping("/myBrowseTransferShopList")
    @ApiOperation("我的浏览转铺记录")
    public ResponseResult myBrowseTransferShopList(HttpServletRequest req) {
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
            result = viewTransferShopService.myBrowseTransferShopList(userId);
        } catch (Exception e) {
            log.error("获取我的浏览转铺记录失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取我的浏览转铺记录失败");
        }
        return result;
    }

    @GetMapping("/myHouseCollectTransferShopList")
    @ApiOperation("我的收藏转铺记录")
    public ResponseResult myHouseCollectTransferShopList(HttpServletRequest req) {
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
            result = viewTransferShopService.myHouseCollectTransferShopList(userId);
        } catch (Exception e) {
            log.error("获取我的收藏转铺记录" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取我的收藏转铺记录");
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

    @GetMapping("/countTodayShop")
    @ApiOperation("今日新增")
    public ResponseResult countTodayShop() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.countTodayShop();
        } catch (Exception e) {
            log.error("获取今日新增失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取今日新增失败");
        }
        return result;
    }

    @GetMapping("/deleteShop")
    @ApiOperation("删除我的转铺")
    public ResponseResult deleteShop(@RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewTransferShopService.deleteShop(id);
        } catch (Exception e) {
            log.error("删除我的转铺失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除我的转铺失败");
        }
        return result;
    }
}
