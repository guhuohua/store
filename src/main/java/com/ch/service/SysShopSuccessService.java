package com.ch.service;

import com.ch.base.ResponseResult;

public interface SysShopSuccessService {
    ResponseResult updateLookShopStatus(Long storeId);

    ResponseResult updateTransferShopStatus(Long storeId);

    ResponseResult addSuccessCase(Long storeId,String shopSn);



}
