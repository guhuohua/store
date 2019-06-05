package com.ch.dao;

import com.ch.entity.Look_Shop;
import com.ch.entity.Look_ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Look_ShopMapper {
    int countByExample(Look_ShopExample example);

    int deleteByExample(Look_ShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Look_Shop record);

    int insertSelective(Look_Shop record);

    List<Look_Shop> selectByExample(Look_ShopExample example);

    Look_Shop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Look_Shop record, @Param("example") Look_ShopExample example);

    int updateByExample(@Param("record") Look_Shop record, @Param("example") Look_ShopExample example);

    int updateByPrimaryKeySelective(Look_Shop record);

    int updateByPrimaryKey(Look_Shop record);
}