package com.ch.service;

import com.ch.base.ResponseResult;
import io.swagger.models.auth.In;

public interface SysMenuTreeService {
    ResponseResult findSysMenuTree(Long userId);
}
