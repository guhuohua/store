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
    ResponseResult transferShopInfo(Long storeId);


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

}
