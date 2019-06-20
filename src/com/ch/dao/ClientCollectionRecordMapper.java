package com.ch.dao;

import com.ch.entity.ClientCollectionRecord;
import com.ch.entity.ClientCollectionRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientCollectionRecordMapper {
    long countByExample(ClientCollectionRecordExample example);

    int deleteByExample(ClientCollectionRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClientCollectionRecord record);

    int insertSelective(ClientCollectionRecord record);

    List<ClientCollectionRecord> selectByExample(ClientCollectionRecordExample example);

    ClientCollectionRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClientCollectionRecord record, @Param("example") ClientCollectionRecordExample example);

    int updateByExample(@Param("record") ClientCollectionRecord record, @Param("example") ClientCollectionRecordExample example);

    int updateByPrimaryKeySelective(ClientCollectionRecord record);

    int updateByPrimaryKey(ClientCollectionRecord record);
}