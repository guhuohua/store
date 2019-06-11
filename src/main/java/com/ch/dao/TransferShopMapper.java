package com.ch.dao;

import com.ch.dao.provider.TransferShopProvider;
import com.ch.entity.TransferShop;
import com.ch.entity.TransferShopExample;
import java.util.List;

import com.ch.model.SysTransferShopDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferShopMapper {
    int countByExample(TransferShopExample example);

    int deleteByExample(TransferShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferShop record);

    int insertSelective(TransferShop record);

    List<TransferShop> selectByExample(TransferShopExample example);

    TransferShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferShop record, @Param("example") TransferShopExample example);

    int updateByExample(@Param("record") TransferShop record, @Param("example") TransferShopExample example);

    int updateByPrimaryKeySelective(TransferShop record);

    int updateByPrimaryKey(TransferShop record);

    @SelectProvider(type = TransferShopProvider.class, method = "getList")
    List<SysTransferShopDTO> list(@Param("name") String name, @Param("tel") String tel, @Param("status") Integer status, @Param("type") Integer type);
}