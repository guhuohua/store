package com.ch.controller;

import com.alibaba.fastjson.JSONObject;
import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.model.ViewBrowseParam;
import com.ch.model.ViewFeedBackParam;
import com.ch.model.ViewWXLoginParam;
import com.ch.service.ViewBaseService;
import com.ch.service.ViewIconService;
import com.ch.util.HttpRequestUtil;
import com.ch.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/view/base")
@Slf4j
@Api(value = "小程序基础接口")
public class ViewBaseController{

    @Autowired
    ViewIconService viewIconService;

    @Autowired
    ViewBaseService viewBaseService;

    @GetMapping("/icon")
    @ApiOperation("首页图标icon")
    public ResponseResult iconList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewIconService.iconList();
        } catch (Exception e) {
            log.error("获取首页图标失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取首页图标失败");
        }
        return result;
    }

    @GetMapping("/province")
    @ApiOperation("获取省级列表")
    public ResponseResult provinceList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.provinceList();
        } catch (Exception e) {
            log.error("获取省级列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取省级列表失败");
        }
        return result;
    }

    @GetMapping("/businessTypeList")
    @ApiOperation("获取经营范围")
    public ResponseResult businessTypeList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.businessTypeList();
        } catch (Exception e) {
            log.error("获取经营范围失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取经营范围失败");
        }
        return result;
    }

    @GetMapping("/city")
    @ApiOperation("获取市级列表")
    public ResponseResult cityList(@RequestParam String code) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.findCityByProvinceCode(code);
        } catch (Exception e) {
            log.error("获取市级列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取市级列表失败");
        }
        return result;
    }

    @GetMapping("/area")
    @ApiOperation("获取区级列表")
    public ResponseResult areaList(@RequestParam String code) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.findAreaByCityCode(code);
        } catch (Exception e) {
            log.error("获取区级列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取区级列表失败");
        }
        return result;
    }


    @GetMapping("/street")
    @ApiOperation("获取街道列表")
    public ResponseResult streetList(@RequestParam String code) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.findStweetByAreaCode(code);
        } catch (Exception e) {
            log.error("获取街道列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取街道列表失败");
        }
        return result;
    }

    @GetMapping("/shopRentTypeList")
    @ApiOperation("获取租铺类型")
    public ResponseResult shopRentTypeList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.shopRentTypeList();
        } catch (Exception e) {
            log.error("获取租铺类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取租铺类型失败");
        }
        return result;
    }

    @GetMapping("/shopTypeList")
    @ApiOperation("获取店铺类型")
    public ResponseResult shopTypeList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.shopTypeList();
        } catch (Exception e) {
            log.error("获取店铺类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取店铺类型失败");
        }
        return result;
    }

    @GetMapping("/propertyTypeList")
    @ApiOperation("获取物业类型")
    public ResponseResult propertyTypeList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.propertyTypeList();
        } catch (Exception e) {
            log.error("获取物业类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取物业类型失败");
        }
        return result;
    }

    @PostMapping("/saveCollection")
    @ApiOperation("保存我的收藏")
    public ResponseResult saveCollection(HttpServletRequest req, @RequestBody ViewBrowseParam param) {
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
            result = viewBaseService.saveCollection(userId, param);
        } catch (Exception e) {
            log.error("收藏失败，请稍后重试" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("收藏失败，请稍后重试");
        }
        return result;
    }

    @PostMapping("/deleteCollection")
    @ApiOperation("取消我的收藏")
    public ResponseResult deleteCollection(HttpServletRequest req, @RequestBody ViewBrowseParam param) {
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
            result = viewBaseService.deleteCollection(userId, param);
        } catch (Exception e) {
            log.error("取消我的收藏失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("取消我的收藏失败，请稍后重试");
        }
        return result;
    }

    @PostMapping("/saveBrowse")
    @ApiOperation("保存用户浏览记录")
    public void saveBrowse(HttpServletRequest req, @RequestBody ViewBrowseParam param) {
        String token = req.getHeader("Authorization");
        if (BeanUtils.isNotEmpty(token)) {
            Long userId = TokenUtil.getUserId(token);
            viewBaseService.saveBrowse(userId, param);
        }
    }

    @PostMapping("/deleteBrowse")
    @ApiOperation("删除用户浏览记录")
    public void deleteBrowse(HttpServletRequest req, @RequestBody ViewBrowseParam param) {
        String token = req.getHeader("Authorization");
        if (BeanUtils.isNotEmpty(token)) {
            Long userId = TokenUtil.getUserId(token);
            viewBaseService.deleteBrowse(userId, param);
        }
    }



    @GetMapping("/orientation")
    @ApiOperation("获取朝向")
    public ResponseResult orientation() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.orientation();
        } catch (Exception e) {
            log.error("获取朝向失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取朝向失败");
        }
        return result;
    }

    @GetMapping("/loopLineList")
    @ApiOperation("获取环线")
    public ResponseResult lookLineList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.lookLineList();
        } catch (Exception e) {
            log.error("获取环线失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取环线失败");
        }
        return result;
    }

    @GetMapping("/subwayLineList")
    @ApiOperation("获取地铁线路")
    public ResponseResult subwayLineList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.subwayLineList();
        } catch (Exception e) {
            log.error("获取地铁线路失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取地铁线路失败");
        }
        return result;
    }

    @GetMapping("/decorateTypeList")
    @ApiOperation("获取装修类型")
    public ResponseResult decorateTypeList() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.decorateType();
        } catch (Exception e) {
            log.error("获取装修类型失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取装修类型失败");
        }
        return result;
    }

    @GetMapping("/advert")
    @ApiOperation("获取轮播图")
    public ResponseResult advert() {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.advert();
        } catch (Exception e) {
            log.error("获取轮播图失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取轮播图失败");
        }
        return result;
    }

    @PostMapping("/wxLogin")
    @ApiOperation("微信授权登录")
    public ResponseResult wxLogin(@RequestBody ViewWXLoginParam param) {
        ResponseResult result = new ResponseResult();
        try {
            result = viewBaseService.wxLogin(param);
        } catch (Exception e) {
            log.error("微信授权登录失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("微信授权登录失败");
        }
        return result;
    }

    @PostMapping("/feedBack")
    @ApiOperation("意见反馈")
    public ResponseResult myBrowseTransferShopList(HttpServletRequest req, @RequestBody ViewFeedBackParam param) {
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
            result = viewBaseService.feedBack(userId, param);
        } catch (Exception e) {
            log.error("提交意见反馈失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("提交意见反馈失败");
        }
        return result;
    }


    @GetMapping("getOpenId")
    @ApiOperation("获取OpenId")
    public ResponseResult getOpenId(String code, String appId) {
        // 配置请求参数
        Map<String, String> param = new HashMap<>();
        param.put("appid", appId);
        param.put("secret", "e89e8ccebb5aec7096b629ebcd40dda2");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        // 发送请求
        String wxResult = HttpRequestUtil.doGet("https://api.weixin.qq.com/sns/jscode2session", param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        //System.out.println(jsonObject);
        String session_key = null;
        String open_id = null;
        if (jsonObject != null) {
            // 获取参数返回的
            session_key = jsonObject.get("session_key").toString();
            // System.out.println(session_key);

            open_id = jsonObject.get("openid").toString();
            // System.out.println(open_id);
           /* UserInfo userInfo = new UserInfo();
           userInfo.setOpenId(open_id);
           userInfo.setCreateTime(new Date());
           userInfoMapper.insert(userInfo);*/
        }
        // 封装返回小程序
        Map<String, String> result = new HashMap<>();
        result.put("session_key", session_key);
        result.put("open_id", open_id);
        ResponseResult result1 = new ResponseResult();
        result1.setData(result);
        return result1;

    }
}
