/**
 * Author: 常富文
 * Date:   2019/6/5 16:09
 * Description:
 */

package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.dto.SysFastShopDTO;
import com.ch.service.SysFastShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "shop")
@Api(value = "申请列表")
public class SysFastShopServiceController {

    @Autowired
    SysFastShopService sysFastShopService;

    @PostMapping ("applyList")
    @ApiOperation("申请列表")
    public ResponseResult showFastFastTransferShop(@RequestBody SysFastShopDTO sysFastShopDTO) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysFastShopService.showFastTransferShop(sysFastShopDTO);
        } catch (Exception e) {
            log.error("展示后台极速转铺失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("展示后台极速转铺失败");
        }
        return result;
    }



}
