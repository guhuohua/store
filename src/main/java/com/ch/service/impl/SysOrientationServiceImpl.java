/**
 * Author: 常富文
 * Date:   2019/6/11 17:30
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.OrientationMapper;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.Orientation;
import com.ch.service.SysOrientationService;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrientationServiceImpl implements SysOrientationService {
    @Autowired
    OrientationMapper orientationMapper;

    @Override
    public ResponseResult addOrientation(Orientation orientation) {
        ResponseResult result = new ResponseResult();
        orientation.setId(IdUtil.getId());
        orientationMapper.insert(orientation);
        return result;
    }

    @Override
    public ResponseResult updateOrientation(Orientation orientation) {
        ResponseResult result = new ResponseResult();
        orientationMapper.updateByPrimaryKey(orientation);
        return result;
    }

    @Override
    public ResponseResult deleOrientation(Long id) {
        ResponseResult result = new ResponseResult();
        orientationMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public ResponseResult listOrientation(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysBaseDTO.getPageNum(),sysBaseDTO.getPageSize());
        List<Orientation> orientations = orientationMapper.selectByExample(null);
        PageInfo<Orientation> page = new PageInfo<>(orientations);
        result.setData(page);
        return result;
    }
}
