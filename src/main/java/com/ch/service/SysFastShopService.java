package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysFastShopDTO;

public interface SysFastShopService {
    ResponseResult showFastLookShop(SysFastShopDTO sysFastShopDTO);
    ResponseResult showFastTransferShop(SysFastShopDTO sysFastShopDTO);
}
