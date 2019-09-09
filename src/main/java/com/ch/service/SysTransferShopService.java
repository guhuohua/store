package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.ShowShopDto;
import com.ch.dto.UpdateStatusDTO;

public interface SysTransferShopService {
    /**
     * 展示转铺列表
     */
    ResponseResult showTransferShopList(ShowShopDto showShopDto);

    /**
     * 审核店铺
     */

    ResponseResult updateStatus(UpdateStatusDTO updateStatusDTO);

    /**
     * 是否为精品
     */
    ResponseResult updateCategory(UpdateStatusDTO updateStatusDTO);

    /**
     * 转铺详情
     * @param storeId
     * @return
     */
    ResponseResult  transferShopInfo(Long storeId);


    ResponseResult findAgent();

}
