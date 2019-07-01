/**
 * Author: 常富文
 * Date:   2019/6/6 10:13
 * Description:
 */

package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.entity.SysMenu;
import com.ch.service.SysMenuTreeService;
import com.ch.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "sysMenu")
@Api(value = "后台菜单")
public class SysMenuTreeController {
    @Autowired
    SysMenuTreeService sysMenuTreeService;

    private static final Logger LOGGER = LogManager.getLogger(SysMenuTreeController.class);

    @ApiOperation("后台菜单")
    @GetMapping (value = "free")
    public ResponseResult findSysMenuTree(HttpServletRequest request){
        ResponseResult result = new ResponseResult();
        try {
            String token = request.getHeader("Authorization");
            Long userId = TokenUtil.getUserId(token);

            result = sysMenuTreeService.findSysMenuTree(userId);
        } catch (Exception e) {
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("后台菜单失败，请稍后再试");
        }
        return result;
    }

   @ApiOperation("编辑菜单")
    @PostMapping(value = "edit")
    public ResponseResult editSysMenuTree(@RequestBody SysMenu sysMenu){
        ResponseResult result = new ResponseResult();
        try {
            if (null != sysMenu.getId()){
                sysMenuTreeService.update(sysMenu);
            }else{
                sysMenuTreeService.add(sysMenu);
            }
        } catch (Exception e) {
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("编辑菜单失败，请稍后再试");
        }
        return result;
    }


    @ApiOperation("删除菜单")
    @GetMapping(value = "dele")
    public ResponseResult deleSysMenuTree(@RequestParam Integer id){
        ResponseResult result = new ResponseResult();
        try {
            sysMenuTreeService.dele(id);
        } catch (Exception e) {
            result.setCode(600);
            result.setError(e.getMessage());
            result.setError_description("删除菜单失败，请稍后再试");
        }
        return result;
    }
}
