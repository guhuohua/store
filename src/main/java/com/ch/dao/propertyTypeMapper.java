package com.ch.dao;


import java.util.List;

import com.ch.entity.PropertyTypeExample;
import com.ch.entity.PropertyType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeMapper {
    int countByExample(PropertyTypeExample example);

    int deleteByExample(PropertyTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PropertyType record);

    int insertSelective(PropertyType record);

    List<PropertyType> selectByExample(PropertyTypeExample example);

    PropertyType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PropertyType record, @Param("example") PropertyTypeExample example);

    int updateByExample(@Param("record") PropertyType record, @Param("example") PropertyTypeExample example);

    int updateByPrimaryKeySelective(PropertyType record);

    int updateByPrimaryKey(PropertyType record);
}