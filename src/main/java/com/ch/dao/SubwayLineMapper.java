package com.ch.dao;


import com.ch.entity.SubwayLine;
import com.ch.entity.SubwayLineExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubwayLineMapper {
    int countByExample(SubwayLineExample example);

    int deleteByExample(SubwayLineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubwayLine record);

    int insertSelective(SubwayLine record);

    List<SubwayLine> selectByExample(SubwayLineExample example);

    SubwayLine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubwayLine record, @Param("example") SubwayLineExample example);

    int updateByExample(@Param("record") SubwayLine record, @Param("example") SubwayLineExample example);

    int updateByPrimaryKeySelective(SubwayLine record);

    int updateByPrimaryKey(SubwayLine record);


    @Select("select * from subway_line t where t.city_id = #{cityId} ")
    List<SubwayLine> findByCityId(@Param("cityId") Integer cityId);
}