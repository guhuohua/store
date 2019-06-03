package com.ch.dao;


import java.util.List;

import com.ch.entity.TransferImage;
import com.ch.entity.TransferImageExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferImageMapper {
    int countByExample(TransferImageExample example);

    int deleteByExample(TransferImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferImage record);

    int insertSelective(TransferImage record);

    List<TransferImage> selectByExample(TransferImageExample example);

    TransferImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferImage record, @Param("example") TransferImageExample example);

    int updateByExample(@Param("record") TransferImage record, @Param("example") TransferImageExample example);

    int updateByPrimaryKeySelective(TransferImage record);

    int updateByPrimaryKey(TransferImage record);
}