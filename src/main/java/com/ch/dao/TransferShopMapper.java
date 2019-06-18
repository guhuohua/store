package com.ch.dao;

import com.ch.dao.provider.TransferShopProvider;
import com.ch.dto.SysTransferShopDTO;
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

}