package com.ch.dao;

import com.ch.entity.FastTransferShop;
import com.ch.entity.FastTransferShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FastTransferShopMapper {
    int countByExample(FastTransferShopExample example);

    int deleteByExample(FastTransferShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FastTransferShop record);

    int insertSelective(FastTransferShop record);

    List<FastTransferShop> selectByExample(FastTransferShopExample example);

    FastTransferShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FastTransferShop record, @Param("example") FastTransferShopExample example);

    int updateByExample(@Param("record") FastTransferShop record, @Param("example") FastTransferShopExample example);

    int updateByPrimaryKeySelective(FastTransferShop record);

    int updateByPrimaryKey(FastTransferShop record);
}