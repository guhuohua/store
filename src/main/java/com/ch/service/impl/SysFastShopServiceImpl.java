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
        FastTransferShopExample example = new FastTransferShopExample();
        FastTransferShopExample.Criteria criteria = example.createCriteria();
        List<FastTransferShop> fastTransferShops = null;
        if (BeanUtils.isNotEmpty(sysFastShopDTO)){
            if (BeanUtils.isNotEmpty(sysFastShopDTO.getType())){
                criteria.andTypeEqualTo(sysFastShopDTO.getType());
            }
            if (BeanUtils.isNotEmpty(sysFastShopDTO.getTel())){
                criteria.andTelEqualTo(sysFastShopDTO.getTel());
            }
            if (BeanUtils.isNotEmpty(sysFastShopDTO.getType() ) & BeanUtils.isNotEmpty(sysFastShopDTO.getTel())){
                example = null;
            }

            fastTransferShops = fastTransferShopMapper.selectByExample(example);
        }

        PageInfo<FastTransferShop> page = new PageInfo<>(fastTransferShops);
        result.setData(page);
        return result;
    }


}
