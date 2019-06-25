package com.ch.dao;


import com.ch.entity.BrowsingHistory;
import com.ch.entity.BrowsingHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrowsingHistoryMapper {
    int countByExample(BrowsingHistoryExample example);

    int deleteByExample(BrowsingHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BrowsingHistory record);

    int insertSelective(BrowsingHistory record);

    List<BrowsingHistory> selectByExample(BrowsingHistoryExample example);

    BrowsingHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BrowsingHistory record, @Param("example") BrowsingHistoryExample example);

    int updateByExample(@Param("record") BrowsingHistory record, @Param("example") BrowsingHistoryExample example);

    int updateByPrimaryKeySelective(BrowsingHistory record);

    int updateByPrimaryKey(BrowsingHistory record);


    @Select("select count(*) from browsing_history where" +
            " client_id = #{clientId} and look_shop_id = #{lookShopId} or transfer_shop_id = #{id} ")
    int seleteExits(@Param("clientId") Long clientId, @Param("lookShopId") Long lookShopId, @Param("id") Long id);


    @Select("select * from browsing_history where client_id = #{clientId} order by create_date desc")
    List<BrowsingHistory> selectByclientId(@Param("clientId") Long clientId);
}