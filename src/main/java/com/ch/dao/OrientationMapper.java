package com.ch.dao;


import java.util.List;

import com.ch.entity.OrientationExample;
import com.ch.entity.Orientation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrientationMapper {
    int countByExample(OrientationExample example);

    int deleteByExample(OrientationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Orientation record);

    int insertSelective(Orientation record);

    List<Orientation> selectByExample(OrientationExample example);

    Orientation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Orientation record, @Param("example") OrientationExample example);

    int updateByExample(@Param("record") Orientation record, @Param("example") OrientationExample example);

    int updateByPrimaryKeySelective(Orientation record);

    int updateByPrimaryKey(Orientation record);
}