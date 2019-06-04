/**
 * Author: 常富文
 * Date:   2019/4/3 11:33
 * Description: 登录控制层
 */


package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.dto.UserDTO;
import com.ch.service.SysUserService;
import com.ch.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "user")
@Api(value = "登录接口")
public class SysLoginController {
   @Autowired
   SysUserService sysUserService;
    private static final Logger LOGGER = LogManager.getLogger(SysLoginController.class);
   @ApiOperation("登录")
   @PostMapping(value = "login")
    public ResponseResult login(@RequestBody UserDTO dto){
       ResponseResult result = new ResponseResult();
       try {
           result = sysUserService.login(dto);
           if (result.getCode() == 0) {
               UserDTO data = (UserDTO) result.getData();
               String token = TokenUtil.sign(data.getUserId());
               result.setData(token);
           }
       } catch (Exception e) {
           result.setCode(404);
           result.setError(e.getMessage());
           result.setError_description("登录失败，请稍后再试");
       }
       return result;
    }

    @GetMapping(value = "info")
    
    @ApiOperation("获取用户详情")
    public ResponseResult getUserInfo(HttpServletRequest req, HttpServletResponse res) {
        String token = req.getHeader("Authorization");
        Integer userId = TokenUtil.getUserId(token);
        System.out.println("后台token"+token);
        System.out.println("后台userId"+userId);
        ResponseResult result = new ResponseResult();
        try {
            result.setData(sysUserService.findById(userId));
        } catch (Exception e) {
            result.setCode(404);
            result.setError(e.getMessage());
            result.setError_description("获取用户信息失败");
        }
        return result;
    }
}
