package com.ch.dao;


import java.util.List;

import com.ch.entity.TransferIcon;
import com.ch.entity.TransferIconExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferIconMapper {
    int countByExample(TransferIconExample example);

    int deleteByExample(TransferIconExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferIcon record);

    int insertSelective(TransferIcon record);

    List<TransferIcon> selectByExample(TransferIconExample example);

    TransferIcon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferIcon record, @Param("example") TransferIconExample example);

    int updateByExample(@Param("record") TransferIcon record, @Param("example") TransferIconExample example);

    int updateByPrimaryKeySelective(TransferIcon record);

    int updateByPrimaryKey(TransferIcon record);
}