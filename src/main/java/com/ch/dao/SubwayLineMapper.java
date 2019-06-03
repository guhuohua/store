package com.ch.dao;


import java.util.List;

import com.ch.entity.SubwayLine;
import com.ch.entity.SubwayLineExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubwayLineMapper {
    int countByExample(SubwayLineExample example);

    int deleteByExample(SubwayLineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubwayLine record);

    int insertSelective(SubwayLine record);

    List<SubwayLine> selectByExample(SubwayLineExample example);

    SubwayLine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubwayLine record, @Param("example") SubwayLineExample example);

    int updateByExample(@Param("record") SubwayLine record, @Param("example") SubwayLineExample example);

    int updateByPrimaryKeySelective(SubwayLine record);

    int updateByPrimaryKey(SubwayLine record);
}