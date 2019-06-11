/**
 * Author: 常富文
 * Date:   2019/6/11 16:33
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.PropertyTypeMapper;
import com.ch.entity.PropertyType;
import com.ch.service.SysPropertyTypeService;
import com.ch.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPropertyTypeServiceImpl implements SysPropertyTypeService {
   @Autowired
   PropertyTypeMapper propertyTypeMapper;
    @Override
    public ResponseResult addPropertyType(PropertyType propertyType) {
       ResponseResult result = new ResponseResult();
        propertyType.setId(IdUtil.getId());
        propertyTypeMapper.insert(propertyType);
        return result;
    }

    @Override
    public ResponseResult updatePropertyType(PropertyType propertyType) {
        ResponseResult result = new ResponseResult();
        propertyTypeMapper.updateByPrimaryKey(propertyType);
        return result;
    }

    @Override
    public ResponseResult delePropertyType(Long id) {
        ResponseResult result = new ResponseResult();
        propertyTypeMapper.deleteByPrimaryKey(id);
        return result;
    }
}
