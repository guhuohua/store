package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.DecorateType;

public interface SysDecorateTypeService {
    /**
     * 增加
     * @param decorateType
     * @return
     */
    ResponseResult addDecorateType(DecorateType decorateType);

    /**
     * 修改
     * @param decorateType
     * @return
     */

    ResponseResult updateDecorateType(DecorateType decorateType);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleDecorateType(Long id);

    /**
     * 列表展示
     * @param sysBaseDTO
     * @return
     */
    ResponseResult listDecorateType(SysBaseDTO sysBaseDTO);
}
