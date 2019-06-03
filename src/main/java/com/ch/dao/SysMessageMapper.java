package com.ch.dao;


import java.util.List;

import com.ch.entity.SysMessage;
import com.ch.entity.SysMessageExample;
import com.ch.entity.SysMessageWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMessageMapper {
    int countByExample(SysMessageExample example);

    int deleteByExample(SysMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysMessageWithBLOBs record);

    int insertSelective(SysMessageWithBLOBs record);

    List<SysMessageWithBLOBs> selectByExampleWithBLOBs(SysMessageExample example);

    List<SysMessage> selectByExample(SysMessageExample example);

    SysMessageWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMessageWithBLOBs record, @Param("example") SysMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") SysMessageWithBLOBs record, @Param("example") SysMessageExample example);

    int updateByExample(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

    int updateByPrimaryKeySelective(SysMessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysMessageWithBLOBs record);

    int updateByPrimaryKey(SysMessage record);
}