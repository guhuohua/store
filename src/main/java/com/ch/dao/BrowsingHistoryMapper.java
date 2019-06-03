package com.ch.dao;


import java.util.List;

import com.ch.entity.BrowsingHistory;
import com.ch.entity.BrowsingHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowsingHistoryMapper {
    int countByExample(BrowsingHistoryExample example);

    int deleteByExample(BrowsingHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BrowsingHistory record);

    int insertSelective(BrowsingHistory record);

    List<BrowsingHistory> selectByExample(BrowsingHistoryExample example);

    BrowsingHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BrowsingHistory record, @Param("example") BrowsingHistoryExample example);

    int updateByExample(@Param("record") BrowsingHistory record, @Param("example") BrowsingHistoryExample example);

    int updateByPrimaryKeySelective(BrowsingHistory record);

    int updateByPrimaryKey(BrowsingHistory record);
}