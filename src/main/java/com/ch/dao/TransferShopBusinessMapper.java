package com.ch.dao;


import java.util.List;

import com.ch.entity.TransferShopBusiness;
import com.ch.entity.TransferShopBusinessExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferShopBusinessMapper {
    int countByExample(TransferShopBusinessExample example);

    int deleteByExample(TransferShopBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferShopBusiness record);

    int insertSelective(TransferShopBusiness record);

    List<TransferShopBusiness> selectByExample(TransferShopBusinessExample example);

    TransferShopBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferShopBusiness record, @Param("example") TransferShopBusinessExample example);

    int updateByExample(@Param("record") TransferShopBusiness record, @Param("example") TransferShopBusinessExample example);

    int updateByPrimaryKeySelective(TransferShopBusiness record);

    int updateByPrimaryKey(TransferShopBusiness record);
}