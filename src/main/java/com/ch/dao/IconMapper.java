package com.ch.dao;


import java.util.List;

import com.ch.entity.IconExample;
import com.ch.entity.Icon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IconMapper {
    int countByExample(IconExample example);

    int deleteByExample(IconExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Icon record);

    int insertSelective(Icon record);

    List<Icon> selectByExample(IconExample example);

    Icon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Icon record, @Param("example") IconExample example);

    int updateByExample(@Param("record") Icon record, @Param("example") IconExample example);

    int updateByPrimaryKeySelective(Icon record);

    int updateByPrimaryKey(Icon record);
}