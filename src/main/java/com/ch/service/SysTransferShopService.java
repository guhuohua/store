package com.ch.service;

import com.ch.base.ResponseResult;

public interface SysTransferShopService {
    /**
     * 展示转铺列表
     *
     */
    ResponseResult showTransferShopList();

    /**
     * 审核店铺
     */

    ResponseResult updateStatus(Long storeId);
}
