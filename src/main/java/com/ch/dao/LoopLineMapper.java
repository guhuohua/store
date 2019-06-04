package com.ch.dao;


import java.util.List;

import com.ch.entity.LoopLine;
import com.ch.entity.LoopLineExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoopLineMapper {
    int countByExample(LoopLineExample example);

    int deleteByExample(LoopLineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoopLine record);

    int insertSelective(LoopLine record);

    List<LoopLine> selectByExample(LoopLineExample example);

    LoopLine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoopLine record, @Param("example") LoopLineExample example);

    int updateByExample(@Param("record") LoopLine record, @Param("example") LoopLineExample example);

    int updateByPrimaryKeySelective(LoopLine record);

    int updateByPrimaryKey(LoopLine record);
}