package com.ch.dao;

import com.ch.dao.provider.TransferShopProvider;
import com.ch.dto.SysTransferShopDTO;
import com.ch.dto.ViewBrowseTransferShopDTO;
import com.ch.dto.ViewDealDTO;
import com.ch.dto.ViewNearbyShopDTO;
import com.ch.entity.TransferShop;
import com.ch.entity.TransferShopExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferShopMapper {
    int countByExample(TransferShopExample example);

    int deleteByExample(TransferShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferShop record);

    int insertSelective(TransferShop record);

    List<TransferShop> selectByExample(TransferShopExample example);

    TransferShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferShop record, @Param("example") TransferShopExample example);

    int updateByExample(@Param("record") TransferShop record, @Param("example") TransferShopExample example);

    int updateByPrimaryKeySelective(TransferShop record);

    int updateByPrimaryKey(TransferShop record);

   @Select("SELECT  t.id,t.recommend_type,t.shop_sn as shopSn, t.tel,t.accessory_requirements,t.recommend_type,t.address,t.area,t.rent,t.transfer_fee,t.`status` AS doneStatus,t.check_status,t.contacts as username,p.property_type AS propertyType ,s.shop_type AS shopType ,d.decorate_type AS decorateType ,c.city_name as city FROM transfer_shop t\n" +
           " JOIN  property_type p on p.id=t.property_type_id\n" +
           " JOIN shop_type s on s.id = t.shop_type_id\n" +
           "JOIN decorate_type d on d.id = t.decorate_type_id\n" +
           "JOIN bs_city c on c.city_id = t.city_id order by create_time desc \n")

    List<SysTransferShopDTO> findAll();

    List<SysTransferShopDTO> list1(@Param("contacts") String contacts ,@Param("tel") String tel,@Param("status")Integer status,@Param("recommendType")Integer recommendType,@Param("checkStatus") Integer checkStatus);

    @SelectProvider(type = TransferShopProvider.class, method = "getList")
    List<SysTransferShopDTO> list(@Param("name") String name, @Param("tel") String tel, @Param("status") Integer status, @Param("type") Integer type, @Param("checkStatus") Integer checkStatus);

    @Select("select ts.image, ts.title,CONCAT((select area_name from bs_area aa where aa.area_id = ts.area_id),'-', (select street_name from bs_street sa where sa.street_id = ts.street_id)) as address," +
            "       ts.area, ts.rent, unix_timestamp(bs.create_date) as create_date, ts.id from browsing_history bs  join transfer_shop ts on bs.transfer_shop_id = ts.id  where bs.client_id  = #{userId} order by bs.create_date desc")
    List<ViewBrowseTransferShopDTO> myList(@Param("userId") Long userId);

    @Select(" select (SELECT header from client where id = #{userId}) as image , t.title ," +
            " CONCAT((select area_name from bs_area aa where aa.area_id = t.area_id),'-', " +
            " (select street_name from bs_street sa where sa.street_id = t.street_id)) as address," +
            "    t.rent, t.area, unix_timestamp(b.create_date) as create_date, t.id " +
            "   from  house_collect  b left  join transfer_shop  t on  b.transfer_shop_id=t.id   " +
            " where b.client_id = #{userId} order by b.create_date desc")
    List<ViewBrowseTransferShopDTO> myHouseCollectList(@Param("userId") Long userId);


    @Select("SELECT" +
            "  id,title, image, CONCAT((select area_name from bs_area aa where aa.area_id = ts.area_id),'-', (select street_name from bs_street sa where sa.street_id = ts.street_id)) as address," +
            "     area,rent,lon,lat,unix_timestamp(create_time) as time,(" +
            "    6371 * acos (" +
            "      cos ( radians(#{lat}) )" +
            "      * cos( radians( lat ) )" +
            "      * cos( radians( lon ) - radians(#{lon}) )" +
            "      + sin ( radians(#{lat}) )" +
            "      * sin( radians( lat ) )" +
            "    )" +
            "  ) AS distance" +
            " FROM transfer_shop ts where check_status = 1 and status = 0" +
            " HAVING distance < 3" +
            " ORDER BY distance desc")
    List<ViewNearbyShopDTO> nearbyShop(@Param("lon") String lon, @Param("lat") String lat);


    @Select("select id, title, CONCAT((select area_name from bs_area aa where aa.area_id = ts.area_id),'-', (select street_name from bs_street sa where sa.street_id = ts.street_id)) as address," +
            " area, rent, success_time from transfer_shop ts where ts.status = 1")
    List<ViewDealDTO> dealList();

    @Select("select id, title, CONCAT((select area_name from bs_area aa where aa.area_id = ts.area_id),'-', (select street_name from bs_street sa where sa.street_id = ts.street_id)) as address," +
            " area, rent, unix_timestamp(success_time) as success_date, image from transfer_shop ts where ts.id in (select sc.transfer_shop_id from success_case sc where sc.sys_user = #{userId})")
    List<ViewDealDTO> intermediaryList(@Param("userId") Long userId);

    @Select("select count(*) from transfer_shop where to_days(check_time) = to_days(now())")
    int countTodayShop();
}