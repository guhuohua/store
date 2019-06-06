/**
 * Author: 常富文
 * Date:   2019/6/5 14:30
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.LookShopMapper;
import com.ch.dto.ShowShopDto;
import com.ch.dto.ViewLookShopInfoDTO;
import com.ch.dto.ViewTransferShopDTO;
import com.ch.entity.LookShop;
import com.ch.entity.TransferShop;
import com.ch.service.SysLookShopService;
import com.ch.service.ViewLookShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysLookShopServiceImpl implements SysLookShopService {

    @Autowired
    LookShopMapper lookShopMapper;

    @Autowired
    ViewLookShopService viewLookShopService;


    @Override
    public ResponseResult showLookShopList(ShowShopDto showShopDto) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(showShopDto.getPageNum(), showShopDto.getPageSize());
        List<LookShop> LookShops = lookShopMapper.selectByExample(null);
        List<ViewLookShopInfoDTO> viewLookShopInfoDTOs = new ArrayList<>();
        for (LookShop lookShop : LookShops) {
            ResponseResult result1 = viewLookShopService.lookShopInfo(lookShop.getId());
            ViewLookShopInfoDTO data =(ViewLookShopInfoDTO) result1.getData();
            viewLookShopInfoDTOs.add(data);
        }
        PageInfo<ViewLookShopInfoDTO> page = new PageInfo<>(viewLookShopInfoDTOs);
        result.setData(page);
        return result;
    }
}
