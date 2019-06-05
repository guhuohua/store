/**
 * Author: 常富文
 * Date:   2019/6/4 17:53
 * Description:
 */

package com.ch.service.impl;

import com.alibaba.fastjson.JSON;
import com.ch.base.BeanUtils;
import com.ch.base.StoreSolrSchema;
import com.ch.dao.LookShopMapper;
import com.ch.dao.TransferShopMapper;
import com.ch.dto.SolrDTO;
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


    @Override
    public void addSolr(SolrDTO solrDTO) {
        if (BeanUtils.isNotEmpty(solrDTO.getLookShopId())){
            TransferShop transferShop = transferShopMapper.selectByPrimaryKey(solrDTO.getLookShopId());
            StoreSolrSchema storeSolrSchema = new StoreSolrSchema();
            modelMapper.map(transferShop, storeSolrSchema);
            storeSolrSchema.setId(IdUtil.getId()+"");
            storeSolrSchema.setStoreImg(transferShop.getImage());
            storeSolrSchema.setStoreAddress(transferShop.getAddress());
            storeSolrSchema.setPresentPrice(transferShop.getRent());
            storeSolrSchema.setStoreArea( Long.valueOf(transferShop.getArea()));
            storeSolrSchema.setStoreCategory(transferShop.getRecommendType());
            storeSolrSchema.setStoreType(0);
            storeSolrSchema.setStoreStatus(transferShop.getStatus());
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
}
