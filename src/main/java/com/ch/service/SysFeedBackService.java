package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.dto.SysBaseDTO;

public interface SysFeedBackService {
    /**
     * 意见反馈列表
     * @param sysBaseDTO
     * @return
     */
    ResponseResult list(SysBaseDTO sysBaseDTO);


    /**
     * 删除反馈
     * @param id
     * @return
     */
    ResponseResult dele(Long id);

}
