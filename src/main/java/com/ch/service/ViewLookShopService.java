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
    ResponseResult addLookShop(ViewLookShopAddParam param, Integer userId);


    /**
     * 选址详情
     * @param id
     * @return
     */
    ResponseResult lookShopInfo(Long id);


    /**
     * 急速选址
     * @param param
     * @return
     */
    ResponseResult fastLookShop(FastTransferShopParam param);

}
