/**
 * Author: 常富文
 * Date:   2019/6/11 17:38
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.LoopLineMapper;
import com.ch.dto.SysBaseDTO;
import com.ch.dto.SysTransferShopDTO;
import com.ch.entity.LoopLine;
import com.ch.service.SysLoopLineService;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysLoopLineServiceImpl implements SysLoopLineService {

    @Autowired
    LoopLineMapper loopLineMapper;
    @Override
    public ResponseResult addLoopLine(LoopLine loopLine) {
        ResponseResult result = new ResponseResult();
        loopLine.setId(IdUtil.getId());
        return result;
    }

    @Override
    public ResponseResult updateLoopLine(LoopLine loopLine) {
        ResponseResult result = new ResponseResult();
        loopLineMapper.updateByPrimaryKey(loopLine);
        return result;
    }

    @Override
    public ResponseResult deleShopType(Long id) {
        ResponseResult result = new ResponseResult();
        loopLineMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public ResponseResult list(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysBaseDTO.getPageNum(),sysBaseDTO.getPageSize());
        List<LoopLine> loopLines = new ArrayList<>();
        if (BeanUtils.isNotEmpty(sysBaseDTO.getCityId())){
            loopLines = loopLineMapper.findByCityId(sysBaseDTO.getCityId());
        }else {
             loopLines = loopLineMapper.selectByExample(null);
        }
        PageInfo<LoopLine> page = new PageInfo<>(loopLines);
        result.setData(page);
        return result;
    }
}
