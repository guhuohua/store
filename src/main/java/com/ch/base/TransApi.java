package com.ch.base;


import com.alibaba.fastjson.JSONObject;
import com.ch.util.HttpsUtil;

import java.util.HashMap;
import java.util.Map;

public class TransApi {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private String appid;
    private String securityKey;

    public TransApi(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }

    public JSONObject getTransResult(String query, String from, String to) {
        Map<String, Object> params = buildParams(query, from, to);
        return HttpsUtil.doPost(TRANS_API_HOST, params);
    }

    private Map<String, Object> buildParams(String query, String from, String to) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.getInstance().getMD5(src));

        return params;
    }

}
