package com.ch.dao;


import java.util.List;

import com.ch.entity.propertyType;
import com.ch.entity.propertyTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface propertyTypeMapper {
    int countByExample(propertyTypeExample example);

    int deleteByExample(propertyTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(propertyType record);

    int insertSelective(propertyType record);

    List<propertyType> selectByExample(propertyTypeExample example);

    propertyType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") propertyType record, @Param("example") propertyTypeExample example);

    int updateByExample(@Param("record") propertyType record, @Param("example") propertyTypeExample example);

    int updateByPrimaryKeySelective(propertyType record);

    int updateByPrimaryKey(propertyType record);
}