package com.ch.dao;

import com.ch.entity.LookShopBaseIcon;
import com.ch.entity.LookShopBaseIconExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookShopBaseIconMapper {
    long countByExample(LookShopBaseIconExample example);

    int deleteByExample(LookShopBaseIconExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LookShopBaseIcon record);

    int insertSelective(LookShopBaseIcon record);

    List<LookShopBaseIcon> selectByExample(LookShopBaseIconExample example);

    LookShopBaseIcon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LookShopBaseIcon record, @Param("example") LookShopBaseIconExample example);

    int updateByExample(@Param("record") LookShopBaseIcon record, @Param("example") LookShopBaseIconExample example);

    int updateByPrimaryKeySelective(LookShopBaseIcon record);

    int updateByPrimaryKey(LookShopBaseIcon record);
}