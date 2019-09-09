package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.ShopType;

public interface SysShopTypeService {
    /**
     * 增加
     * @param ShopType
     * @return
     */
    ResponseResult addShopType(ShopType ShopType);

    /**
     * 修改
     * @param ShopType
     * @return
     */
    ResponseResult updateShopType(ShopType ShopType);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleShopType(Long id);

    /**
     * 列表展示
     * @param sysBaseDTO
     * @return
     */
    ResponseResult listShopType(SysBaseDTO sysBaseDTO);
}
