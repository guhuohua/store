/**
 * Author: 常富文
 * Date:   2019/6/10 17:08
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.DecorateTypeMapper;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.DecorateType;
import com.ch.service.SysDecorateTypeService;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ResponseResult listDecorateType(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysBaseDTO.getPageNum(),sysBaseDTO.getPageSize());
        List<DecorateType> decorateTypes = decorateTypeMapper.selectByExample(null);
        PageInfo<DecorateType> page = new PageInfo<>(decorateTypes);
        result.setData(page);
        return result;
    }

}
