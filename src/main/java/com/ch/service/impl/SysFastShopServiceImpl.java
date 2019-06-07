/**
 * Author: 常富文
 * Date:   2019/6/5 15:57
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.FastLookShopMapper;
import com.ch.dao.FastTransferShopMapper;
import com.ch.dto.SysFastShopDTO;
import com.ch.dto.ViewLookShopInfoDTO;
import com.ch.entity.FastLookShop;
import com.ch.entity.FastLookShopExample;
import com.ch.entity.FastTransferShop;
import com.ch.entity.FastTransferShopExample;
import com.ch.service.SysFastShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysFastShopServiceImpl implements SysFastShopService {
    @Autowired
    FastTransferShopMapper fastTransferShopMapper;

   @Autowired
   FastLookShopMapper fastLookShopMapper;

    @Override
    public ResponseResult showFastTransferShop(SysFastShopDTO sysFastShopDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysFastShopDTO.getPageNum(), sysFastShopDTO.getPageSize());
        List<FastTransferShop> fastTransferShops = new ArrayList<>();
        FastTransferShopExample example = new FastTransferShopExample();
        FastTransferShopExample.Criteria criteria = example.createCriteria();
        if (BeanUtils.isNotEmpty(sysFastShopDTO.getContacts())){
           criteria.andContactsLike(sysFastShopDTO.getContacts());
             fastTransferShops = fastTransferShopMapper.selectByExample(example);
       }
        if (BeanUtils.isNotEmpty(sysFastShopDTO.getTel())){
            criteria.andTelEqualTo(sysFastShopDTO.getTel());
             fastTransferShops = fastTransferShopMapper.selectByExample(example);
        }else {
            fastTransferShops = fastTransferShopMapper.selectByExample(null);
        }

        PageInfo<FastTransferShop> page = new PageInfo<>(fastTransferShops);
        result.setData(page);
        return result;
    }

    @Override
    public ResponseResult showFastLookShop(SysFastShopDTO sysFastShopDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysFastShopDTO.getPageNum(), sysFastShopDTO.getPageSize());
        List<FastLookShop> fastLookShops = new ArrayList<>();
        FastLookShopExample example = new FastLookShopExample();
        FastLookShopExample.Criteria criteria = example.createCriteria();

        if (BeanUtils.isNotEmpty(sysFastShopDTO.getContacts())){
            criteria.andContactsLike(sysFastShopDTO.getContacts());
             fastLookShops = fastLookShopMapper.selectByExample(example);
        }
        if (BeanUtils.isNotEmpty(sysFastShopDTO.getTel())){
            criteria.andTelEqualTo(sysFastShopDTO.getTel());
            fastLookShops = fastLookShopMapper.selectByExample(example);
        }
        else {
            fastLookShops = fastLookShopMapper.selectByExample(null);
        }


        PageInfo<FastLookShop> page = new PageInfo<>(fastLookShops);
        result.setData(page);
        return result;
    }
}
