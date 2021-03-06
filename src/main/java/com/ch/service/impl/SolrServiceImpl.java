/**
 * Author: 常富文
 * Date:   2019/6/4 17:53
 * Description:
 */

package com.ch.service.impl;

import com.alibaba.fastjson.JSON;
import com.ch.base.BeanUtils;
import com.ch.base.StoreSolrSchema;
import com.ch.dao.*;
import com.ch.dto.SolrDTO;
import com.ch.entity.*;
import com.ch.service.SolrService;
import com.ch.util.IdUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SolrServiceImpl implements SolrService {


    private static final Logger LOGGER = LogManager.getLogger(SolrServiceImpl.class);
    @Autowired
    SolrClient solrClient;
    @Autowired
    TransferShopMapper transferShopMapper;
    @Autowired
    LookShopMapper lookShopMapper;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BsStreetMapper bsStreetMapper;
    @Autowired
    BsAreaMapper bsAreaMapper;
    @Autowired
    ClientMapper clientMapper;

    @Autowired
    SuccessCaseMapper successCaseMapper;

    @Autowired
    BusinessTypeMapper businessTypeMapper;

    @Autowired
    TransferShopBusinessMapper transferShopBusinessMapper;


    @Override
    @Async
    public void addSolr(SolrDTO solrDTO) {
        lowerShelf(solrDTO);
        if (BeanUtils.isNotEmpty(solrDTO.getTransferShopId())) {
            TransferShop transferShop = transferShopMapper.selectByPrimaryKey(solrDTO.getTransferShopId());
            if (transferShop.getCheckStatus() == 1) {
                StringBuilder sb = new StringBuilder();
                TransferShopBusinessExample businessExample = new TransferShopBusinessExample();
                businessExample.createCriteria().andTransferShopIdEqualTo(transferShop.getId());
                List<TransferShopBusiness> transferShopBusinesses = transferShopBusinessMapper.selectByExample(businessExample);
                for (TransferShopBusiness transferShopBusiness:transferShopBusinesses) {
                    BusinessType businessType = businessTypeMapper.selectByPrimaryKey(transferShopBusiness.getBusinessTypeId());
                    if (BeanUtils.isNotEmpty(businessType)) {
                        sb.append(businessType.getBusinessType());
                    }
                }
                StringBuilder address = new StringBuilder();
                sb.append(transferShop.getTitle());
                BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(transferShop.getStreetId());
                BsArea bsArea = bsAreaMapper.selectByPrimaryKey(transferShop.getAreaId());
                if (BeanUtils.isNotEmpty(bsArea)) {
                    address.append(bsArea.getAreaName() + "-");
                }
                if (BeanUtils.isNotEmpty(bsStreet)) {
                    address.append(bsStreet.getStreetName());
                }
                sb.append(address);
                StoreSolrSchema storeSolrSchema = new StoreSolrSchema();
                modelMapper.map(transferShop, storeSolrSchema);
                storeSolrSchema.setId(IdUtil.getId() + "");
                storeSolrSchema.setTransferShopId(transferShop.getId());
                storeSolrSchema.setStoreImg(transferShop.getImage());
                storeSolrSchema.setStoreAddress(bsStreet.getStreetName());
                storeSolrSchema.setPresentPrice(transferShop.getRent());
                storeSolrSchema.setStoreArea(Long.valueOf(transferShop.getArea()));
                storeSolrSchema.setStoreCategory(transferShop.getRecommendType());
                storeSolrSchema.setStoreType(0);
                storeSolrSchema.setUserId(transferShop.getClientId());
                storeSolrSchema.setStoreStatus(transferShop.getStatus());
                storeSolrSchema.setContacts(transferShop.getContacts());
                storeSolrSchema.setStoreName(transferShop.getTitle());
                storeSolrSchema.setLatitude(transferShop.getLat());
                storeSolrSchema.setLongitude(transferShop.getLon());
                storeSolrSchema.setStoreAddress(address.toString());
                storeSolrSchema.setCreateTime(transferShop.getCreateTime().getTime());
                Client client = clientMapper.selectByPrimaryKey(transferShop.getClientId());
                storeSolrSchema.setStoreKeyWords(sb.toString());
                if (BeanUtils.isNotEmpty(client)) {
                    storeSolrSchema.setUsername(client.getNickName());
                }
                try {
                    System.out.println("准备同步solr:" + JSON.toJSONString(storeSolrSchema));
                    solrClient.addBean(storeSolrSchema);
                    solrClient.commit();
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.error("SOLR同步失败");
                } catch (SolrServerException e) {
                    e.printStackTrace();
                }
            }
        }
        if (BeanUtils.isNotEmpty(solrDTO.getLookShopId())) {
            StringBuilder address = new StringBuilder();
            LookShop lookShop = lookShopMapper.selectByPrimaryKey(solrDTO.getLookShopId());
            BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(lookShop.getStreetId());
            BsArea bsArea = bsAreaMapper.selectByPrimaryKey(lookShop.getAreaId());
            if (BeanUtils.isNotEmpty(bsArea)) {
                address.append(bsArea.getAreaName() + "-");
            }
            if (BeanUtils.isNotEmpty(bsStreet)) {
                address.append(bsStreet.getStreetName());
            }
            Client client = clientMapper.selectByPrimaryKey(lookShop.getClientId());
            StoreSolrSchema storeSolrSchema = new StoreSolrSchema();
            storeSolrSchema.setId(IdUtil.getId() + "");
            storeSolrSchema.setLookShopId(lookShop.getId());
            storeSolrSchema.setStoreName(lookShop.getTitle());
            storeSolrSchema.setStoreAddress(address.toString());
            storeSolrSchema.setPresentPrice(lookShop.getTopRent());
            storeSolrSchema.setOriginalPrice(lookShop.getSmallRent());
            storeSolrSchema.setMinStoreArea(lookShop.getSmallArea());
            storeSolrSchema.setMaxStoreArea(lookShop.getTopArea());
            storeSolrSchema.setStoreType(1);
            storeSolrSchema.setContacts(lookShop.getContacts());
            if (BeanUtils.isNotEmpty(client)) {
                storeSolrSchema.setStoreImg(client.getHeader());
            }
            storeSolrSchema.setStoreStatus(lookShop.getStatus());
            storeSolrSchema.setLongitude(lookShop.getLongitude());
            storeSolrSchema.setLatitude(lookShop.getLatitude());
            storeSolrSchema.setCreateTime(lookShop.getCraeateTime().getTime());
            storeSolrSchema.setProvinceId(lookShop.getProvinceId());
            storeSolrSchema.setCityId(lookShop.getCityId());
            storeSolrSchema.setAreaId(lookShop.getAreaId());
            storeSolrSchema.setStreetId(lookShop.getStreetId());
            storeSolrSchema.setUserId(lookShop.getClientId());
            storeSolrSchema.setCreateTime(lookShop.getCraeateTime().getTime());
            if (BeanUtils.isNotEmpty(client)) {
                storeSolrSchema.setUsername(client.getNickName());
            }
            try {
                System.out.println("准备同步solr:" + JSON.toJSONString(storeSolrSchema));
                solrClient.addBean(storeSolrSchema);
                solrClient.commit();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("SOLR同步失败");
            } catch (SolrServerException e) {
                e.printStackTrace();
            }
        }

    }


    @Async
    public void lowerShelf(SolrDTO solrDTO) {
        try {
            if (BeanUtils.isNotEmpty(solrDTO.getLookShopId())) {
                solrClient.deleteByQuery("lookShopId:" + solrDTO.getLookShopId());
            }
            if (BeanUtils.isNotEmpty(solrDTO.getTransferShopId())) {
                solrClient.deleteByQuery("transferShopId:" + solrDTO.getTransferShopId());
            }

            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Async
    public void deleteAll() {
        try {
            solrClient.deleteByQuery("*:*");

            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
