package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.service.ViewBaseService;
import com.ch.service.ViewIconService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/lookLineList")
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
}
