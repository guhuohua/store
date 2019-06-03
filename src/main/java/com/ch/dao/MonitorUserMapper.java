package com.ch.dao;


import java.util.List;

import com.ch.entity.MonitorUser;
import com.ch.entity.MonitorUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorUserMapper {
    int countByExample(MonitorUserExample example);

    int deleteByExample(MonitorUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MonitorUser record);

    int insertSelective(MonitorUser record);

    List<MonitorUser> selectByExample(MonitorUserExample example);

    MonitorUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MonitorUser record, @Param("example") MonitorUserExample example);

    int updateByExample(@Param("record") MonitorUser record, @Param("example") MonitorUserExample example);

    int updateByPrimaryKeySelective(MonitorUser record);

    int updateByPrimaryKey(MonitorUser record);
}