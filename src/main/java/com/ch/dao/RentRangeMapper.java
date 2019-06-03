package com.ch.dao;


import java.util.List;

import com.ch.entity.RentRange;
import com.ch.entity.RentRangeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRangeMapper {
    int countByExample(RentRangeExample example);

    int deleteByExample(RentRangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RentRange record);

    int insertSelective(RentRange record);

    List<RentRange> selectByExample(RentRangeExample example);

    RentRange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RentRange record, @Param("example") RentRangeExample example);

    int updateByExample(@Param("record") RentRange record, @Param("example") RentRangeExample example);

    int updateByPrimaryKeySelective(RentRange record);

    int updateByPrimaryKey(RentRange record);
}