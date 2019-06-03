package com.ch.dao;


import java.util.List;

import com.ch.entity.TransferLicense;
import com.ch.entity.TransferLicenseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferLicenseMapper {
    int countByExample(TransferLicenseExample example);

    int deleteByExample(TransferLicenseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferLicense record);

    int insertSelective(TransferLicense record);

    List<TransferLicense> selectByExample(TransferLicenseExample example);

    TransferLicense selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferLicense record, @Param("example") TransferLicenseExample example);

    int updateByExample(@Param("record") TransferLicense record, @Param("example") TransferLicenseExample example);

    int updateByPrimaryKeySelective(TransferLicense record);

    int updateByPrimaryKey(TransferLicense record);
}