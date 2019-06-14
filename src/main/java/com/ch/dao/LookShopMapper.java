package com.ch.dao;

import com.ch.dto.ViewLookShopInfoDTO;
import com.ch.entity.LookShop;
import com.ch.entity.LookShopExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookShopMapper {
    int countByExample(LookShopExample example);

    int deleteByExample(LookShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LookShop record);

    int insertSelective(LookShop record);

    List<LookShop> selectByExample(LookShopExample example);

    LookShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LookShop record, @Param("example") LookShopExample example);

    int updateByExample(@Param("record") LookShop record, @Param("example") LookShopExample example);

    int updateByPrimaryKeySelective(LookShop record);

    int updateByPrimaryKey(LookShop record);

/*@Select("SELECT  t.id, t.tel,t.address,t.small_rent,t.top_rent,t.small_area,t.top_area,t.transfer_status,t.`status`,b.business_type AS businessTypes ,t.contacts as username,p.property_type AS propertyType ,s.shop_type AS shopType ,d.decorate_type AS decorateType ,c.city_name as city FROM look_shop t \n" +
        " JOIN  business_type   b  on  t.business_type_id=b.id\n" +
        " JOIN  property_type p on p.id=t.property_type_id\n" +
        " JOIN shop_type s on s.id = t.shop_type_id\n" +
        "JOIN decorate_type d on d.id = t.decorate_type_id\n" +
        "JOIN bs_city c on c.city_id = t.city_id\n" +
        "WHERE t.contacts like '%${contacts}%' AND t.tel like '%${tel}%' AND t.`status` =#{status}\n")*/
    List<ViewLookShopInfoDTO> list(@Param("contacts")String contacts,@Param("tel")String tel ,@Param("status")Integer status);

    @Select("SELECT  t.id, t.tel,t.address,t.small_rent,t.top_rent,t.small_area,t.top_area,t.transfer_status,t.`status` AS doneStatus,b.business_type AS businessTypes ,t.contacts as username,p.property_type AS propertyType ,s.shop_type AS shopType ,d.decorate_type AS decorateType ,c.city_name as city FROM look_shop t \n" +
            " JOIN  business_type   b  on  t.business_type_id=b.id\n" +
            " JOIN  property_type p on p.id=t.property_type_id\n" +
            " JOIN shop_type s on s.id = t.shop_type_id\n" +
            "JOIN decorate_type d on d.id = t.decorate_type_id\n" +
            "JOIN bs_city c on c.city_id = t.city_id")
   List<ViewLookShopInfoDTO> findAll();

}