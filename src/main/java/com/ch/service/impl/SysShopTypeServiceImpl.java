/**
 * Author: 常富文
 * Date:   2019/6/11 16:59
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.ShopTypeMapper;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.ShopType;
import com.ch.service.SysShopTypeService;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysShopTypeServiceImpl implements SysShopTypeService {
   @Autowired
    ShopTypeMapper shopTypeMapper;
    @Override
    public ResponseResult addShopType(ShopType shopType) {
       ResponseResult result = new ResponseResult();
        shopType.setId(IdUtil.getId());
        shopTypeMapper.insert(shopType);
        return result;
    }

    @Override
    public ResponseResult updateShopType(ShopType shopType) {
        ResponseResult result = new ResponseResult();
        shopTypeMapper.updateByPrimaryKey(shopType);
        return result;
    }

    @Override
    public ResponseResult deleShopType(Long id) {
        ResponseResult result = new ResponseResult();
        shopTypeMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public ResponseResult listShopType(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysBaseDTO.getPageNum(),sysBaseDTO.getPageSize());
        List<ShopType> shopTypes = shopTypeMapper.selectByExample(null);
        PageInfo<ShopType> page = new PageInfo<>(shopTypes);
        result.setData(page);
        return result;
    }
}
