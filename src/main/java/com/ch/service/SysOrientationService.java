package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.entity.Orientation;
import com.ch.entity.ShopType;

public interface SysOrientationService {
    ResponseResult addOrientation(Orientation orientation);
    ResponseResult updateOrientation(Orientation orientation);
    ResponseResult deleOrientation(Long id);
}
