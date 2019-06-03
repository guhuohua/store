package com.ch.dao;


import java.util.List;

import com.ch.entity.CityType;
import com.ch.entity.CityTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityTypeMapper {
    int countByExample(CityTypeExample example);

    int deleteByExample(CityTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CityType record);

    int insertSelective(CityType record);

    List<CityType> selectByExample(CityTypeExample example);

    CityType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CityType record, @Param("example") CityTypeExample example);

    int updateByExample(@Param("record") CityType record, @Param("example") CityTypeExample example);

    int updateByPrimaryKeySelective(CityType record);

    int updateByPrimaryKey(CityType record);
}