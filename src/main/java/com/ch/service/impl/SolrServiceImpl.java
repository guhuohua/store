/**
 * Author: 常富文
 * Date:   2019/6/4 17:53
 * Description:
 */

package com.ch.service.impl;

import com.alibaba.fastjson.JSON;
import com.ch.base.BeanUtils;
import com.ch.base.StoreSolrSchema;
import com.ch.dao.BsAreaMapper;
import com.ch.dao.BsStreetMapper;
import com.ch.dao.LookShopMapper;
import com.ch.dao.TransferShopMapper;
import com.ch.dto.SolrDTO;
import com.ch.entity.BsArea;
import com.ch.entity.BsStreet;
import com.ch.entity.LookShop;
import com.ch.entity.TransferShop;
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


    @Override
    @Async
    public void addSolr(SolrDTO solrDTO) {
        lowerShelf(solrDTO);
        if (BeanUtils.isNotEmpty(solrDTO.getTransferShopId())){
            TransferShop transferShop = transferShopMapper.selectByPrimaryKey(solrDTO.getTransferShopId());
            BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(transferShop.getStreetId());
            BsArea bsArea = bsAreaMapper.selectByPrimaryKey(transferShop.getAreaId());
            StoreSolrSchema storeSolrSchema = new StoreSolrSchema();
            modelMapper.map(transferShop, storeSolrSchema);
            storeSolrSchema.setId(IdUtil.getId()+"");
            storeSolrSchema.setTransferShopId(transferShop.getId());
            storeSolrSchema.setStoreImg(transferShop.getImage());
            storeSolrSchema.setStoreAddress(bsStreet.getStreetName());
            storeSolrSchema.setPresentPrice(transferShop.getRent());
            storeSolrSchema.setStoreArea( Long.valueOf(transferShop.getArea()));
            storeSolrSchema.setStoreCategory(transferShop.getRecommendType());
            storeSolrSchema.setStoreType(0);
            storeSolrSchema.setUserId(transferShop.getClientId());
            storeSolrSchema.setStoreStatus(transferShop.getStatus());
            storeSolrSchema.setStoreName(transferShop.getTitle());
            storeSolrSchema.setLatitude(transferShop.getLat());
            storeSolrSchema.setLongitude(transferShop.getLon());
            storeSolrSchema.setStoreAddress(bsArea.getAreaName()+"-"+bsStreet.getStreetName());

            try {
                System.out.println("准备同步solr:"+ JSON.toJSONString(storeSolrSchema));
                solrClient.addBean(storeSolrSchema);
                solrClient.commit();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("SOLR同步失败");
            } catch (SolrServerException e) {
                e.printStackTrace();
            }

        }
        if (BeanUtils.isNotEmpty(solrDTO.getLookShopId())){
            LookShop lookShop = lookShopMapper.selectByPrimaryKey(solrDTO.getLookShopId());
            StoreSolrSchema storeSolrSchema = new StoreSolrSchema();
            modelMapper.map(lookShop, storeSolrSchema);
            storeSolrSchema.setId(IdUtil.getId()+"");
            storeSolrSchema.setStoreAddress(lookShop.getAddress());
            storeSolrSchema.setPresentPrice(lookShop.getTopRent());
            storeSolrSchema.setOriginalPrice(lookShop.getSmallRent());
            storeSolrSchema.setMinStoreArea(lookShop.getSmallArea());
            storeSolrSchema.setMaxStoreArea(lookShop.getTopArea());
            /*storeSolrSchema.setStoreCategory(lookShop.G);*/
            storeSolrSchema.setStoreType(1);
            storeSolrSchema.setStoreStatus(lookShop.getStatus());

            try {
                System.out.println("准备同步solr:"+ JSON.toJSONString(storeSolrSchema));
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
    public  void lowerShelf(SolrDTO solrDTO) {
        try {
           if (BeanUtils.isNotEmpty(solrDTO.getLookShopId())){
               solrClient.deleteByQuery("lookShopId:" + solrDTO.getLookShopId());
           }
           if (BeanUtils.isNotEmpty(solrDTO.getTransferShopId())){
               solrClient.deleteByQuery("transferShopId:" + solrDTO.getTransferShopId());
           }

            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
