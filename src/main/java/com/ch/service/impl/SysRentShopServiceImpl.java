/**
 * Author: 常富文
 * Date:   2019/6/11 16:54
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.ShopRentTypeMapper;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.ShopRentType;
import com.ch.service.SysRentShopService;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRentShopServiceImpl implements SysRentShopService {

    @Autowired
    ShopRentTypeMapper shopRentTypeMapper;

    @Override
    public ResponseResult addShopRentType(ShopRentType shopRentType) {
        ResponseResult result = new ResponseResult();
        shopRentType.setId(IdUtil.getId());
        shopRentTypeMapper.insert(shopRentType);
        return result;
    }

    @Override
    public ResponseResult updateShopRentType(ShopRentType shopRentType) {
        ResponseResult result = new ResponseResult();
        shopRentTypeMapper.updateByPrimaryKey(shopRentType);
        return result;
    }

    @Override
    public ResponseResult deleShopRentType(Long id) {
        ResponseResult result = new ResponseResult();
        shopRentTypeMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public ResponseResult listShopRentType(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysBaseDTO.getPageNum(),sysBaseDTO.getPageSize());
        List<ShopRentType> shopRentTypes = shopRentTypeMapper.selectByExample(null);
        PageInfo<ShopRentType> page = new PageInfo<>(shopRentTypes);
        result.setData(page);
        return result;
    }
}
