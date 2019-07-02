package com.ch.dao.provider;

import java.util.Map;

public class SysUserMapperProvider {

    public String getUserList(Map<String, Object> map) {
        Long businessId = (Long) map.get("businessId");
        Integer index = (Integer) map.get("index");
        Integer size = (Integer) map.get("size");
        StringBuffer sb  = new StringBuffer("select su.user_id as id, su.head_image, su.username as name, su.phone from sys_user su where su.user_id in" +
                "  (select sur.user_id from sys_user_role sur where role_id = (select sr.role_id from sys_role sr where role_name = '中介'))");
        if (null != businessId) {
            sb.append(" and su.user_id in (select sub.sys_user_id from sys_user_business sub where sub.business_type_id = ").append(businessId).append(")");
        }
        sb.append(" limit ").append(index).append(",").append(size);
        return sb.toString();
    }

    public String getUserListCount(Map<String, Object> map) {
        StringBuffer sb  = new StringBuffer("select count(*) from sys_user su where su.user_id in" +
                "  (select sur.user_id from sys_user_role sur where role_id = (select sr.role_id from sys_role sr where role_name = '中介'))");
        return sb.toString();
    }
}
