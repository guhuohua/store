/**
 * Author: 常富文
 * Date:   2019/6/10 17:08
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.DecorateTypeMapper;
import com.ch.entity.DecorateType;
import com.ch.service.SysDecorateTypeService;
import com.ch.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysDecorateTypeServiceImpl implements SysDecorateTypeService {
   @Autowired
    DecorateTypeMapper decorateTypeMapper;

    @Override
    public ResponseResult addDecorateType(DecorateType decorateType) {
       ResponseResult result = new ResponseResult();
        decorateType.setId(IdUtil.getId());
        decorateTypeMapper.insert(decorateType);
        return result;
    }

    @Override
    public ResponseResult updateDecorateType(DecorateType decorateType) {
       ResponseResult result = new ResponseResult();
        decorateTypeMapper.updateByPrimaryKey(decorateType);
        return result;
    }

    @Override
    public ResponseResult deleDecorateType(Long id) {
        ResponseResult result = new ResponseResult();
        decorateTypeMapper.deleteByPrimaryKey(id);
        return result;
    }
}
