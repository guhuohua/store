package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.model.FastTransferShopParam;
import com.ch.model.ViewTransferShopListParam;
import com.ch.model.ViewTransferShopParam;

public interface ViewTransferShopService {

    /**
     * 新增转铺
     * @param param
     * @return
     */
    ResponseResult addTransferShop(ViewTransferShopParam param, Long userId);


    /**
     * 转铺列表
     * @param param
     * @return
     */
    ResponseResult transferShopList(ViewTransferShopListParam param);

    /**
     * 转铺详情接口
     * @param storeId
     * @return
     */
    ResponseResult transferShopInfo(Long userId, Long storeId);


    /**
     * 急速转铺
     * @param param
     * @return
     */
    ResponseResult fastTransferShop(FastTransferShopParam param);


    /**
     * 我的转铺列表
     * @param id
     * @return
     */
    ResponseResult myTransferShopList(Long id);


    /**
     * 我的浏览转铺列表
     * @param id
     * @return
     */
    ResponseResult myBrowseTransferShopList(Long id);

    /**
     * 我的收藏转铺列表
     * @param userId
     * @return
     */
    ResponseResult myHouseCollectTransferShopList(Long userId);


    /**
     * 附近的找铺
     * @param lon
     * @param lat
     * @return
     */
    ResponseResult nearbyShop(String lon, String lat);


    /**
     * 成交案例
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseResult dealTransferShopList(Integer pageNum, Integer pageSize);


    /**
     * 统计今日审核通过的店铺的数量
     * @return
     */
    ResponseResult countTodayShop();


    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    ResponseResult deleteShop(Long id);
}
