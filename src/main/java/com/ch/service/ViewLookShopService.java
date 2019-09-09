package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.model.ViewLookShopAddParam;

public interface ViewLookShopService {

    /**
     * 新增选址
     * @param param
     * @return
     */
    ResponseResult addLookShop(ViewLookShopAddParam param, Long userId);


    /**
     * 选址详情
     * @param id
     * @return
     */
    ResponseResult lookShopInfo(Long userId, Long id);


    /**
     * 我的找铺列表
     * @param id
     * @return
     */
    ResponseResult myLookShopList(Long id);


    /**
     * 我的浏览找铺列表
     * @param id
     * @return
     */
    ResponseResult myBrowesLookShopList(Long id);


    /**
     * 我的收藏找铺列表
     * @param userId
     * @return
     */
    ResponseResult myHouseLookShopList(Long userId);

    /**
     * 删除我的找铺
     * @param id
     * @return
     */
    ResponseResult deleteShop(Long id);

    /**
     * 修改店铺
     * @param param
     * @param userId
     * @return
     */
    ResponseResult updateShop(ViewLookShopAddParam param, Long userId);
}
