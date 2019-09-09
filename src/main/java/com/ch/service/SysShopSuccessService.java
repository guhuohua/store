package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.model.SysSuccessCaseParm;

public interface SysShopSuccessService {
    /**
     * 更改找铺表的状态
     * @param storeId
     * @return
     */
    ResponseResult updateLookShopStatus(Long storeId);

    /**
     * 更改转铺表的状态
     * @param storeId
     * @return
     */
    ResponseResult updateTransferShopStatus(Long storeId);

    /**
     * 添加成功案列
     * @param storeId
     * @return
     */
    ResponseResult addSuccessCase(Long storeId,String shopSn);


    /**
     * 展示成功案列列表
     *
     * @return
     */
    ResponseResult showSuccessCaseList(SysSuccessCaseParm sysSuccessCaseParm);

}
