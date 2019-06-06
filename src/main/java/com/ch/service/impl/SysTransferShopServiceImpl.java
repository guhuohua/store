/**
 * Author: 常富文
 * Date:   2019/6/5 10:25
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.TransferShopMapper;
import com.ch.dto.ShowShopDto;
import com.ch.dto.UpdateStatusDTO;
import com.ch.dto.ViewTransferShopDTO;
import com.ch.entity.SysUser;
import com.ch.entity.TransferShop;
import com.ch.service.SysTransferShopService;
import com.ch.service.ViewTransferShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SysTransferShopServiceImpl implements SysTransferShopService {

   @Autowired
    TransferShopMapper transferShopMapper;
   @Autowired
    ViewTransferShopService viewTransferShopService;


    @Override
    public ResponseResult showTransferShopList(ShowShopDto showShopDto) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(showShopDto.getPageNum(), showShopDto.getPageSize());
        List<TransferShop> transferShops = transferShopMapper.selectByExample(null);
        List<ViewTransferShopDTO> viewTransferShopDTOS = new ArrayList<>();
        for (TransferShop transferShop : transferShops) {
            ResponseResult result1 = viewTransferShopService.transferShopInfo(transferShop.getId());
            ViewTransferShopDTO data =(ViewTransferShopDTO) result1.getData();
            viewTransferShopDTOS.add(data);

        }

        PageInfo<ViewTransferShopDTO> page = new PageInfo<>(viewTransferShopDTOS);
        result.setData(page);
        return result;
    }

    @Override
    public ResponseResult updateStatus(UpdateStatusDTO updateStatusDTO){
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(updateStatusDTO.getStoreId());
        if (updateStatusDTO.getStatus() == 1){
            transferShop.setCheckTime(new Date());
        }
        if (updateStatusDTO.getStatus() == 0){
            transferShop.setCheckTime(null);
            transferShop.setReasons(updateStatusDTO.getReasons());
        }
        transferShop.setCheckStatus(updateStatusDTO.getStatus());
        transferShopMapper.updateByPrimaryKey(transferShop);
        return result;
    }

    @Override
    public ResponseResult updateCategory(UpdateStatusDTO updateStatusDTO) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(updateStatusDTO.getStoreId());
        transferShop.setRecommendType(updateStatusDTO.getStatus());
        return result;
    }
}
