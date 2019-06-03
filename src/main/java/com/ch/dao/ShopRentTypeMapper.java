package com.ch.dao;


import java.util.List;

import com.ch.entity.ShopRentType;
import com.ch.entity.ShopRentTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRentTypeMapper {
    int countByExample(ShopRentTypeExample example);

    int deleteByExample(ShopRentTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopRentType record);

    int insertSelective(ShopRentType record);

    List<ShopRentType> selectByExample(ShopRentTypeExample example);

    ShopRentType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopRentType record, @Param("example") ShopRentTypeExample example);

    int updateByExample(@Param("record") ShopRentType record, @Param("example") ShopRentTypeExample example);

    int updateByPrimaryKeySelective(ShopRentType record);

    int updateByPrimaryKey(ShopRentType record);
}