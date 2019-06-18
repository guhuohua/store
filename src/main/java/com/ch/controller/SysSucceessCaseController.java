/**
 * Author: 常富文
 * Date:   2019/6/10 14:43
 * Description:
 */

package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.model.SysSuccessCaseParm;
import com.ch.service.SysShopSuccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/sys/success")
@Slf4j
@Api(value = "成交案例")
@RestController
public class SysSucceessCaseController {

    @Autowired
    SysShopSuccessService sysShopSuccessService;



    @GetMapping("updateLookShopStatus")
    @ApiOperation("找铺设置为已成交状态")
    public ResponseResult updateLookShopStatus(@RequestParam Long storeId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysShopSuccessService.updateLookShopStatus(storeId);
        } catch (Exception e) {
            log.error("找铺设置为已成交状态失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("找铺设置为已成交状态失败");
        }
        return result;
    }


    @GetMapping("updateTransferShopStatus")
    @ApiOperation("转铺铺设置为已成交状态")
    public ResponseResult updateTransferShopStatus(@RequestParam Long storeId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysShopSuccessService.updateTransferShopStatus(storeId);
        } catch (Exception e) {
            log.error("转铺铺设置为已成交状态失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("转铺铺设置为已成交状态失败");
        }
        return result;
    }


    @PostMapping("showSuccessCaseList")
    @ApiOperation("成功案例列表")
    public ResponseResult showSuccessCaseList(@RequestBody SysSuccessCaseParm sysSuccessCaseParm) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysShopSuccessService.showSuccessCaseList(sysSuccessCaseParm);
        } catch (Exception e) {
            log.error("成功案例列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("成功案例列表失败");
        }
        return result;
    }


    @GetMapping("addSuccessCase")
    @ApiOperation("添加成功案例")
    public ResponseResult addSuccessCase(@RequestParam Long storeId,@RequestParam String shopSn ) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysShopSuccessService.addSuccessCase(storeId,shopSn);
        } catch (Exception e) {
            log.error("添加成功案例失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("添加成功案例失败");
        }
        return result;
    }

}
