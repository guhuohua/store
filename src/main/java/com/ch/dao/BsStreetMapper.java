package com.ch.dao;


import java.util.List;

import com.ch.entity.BsStreet;
import com.ch.entity.BsStreetExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BsStreetMapper {
    int countByExample(BsStreetExample example);

    int deleteByExample(BsStreetExample example);

    int deleteByPrimaryKey(Integer streetId);

    int insert(BsStreet record);

    int insertSelective(BsStreet record);

    List<BsStreet> selectByExample(BsStreetExample example);

    BsStreet selectByPrimaryKey(Integer streetId);

    int updateByExampleSelective(@Param("record") BsStreet record, @Param("example") BsStreetExample example);

    int updateByExample(@Param("record") BsStreet record, @Param("example") BsStreetExample example);

    int updateByPrimaryKeySelective(BsStreet record);

    int updateByPrimaryKey(BsStreet record);
}