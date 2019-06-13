/**
 * Author: 常富文
 * Date:   2019/6/10 14:24
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.LookShopMapper;
import com.ch.dao.SuccessCaseMapper;
import com.ch.dao.TransferShopMapper;
import com.ch.entity.LookShop;
import com.ch.entity.SuccessCase;
import com.ch.entity.TransferShop;
import com.ch.entity.TransferShopExample;
import com.ch.service.SysShopSuccessService;
import com.ch.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysShopSuccessServiceImpl implements SysShopSuccessService {
   @Autowired
    LookShopMapper lookShopMapper;
   @Autowired
    TransferShopMapper transferShopMapper;
   @Autowired
    SuccessCaseMapper successCaseMapper;




    @Override
    public ResponseResult updateLookShopStatus(Long storeId) {
        ResponseResult result = new ResponseResult();
        LookShop lookShop = lookShopMapper.selectByPrimaryKey(storeId);
        lookShop.setStatus(1);
        lookShopMapper.updateByPrimaryKey(lookShop);
        return result;
    }

    @Override
    public ResponseResult updateTransferShopStatus(Long storeId) {
       ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(storeId);
        transferShop.setStatus(1);
        transferShopMapper.updateByPrimaryKey(transferShop);
        return result;
    }

    @Override
    public ResponseResult addSuccessCase(Long storeId, String shopSn) {
        ResponseResult result = new ResponseResult();
        SuccessCase successCase = new SuccessCase();
        successCase.setId(IdUtil.getId());
        successCase.setSuccessTime(new Date());
        TransferShopExample example = new TransferShopExample();
        TransferShopExample.Criteria criteria = example.createCriteria();
        criteria.andShopSnEqualTo(shopSn);
        List<TransferShop> transferShops = transferShopMapper.selectByExample(example);
        TransferShop transferShop = null;
        if (transferShops.size() > 0){
             transferShop = transferShops.get(0);
        }
        successCase.setLookShopId(storeId+"");
        successCase.setTransferShopId(transferShop.getId()+"");
        successCaseMapper.updateByPrimaryKey(successCase);
        updateLookShopStatus(storeId);
        updateTransferShopStatus(transferShop.getId());
        return result;
    }
}
