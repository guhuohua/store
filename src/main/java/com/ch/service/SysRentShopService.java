package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.ShopRentType;

public interface SysRentShopService {
    /**
     * 增加
     * @param shopRentType
     * @return
     */
    ResponseResult addShopRentType(ShopRentType  shopRentType);

    /**
     * 修改
     * @param shopRentType
     * @return
     */
    ResponseResult updateShopRentType(ShopRentType shopRentType);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleShopRentType(Long id);

    /**
     * 列表展示
     * @param sysBaseDTO
     * @return
     */
    ResponseResult listShopRentType(SysBaseDTO sysBaseDTO);

}
