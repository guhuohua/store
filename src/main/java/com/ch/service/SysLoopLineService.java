package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.LoopLine;

public interface SysLoopLineService {
    /**
     * 增加
     * @param loopLine
     * @return
     */
    ResponseResult addLoopLine(LoopLine loopLine);

    /**
     * 修改
     * @param loopLine
     * @return
     */
    ResponseResult updateLoopLine(LoopLine loopLine);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleShopType(Long id);

    /**
     * 列表展示
     * @param sysBaseDTO
     * @return
     */
    ResponseResult list(SysBaseDTO sysBaseDTO);
}
