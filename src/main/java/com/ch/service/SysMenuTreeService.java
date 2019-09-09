package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.entity.SysMenu;

public interface SysMenuTreeService {
    /**
     * 展示权限菜单
     * @param userId
     * @return
     */
    ResponseResult findSysMenuTree(Long userId);

    /**
     * 展示权限菜单
     * @param
     * @return
     */
    ResponseResult findALLTree();


    /**
     * 删除菜单
     * @param
     * @return
     */
    ResponseResult dele(Integer id);


    /**
     * 新增菜单
     * @param
     * @return
     */
    ResponseResult add(SysMenu sysMenu);


    /**
     * 修改菜单
     * @param
     * @return
     */
    ResponseResult update(SysMenu sysMenu);

}
