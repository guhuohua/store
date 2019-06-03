package com.ch.dao;


import java.util.List;

import com.ch.entity.HouseCollect;
import com.ch.entity.HouseCollectExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseCollectMapper {
    int countByExample(HouseCollectExample example);

    int deleteByExample(HouseCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseCollect record);

    int insertSelective(HouseCollect record);

    List<HouseCollect> selectByExample(HouseCollectExample example);

    HouseCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseCollect record, @Param("example") HouseCollectExample example);

    int updateByExample(@Param("record") HouseCollect record, @Param("example") HouseCollectExample example);

    int updateByPrimaryKeySelective(HouseCollect record);

    int updateByPrimaryKey(HouseCollect record);
}