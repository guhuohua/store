package com.ch.dao;


import java.util.List;

import com.ch.entity.SysUserShop;
import com.ch.entity.SysUserShopExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserShopMapper {
    int countByExample(SysUserShopExample example);

    int deleteByExample(SysUserShopExample example);

    int insert(SysUserShop record);

    int insertSelective(SysUserShop record);

    List<SysUserShop> selectByExample(SysUserShopExample example);

    int updateByExampleSelective(@Param("record") SysUserShop record, @Param("example") SysUserShopExample example);

    int updateByExample(@Param("record") SysUserShop record, @Param("example") SysUserShopExample example);
}