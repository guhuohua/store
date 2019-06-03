package com.ch.dao;


import java.util.List;

import com.ch.entity.BsArea;
import com.ch.entity.BsAreaExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BsAreaMapper {
    int countByExample(BsAreaExample example);

    int deleteByExample(BsAreaExample example);

    int deleteByPrimaryKey(Integer areaId);

    int insert(BsArea record);

    int insertSelective(BsArea record);

    List<BsArea> selectByExample(BsAreaExample example);

    BsArea selectByPrimaryKey(Integer areaId);

    int updateByExampleSelective(@Param("record") BsArea record, @Param("example") BsAreaExample example);

    int updateByExample(@Param("record") BsArea record, @Param("example") BsAreaExample example);

    int updateByPrimaryKeySelective(BsArea record);

    int updateByPrimaryKey(BsArea record);
}