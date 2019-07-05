package com.ch.dao;

import com.ch.entity.Wang;
import com.ch.entity.WangExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WangMapper {
    int countByExample(WangExample example);

    int deleteByExample(WangExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Wang record);

    int insertSelective(Wang record);

    List<Wang> selectByExample(WangExample example);

    Wang selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Wang record, @Param("example") WangExample example);

    int updateByExample(@Param("record") Wang record, @Param("example") WangExample example);

    int updateByPrimaryKeySelective(Wang record);

    int updateByPrimaryKey(Wang record);
}