package com.ch.dao;


import com.ch.entity.CommerciaEstat;
import com.ch.entity.CommerciaEstatExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommerciaEstatMapper {
    int countByExample(CommerciaEstatExample example);

    int deleteByExample(CommerciaEstatExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommerciaEstat record);

    int insertSelective(CommerciaEstat record);

    List<CommerciaEstat> selectByExample(CommerciaEstatExample example);

    CommerciaEstat selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommerciaEstat record, @Param("example") CommerciaEstatExample example);

    int updateByExample(@Param("record") CommerciaEstat record, @Param("example") CommerciaEstatExample example);

    int updateByPrimaryKeySelective(CommerciaEstat record);

    int updateByPrimaryKey(CommerciaEstat record);


    List<String> findCategory();
}