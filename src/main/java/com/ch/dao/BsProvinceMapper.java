package com.ch.dao;


import java.util.List;

import com.ch.entity.BsProvince;
import com.ch.entity.BsProvinceExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BsProvinceMapper {
    int countByExample(BsProvinceExample example);

    int deleteByExample(BsProvinceExample example);

    int deleteByPrimaryKey(Integer provinceId);

    int insert(BsProvince record);

    int insertSelective(BsProvince record);

    List<BsProvince> selectByExample(BsProvinceExample example);

    BsProvince selectByPrimaryKey(Integer provinceId);

    int updateByExampleSelective(@Param("record") BsProvince record, @Param("example") BsProvinceExample example);

    int updateByExample(@Param("record") BsProvince record, @Param("example") BsProvinceExample example);

    int updateByPrimaryKeySelective(BsProvince record);

    int updateByPrimaryKey(BsProvince record);
}