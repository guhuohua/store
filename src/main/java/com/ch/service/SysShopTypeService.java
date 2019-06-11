package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.entity.ShopRentType;
import com.ch.entity.ShopType;

public interface SysShopTypeService {
    ResponseResult addShopType(ShopType ShopType);
    ResponseResult updateShopType(ShopType ShopType);
    ResponseResult deleShopType(Long id);
}
