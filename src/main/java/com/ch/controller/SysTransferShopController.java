/**
 * Author: 常富文
 * Date:   2019/6/5 10:38
 * Description:
 */

package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.dto.ShowShopDto;
import com.ch.dto.UpdateStatusDTO;
import com.ch.service.SysTransferShopService;
import com.ch.service.ViewTransferShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/sys/transferShop")
@Slf4j
@Api(value = "后台转铺列表")
@RestController

public class SysTransferShopController {

    @Autowired
    SysTransferShopService sysTransferShopService;
    @Autowired
    ViewTransferShopService viewTransferShopService;


    @PostMapping ("showTransferShopList")
    @ApiOperation("展示后台转铺列表")
    public ResponseResult showTransferShopList(@RequestBody ShowShopDto pageInfo) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysTransferShopService.showTransferShopList(pageInfo);
        } catch (Exception e) {
            log.error("获取转铺列表失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取转铺列表失败");
        }
        return result;
    }


    @GetMapping("showTransferShopInfo")
    @ApiOperation("展示后台转铺详情")
    public ResponseResult showTransferShopInfo(@RequestParam Long storeId) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysTransferShopService.transferShopInfo(storeId);
        } catch (Exception e) {
            log.error("获取转铺详情失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("获取转铺详情失败");
        }
        return result;
    }


    @PostMapping ("updateStatus")
    @ApiOperation("审核状态")
    public ResponseResult updateStatus(@RequestBody UpdateStatusDTO updateStatusDTO) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysTransferShopService.updateStatus(updateStatusDTO);
        } catch (Exception e) {
            log.error("审核状态失败" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("审核状态失败");
        }
        return result;
    }


    @PostMapping ("updateCategory")
    @ApiOperation("是否精品")
    public ResponseResult updateCategory(@ RequestBody UpdateStatusDTO updateStatusDTO) {
        ResponseResult result = new ResponseResult();
        try {
            result = sysTransferShopService.updateCategory(updateStatusDTO);
        } catch (Exception e) {
            log.error("是否精品" + e.getMessage(), e);
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("是否精品");
        }
        return result;
    }


}
