package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.model.ViewTransferShopListParam;
import com.ch.model.ViewTransferShopParam;

public interface ViewTransferShopService {

    /**
     * 新增转铺
     * @param param
     * @return
     */
    ResponseResult addTransferShop(ViewTransferShopParam param);


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




}
