package com.ch.dao;


import java.util.List;

import com.ch.entity.BsCity;
import com.ch.entity.BsCityExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BsCityMapper {
    int countByExample(BsCityExample example);

    int deleteByExample(BsCityExample example);

    int deleteByPrimaryKey(Integer cityId);

    int insert(BsCity record);

    int insertSelective(BsCity record);

    List<BsCity> selectByExample(BsCityExample example);

    BsCity selectByPrimaryKey(Integer cityId);

    int updateByExampleSelective(@Param("record") BsCity record, @Param("example") BsCityExample example);

    int updateByExample(@Param("record") BsCity record, @Param("example") BsCityExample example);

    int updateByPrimaryKeySelective(BsCity record);

    int updateByPrimaryKey(BsCity record);
}