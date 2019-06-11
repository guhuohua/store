package com.ch.dao.provider;

import com.ch.base.BeanUtils;

import java.util.Map;

public class TransferShopProvider {

    public String getList(Map<String, Object> map) {
        //获取参数列表
        String name = (String) map.get("name");
        String tel = (String) map.get("tel");
        Integer status = (Integer) map.get("status");
        Integer type = (Integer) map.get("type");
        StringBuilder sb = new StringBuilder("select id, shop_sn, contacts, tel,(select city_name from bs_city where city_id = ts.city_id) as city," +
                "       (select property_type from property_type where id = ts.property_type_id) as propertyType," +
                "       (select shop_type from shop_type where id = ts.shop_type_id) as shopTye, rent, area, transfer_fee, status, check_status" +
                " from transfer_shop ts where 1 = 1");
        if (BeanUtils.isNotEmpty(name)) {
            sb.append(" and contacts  like '%").append(name).append("%'");
        }
        if (BeanUtils.isNotEmpty(tel)) {
            sb.append(" and tel = ").append(tel);
        }
        if (null != status) {
            sb.append(" and status = ").append(status);
        }
        if (null != type) {
            sb.append(" and recommend_type = ").append(type);
        }
        sb.append(" order by update_time desc");
        return sb.toString();
    }
}
