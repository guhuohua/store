package com.ch.dao;

import java.util.List;

import com.ch.entity.SuccessCase;
import com.ch.entity.SuccessCaseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessCaseMapper {
    int countByExample(SuccessCaseExample example);

    int deleteByExample(SuccessCaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SuccessCase record);

    int insertSelective(SuccessCase record);

    List<SuccessCase> selectByExample(SuccessCaseExample example);

    SuccessCase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SuccessCase record, @Param("example") SuccessCaseExample example);

    int updateByExample(@Param("record") SuccessCase record, @Param("example") SuccessCaseExample example);

    int updateByPrimaryKeySelective(SuccessCase record);

    int updateByPrimaryKey(SuccessCase record);
}