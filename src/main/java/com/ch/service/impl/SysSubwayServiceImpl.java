package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.SubwayLineMapper;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.SubwayLine;
import com.ch.service.SysSubwayService;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysSubwayServiceImpl implements SysSubwayService {

    @Autowired
    SubwayLineMapper subwayLineMapper;

    @Override
    public ResponseResult addSubwayLine(SubwayLine subwayLine) {
        ResponseResult result = new ResponseResult();
        subwayLine.setId(IdUtil.getId());
        subwayLineMapper.insert(subwayLine);
        return result;
    }

    @Override
    public ResponseResult updateSubwayLine(SubwayLine subwayLine) {
        ResponseResult result = new ResponseResult();
        subwayLineMapper.updateByPrimaryKey(subwayLine);
        return result;
    }

    @Override
    public ResponseResult deleSubwayLine(Long id) {
        ResponseResult result = new ResponseResult();
        subwayLineMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public ResponseResult listSubwayLine(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysBaseDTO.getPageNum(),sysBaseDTO.getPageSize());
        List<SubwayLine> subwayLines = new ArrayList<>();
        if (BeanUtils.isNotEmpty(sysBaseDTO.getCityId())){
            subwayLines = subwayLineMapper.findByCityId(sysBaseDTO.getCityId());
        }else {
            subwayLines = subwayLineMapper.selectByExample(null);
        }
        PageInfo<SubwayLine> page = new PageInfo<>(subwayLines);
        result.setData(page);
        return result;
    }
}
