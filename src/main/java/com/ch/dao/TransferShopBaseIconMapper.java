package com.ch.dao;

import com.ch.entity.TransferShopBaseIcon;
import com.ch.entity.TransferShopBaseIconExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferShopBaseIconMapper {
    long countByExample(TransferShopBaseIconExample example);

    int deleteByExample(TransferShopBaseIconExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferShopBaseIcon record);

    int insertSelective(TransferShopBaseIcon record);

    List<TransferShopBaseIcon> selectByExample(TransferShopBaseIconExample example);

    TransferShopBaseIcon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferShopBaseIcon record, @Param("example") TransferShopBaseIconExample example);

    int updateByExample(@Param("record") TransferShopBaseIcon record, @Param("example") TransferShopBaseIconExample example);

    int updateByPrimaryKeySelective(TransferShopBaseIcon record);

    int updateByPrimaryKey(TransferShopBaseIcon record);
}