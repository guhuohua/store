package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.model.FastTransferShopParam;
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
    ResponseResult lookShopInfo(Long id);


    /**
     * 我的找铺列表
     * @param id
     * @return
     */
    ResponseResult myLookShopList(Long id);

}
