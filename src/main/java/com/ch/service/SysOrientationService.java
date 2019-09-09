package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.Orientation;

public interface SysOrientationService {
    /**
     * 添加
     * @param orientation
     * @return
     */
    ResponseResult addOrientation(Orientation orientation);

    /**
     * 修改
     * @param orientation
     * @return
     */
    ResponseResult updateOrientation(Orientation orientation);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleOrientation(Long id);

    /**
     * 列表展示
     * @param sysBaseDTO
     * @return
     */

    ResponseResult listOrientation(SysBaseDTO sysBaseDTO);
}
