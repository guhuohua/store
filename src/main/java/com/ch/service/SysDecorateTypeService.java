package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.entity.DecorateType;

public interface SysDecorateTypeService {
    ResponseResult addDecorateType(DecorateType decorateType);
    ResponseResult updateDecorateType(DecorateType decorateType);
    ResponseResult deleDecorateType(Long id);

}
