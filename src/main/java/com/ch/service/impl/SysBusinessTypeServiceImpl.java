package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.BusinessTypeMapper;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.BusinessType;
import com.ch.service.SysBusinessTypeService;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysBusinessTypeServiceImpl implements SysBusinessTypeService {
   @Autowired
    BusinessTypeMapper businessTypeMapper;

    @Override
    public ResponseResult addBusinessType(BusinessType businessType) {
        ResponseResult result = new ResponseResult();
        businessType.setId(IdUtil.getId());
        businessTypeMapper.insert(businessType);
        return result;

    }

    @Override
    public ResponseResult upBusinessType(BusinessType businessType) {
        ResponseResult result = new ResponseResult();
        businessTypeMapper.updateByPrimaryKey(businessType);
        return result;
    }

    @Override
    public ResponseResult deleBusinessType(Long id) {
        ResponseResult result = new ResponseResult();
        businessTypeMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public ResponseResult listBusinessType(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysBaseDTO.getPageNum(),sysBaseDTO.getPageSize());
        List<BusinessType> list = businessTypeMapper.list(sysBaseDTO.getParentId());
        PageInfo<BusinessType> page = new PageInfo<>(list);
        result.setData(page);
        return result;
    }
}
