package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.ShowShopDto;

public interface SysLookShopService {
    /**
     * 展示找铺铺列表
     *
     */
    ResponseResult showLookShopList(ShowShopDto showShopDto);


    /**
     * 选址详情
     * @param id
     * @return
     */
    ResponseResult lookShopInfo(Long id);
}
