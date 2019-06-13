package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.PropertyType;

public interface SysPropertyTypeService {

    /**
     * 增加
     * @param propertyType
     * @return
     */
    ResponseResult addPropertyType(PropertyType propertyType);

    ResponseResult updatePropertyType(PropertyType propertyType);

    ResponseResult delePropertyType(Long id);

    ResponseResult listPropertyType(SysBaseDTO sysBaseDTO);

}
