/**
 * Author: 常富文
 * Date:   2019/6/5 10:25
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.TransferShopMapper;
import com.ch.dto.ViewTransferShopDTO;
import com.ch.entity.TransferShop;
import com.ch.service.SysTransferShopService;
import com.ch.service.ViewTransferShopService;
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
    public ResponseResult showTransferShopList() {
        ResponseResult result = new ResponseResult();
        List<TransferShop> transferShops = transferShopMapper.selectByExample(null);
        List<ViewTransferShopDTO> viewTransferShopDTOS = new ArrayList<>();
        for (TransferShop transferShop : transferShops) {
            ResponseResult result1 = viewTransferShopService.transferShopInfo(transferShop.getId());
            ViewTransferShopDTO data =(ViewTransferShopDTO) result1.getData();
            viewTransferShopDTOS.add(data);
            result.setData(viewTransferShopDTOS);
        }
        return result;
    }

    @Override
    public ResponseResult updateStatus(Long storeId) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(storeId);
        if (transferShop.getCheckStatus()==0){
            transferShop.setCheckStatus(1);
            transferShop.setCheckTime(new Date());
        }else {
            transferShop.setCheckStatus(0);
            transferShop.setCheckTime(null);
        }
        transferShopMapper.updateByPrimaryKey(transferShop);
        return result;
    }
}
