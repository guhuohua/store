package com.ch.dao;

import com.ch.entity.FastLookShop;
import com.ch.entity.FastLookShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FastLookShopMapper {
    int countByExample(FastLookShopExample example);

    int deleteByExample(FastLookShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FastLookShop record);

    int insertSelective(FastLookShop record);

    List<FastLookShop> selectByExample(FastLookShopExample example);

    FastLookShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FastLookShop record, @Param("example") FastLookShopExample example);

    int updateByExample(@Param("record") FastLookShop record, @Param("example") FastLookShopExample example);

    int updateByPrimaryKeySelective(FastLookShop record);

    int updateByPrimaryKey(FastLookShop record);
}