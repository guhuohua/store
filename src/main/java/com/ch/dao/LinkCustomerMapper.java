package com.ch.dao;


import java.util.List;

import com.ch.entity.LinkCustomer;
import com.ch.entity.LinkCustomerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkCustomerMapper {
    int countByExample(LinkCustomerExample example);

    int deleteByExample(LinkCustomerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LinkCustomer record);

    int insertSelective(LinkCustomer record);

    List<LinkCustomer> selectByExample(LinkCustomerExample example);

    LinkCustomer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LinkCustomer record, @Param("example") LinkCustomerExample example);

    int updateByExample(@Param("record") LinkCustomer record, @Param("example") LinkCustomerExample example);

    int updateByPrimaryKeySelective(LinkCustomer record);

    int updateByPrimaryKey(LinkCustomer record);
}