package com.ch.dao;

import com.ch.entity.SysUserBusiness;
import com.ch.entity.SysUserBusinessExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserBusinessMapper {
    long countByExample(SysUserBusinessExample example);

    int deleteByExample(SysUserBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserBusiness record);

    int insertSelective(SysUserBusiness record);

    List<SysUserBusiness> selectByExample(SysUserBusinessExample example);

    SysUserBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserBusiness record, @Param("example") SysUserBusinessExample example);

    int updateByExample(@Param("record") SysUserBusiness record, @Param("example") SysUserBusinessExample example);

    int updateByPrimaryKeySelective(SysUserBusiness record);

    int updateByPrimaryKey(SysUserBusiness record);
}