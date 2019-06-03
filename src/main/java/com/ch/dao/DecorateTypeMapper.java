package com.ch.dao;


import java.util.List;

import com.ch.entity.DecorateType;
import com.ch.entity.DecorateTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DecorateTypeMapper {
    int countByExample(DecorateTypeExample example);

    int deleteByExample(DecorateTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DecorateType record);

    int insertSelective(DecorateType record);

    List<DecorateType> selectByExample(DecorateTypeExample example);

    DecorateType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DecorateType record, @Param("example") DecorateTypeExample example);

    int updateByExample(@Param("record") DecorateType record, @Param("example") DecorateTypeExample example);

    int updateByPrimaryKeySelective(DecorateType record);

    int updateByPrimaryKey(DecorateType record);
}