/**
 * Author: 常富文
 * Date:   2019/6/10 14:24
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.LookShopMapper;
import com.ch.dao.SuccessCaseMapper;
import com.ch.dao.TransferShopMapper;
import com.ch.dto.SolrDTO;
import com.ch.dto.SuccessCaseDTO;
import com.ch.entity.LookShop;
import com.ch.entity.SuccessCase;
import com.ch.entity.TransferShop;
import com.ch.entity.TransferShopExample;
import com.ch.model.SysSuccessCaseParm;
import com.ch.service.SolrService;
import com.ch.service.SysShopSuccessService;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    SolrService solrService;


    @Override
    public ResponseResult updateLookShopStatus(Long storeId) {
        ResponseResult result = new ResponseResult();
        LookShop lookShop = lookShopMapper.selectByPrimaryKey(storeId);
        lookShop.setStatus(1);
        lookShop.setSuccessTime(new Date());
        lookShopMapper.updateByPrimaryKey(lookShop);
        return result;
    }

    @Override
    public ResponseResult updateTransferShopStatus(Long storeId) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(storeId);
        transferShop.setStatus(1);
        transferShop.setSuccessTime(new Date());
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
        if (transferShops.size() > 0) {
            transferShop = transferShops.get(0);
        }
        successCase.setLookShopId(storeId + "");
        successCase.setTransferShopId(transferShop.getId() + "");
        successCaseMapper.insert(successCase);
        updateLookShopStatus(storeId);
        updateTransferShopStatus(transferShop.getId());
        SolrDTO solrDTO = new SolrDTO();
        solrDTO.setLookShopId(storeId);
        solrDTO.setTransferShopId(transferShop.getId());
        solrService.addSolr(solrDTO);

        return result;
    }

    @Override
    public ResponseResult showSuccessCaseList(SysSuccessCaseParm sysSuccessCaseParm) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysSuccessCaseParm.getPageNum(), sysSuccessCaseParm.getPageSize());
        List<SuccessCaseDTO> successCaseDTOS = new ArrayList<>();
        if (BeanUtils.isNotEmpty(sysSuccessCaseParm.getLooker())) {
            successCaseDTOS = successCaseMapper.list(sysSuccessCaseParm.getLooker(), sysSuccessCaseParm.getTransferTel(), sysSuccessCaseParm.getTransfer(), sysSuccessCaseParm.getTransferTel());
            for (SuccessCaseDTO successCaseDTO : successCaseDTOS) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                successCaseDTO.setFormartTime(sdf.format(successCaseDTO.getSuccessTime()));

            }
            PageInfo<SuccessCaseDTO> page = new PageInfo<>(successCaseDTOS);
            result.setData(page);
            return result;
        }
        if (BeanUtils.isNotEmpty(sysSuccessCaseParm.getLookTel())) {
            successCaseDTOS = successCaseMapper.list(sysSuccessCaseParm.getLooker(), sysSuccessCaseParm.getTransferTel(), sysSuccessCaseParm.getTransfer(), sysSuccessCaseParm.getTransferTel());
            for (SuccessCaseDTO successCaseDTO : successCaseDTOS) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                successCaseDTO.setFormartTime(sdf.format(successCaseDTO.getSuccessTime()));

            }
            PageInfo<SuccessCaseDTO> page = new PageInfo<>(successCaseDTOS);
            result.setData(page);
            return result;
        }
        if (BeanUtils.isNotEmpty(sysSuccessCaseParm.getTransfer())){
            successCaseDTOS = successCaseMapper.list(sysSuccessCaseParm.getLooker(), sysSuccessCaseParm.getTransferTel(), sysSuccessCaseParm.getTransfer(), sysSuccessCaseParm.getTransferTel());
            for (SuccessCaseDTO successCaseDTO : successCaseDTOS) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                successCaseDTO.setFormartTime(sdf.format(successCaseDTO.getSuccessTime()));

            }
            PageInfo<SuccessCaseDTO> page = new PageInfo<>(successCaseDTOS);
            result.setData(page);
            return result;
        }
        if (BeanUtils.isNotEmpty(sysSuccessCaseParm.getTransferTel())){
            successCaseDTOS = successCaseMapper.list(sysSuccessCaseParm.getLooker(), sysSuccessCaseParm.getTransferTel(), sysSuccessCaseParm.getTransfer(), sysSuccessCaseParm.getTransferTel());
            for (SuccessCaseDTO successCaseDTO : successCaseDTOS) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                successCaseDTO.setFormartTime(sdf.format(successCaseDTO.getSuccessTime()));

            }
            PageInfo<SuccessCaseDTO> page = new PageInfo<>(successCaseDTOS);
            result.setData(page);
            return result;
        }else {
            successCaseDTOS = successCaseMapper.findAll();
            for (SuccessCaseDTO successCaseDTO : successCaseDTOS) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                successCaseDTO.setFormartTime(sdf.format(successCaseDTO.getSuccessTime()));

            }
            PageInfo<SuccessCaseDTO> page = new PageInfo<>(successCaseDTOS);
            result.setData(page);
            return result;
        }




    }



}
