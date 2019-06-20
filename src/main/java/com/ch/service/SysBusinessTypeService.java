package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.entity.BusinessType;

public interface SysBusinessTypeService {
    /**
     * 增加
     * @param businessType
     * @return
     */
    ResponseResult addBusinessType(BusinessType businessType);

    /**
     * 修改
     * @param businessType
     * @return
     */

    ResponseResult upBusinessType(BusinessType businessType);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleBusinessType(Long id);

    /**
     * 列表展示
     * @param
     * @return
     */
    ResponseResult listBusinessType();
}
