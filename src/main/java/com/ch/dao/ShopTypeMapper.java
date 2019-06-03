package com.ch.dao;


import java.util.List;

import com.ch.entity.ShopType;
import com.ch.entity.ShopTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopTypeMapper {
    int countByExample(ShopTypeExample example);

    int deleteByExample(ShopTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopType record);

    int insertSelective(ShopType record);

    List<ShopType> selectByExample(ShopTypeExample example);

    ShopType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopType record, @Param("example") ShopTypeExample example);

    int updateByExample(@Param("record") ShopType record, @Param("example") ShopTypeExample example);

    int updateByPrimaryKeySelective(ShopType record);

    int updateByPrimaryKey(ShopType record);
}