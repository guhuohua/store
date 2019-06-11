package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.entity.PropertyType;
import com.ch.entity.ShopRentType;

public interface SysRentShopService {
    ResponseResult addShopRentType(ShopRentType  shopRentType);
    ResponseResult updateShopRentType(ShopRentType shopRentType);
    ResponseResult deleShopRentType(Long id);
}
