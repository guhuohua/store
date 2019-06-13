package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.SubwayLine;

public interface SysSubwayService {

    /**
     * 增加
     * @param subwayLine
     * @return
     */
    ResponseResult addSubwayLine(SubwayLine subwayLine);

    /**
     * 修改
     * @param subwayLine
     * @return
     */
    ResponseResult updateSubwayLine(SubwayLine subwayLine);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleSubwayLine(Long id);

    /**
     * 列表展示
     * @param sysBaseDTO
     * @return
     */
    ResponseResult listSubwayLine(SysBaseDTO sysBaseDTO);
}
