package com.ch.dao;


import java.util.List;

import com.ch.entity.LookShopBusiness;
import com.ch.entity.LookShopBusinessExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LookShopBusinessMapper {
    int countByExample(LookShopBusinessExample example);

    int deleteByExample(LookShopBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LookShopBusiness record);

    int insertSelective(LookShopBusiness record);

    List<LookShopBusiness> selectByExample(LookShopBusinessExample example);

    LookShopBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LookShopBusiness record, @Param("example") LookShopBusinessExample example);

    int updateByExample(@Param("record") LookShopBusiness record, @Param("example") LookShopBusinessExample example);

    int updateByPrimaryKeySelective(LookShopBusiness record);

    int updateByPrimaryKey(LookShopBusiness record);
}