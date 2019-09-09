package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.BusinessTypeMapper;
import com.ch.entity.BusinessType;
import com.ch.service.SysBusinessTypeService;
import com.ch.service.ViewBaseService;
import com.ch.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysBusinessTypeServiceImpl implements SysBusinessTypeService {
   @Autowired
    BusinessTypeMapper businessTypeMapper;
   @Autowired
    ViewBaseService viewBaseService;

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
    public ResponseResult listBusinessType() {
        ResponseResult result1 = viewBaseService.businessTypeList();
        return result1;
    }


}
