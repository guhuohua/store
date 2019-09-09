package com.ch.dao.provider;

import java.util.Map;

public class BtSysUserProvider {

    public String getUserList(Map<String, Object> map) {
        //获取参数列表
        String userName = (String) map.get("userName");
        String phone = (String) map.get("phone");
        StringBuffer sb = new StringBuffer("select bsu.username, bsu.phone, bsr.role_desc, bsu.account, bsu.status, DATE_FORMAT(bsu.update_time,'%Y-%m-%d %H:%i:%s') as update_time, bsu.user_id, bsur.role_id from sys_user bsu left join " +
                "  sys_user_role bsur on bsu.user_id = bsur.user_id left join " +
                "  sys_role bsr on bsur.role_id = bsr.role_id where 1=1 ");
        if (userName != null && userName != "") {
            sb.append(" and bsu.username like '%").append(userName).append("%'");
        }
        if (phone != null && phone != "") {
            sb.append(" and bsu.phone = '").append(phone).append("'");
        }
        return sb.toString();
    }


    public String getAgentList(Map<String, Object> map) {
        //获取参数列表
        String userName = (String) map.get("userName");
        String phone = (String) map.get("phone");
        StringBuffer sb = new StringBuffer("select bsu.username, bsu.phone, bsr.role_desc,bsc.city_name as cityName, bsc.city_id  , bsu.account, bsu.status, DATE_FORMAT(bsu.update_time,'%Y-%m-%d %H:%i:%s') as update_time, bsu.user_id, bsur.role_id from sys_user bsu left join " +
                "  sys_user_role bsur on bsu.user_id = bsur.user_id left join " +
                "  bs_city bsc on bsu.city_id = bsc.city_id left join "+
                "  sys_role bsr on bsur.role_id = bsr.role_id where 1=1 and bsr.role_id = 12");
        if (userName != null && userName != "") {
            sb.append(" and bsu.username like '%").append(userName).append("%'");
        }
        if (phone != null && phone != "") {
            sb.append(" and bsu.phone = '").append(phone).append("'");
        }
        return sb.toString();
    }
}
