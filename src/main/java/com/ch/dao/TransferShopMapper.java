package com.ch.dao;

import com.ch.dto.SysTransferShopDTO;
import com.ch.dto.ViewBrowseTransferShopDTO;
import com.ch.entity.TransferShop;
import com.ch.entity.TransferShopExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

   @Select("SELECT  t.id,t.shop_sn as shopSn, t.tel,t.accessory_requirements,t.recommend_type,t.address,t.area,t.rent,t.transfer_fee,t.`status` AS doneStatus,t.check_status,t.contacts as username,p.property_type AS propertyType ,s.shop_type AS shopType ,d.decorate_type AS decorateType ,c.city_name as city FROM transfer_shop t\n" +
           " JOIN  property_type p on p.id=t.property_type_id\n" +
           " JOIN shop_type s on s.id = t.shop_type_id\n" +
           "JOIN decorate_type d on d.id = t.decorate_type_id\n" +
           "JOIN bs_city c on c.city_id = t.city_id\n")
    List<SysTransferShopDTO> findAll();

    List<SysTransferShopDTO> list(@Param("contacts") String contacts ,@Param("tel") String tel,@Param("status")Integer status,@Param("recommendType")Integer recommendType,@Param("checkStatus") Integer checkStatus);


    @Select("select ts.image, ts.title,CONCAT((select area_name from bs_area aa where aa.area_id = ts.area_id),'-', (select street_name from bs_street sa where sa.street_id = ts.street_id)) as address," +
            "       ts.area, ts.rent, bs.create_date, ts.id from browsing_history bs  join transfer_shop ts on bs.transfer_shop_id = ts.id and bs.client_id = ts.client_id where bs.client_id  = #{userId} order by bs.create_date desc")
    List<ViewBrowseTransferShopDTO> myList(@Param("userId") Long userId);

    @Select(" select   c.header as  image, t.title ,CONCAT((select area_name from bs_area aa where aa.area_id = t.area_id),'-', (select street_name from bs_street sa where sa.street_id = t.street_id)) as address," +
            "        t.rent, t.area, b.create_date, t.id" +
            " from  house_collect  b   join transfer_shop  t on  b.transfer_shop_id=t.id   join client  c   on  c.id=t.client_id where b.client_id = #{userId} order by b.create_date desc")
    List<ViewBrowseTransferShopDTO> myHouseCollectList(@Param("userId") Long userId);

}