package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.entity.DecorateType;
import com.ch.entity.PropertyType;

public interface SysPropertyTypeService {

    ResponseResult addPropertyType(PropertyType propertyType);
    ResponseResult updatePropertyType(PropertyType propertyType);
    ResponseResult delePropertyType(Long id);

}
