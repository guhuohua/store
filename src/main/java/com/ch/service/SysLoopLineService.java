package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.LoopLine;
import com.ch.entity.ShopType;

public interface SysLoopLineService {
    ResponseResult addLoopLine(LoopLine loopLine);
    ResponseResult updateLoopLine(LoopLine loopLine);
    ResponseResult deleShopType(Long id);
    ResponseResult list(SysBaseDTO sysBaseDTO);
}
