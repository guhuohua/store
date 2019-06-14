package com.ch.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BizAreaUtil {
    private static Logger logger = LoggerFactory.getLogger(BizAreaUtil.class);

    private static final String GET_BIZ_AREA_URL = "http://api.map.baidu.com/geocoder/v2/?ak=X7a2OqwFK1ktCQDG6SdT39zPNF9jmLtt&callback=renderReverse&output=json&pois=1&location=";

    public static String getBizArea(String lon, String lat) throws Exception{
        String url = GET_BIZ_AREA_URL + lat + "," + lon;   //先纬度后经度
        String resStr = sendGetRequest(url);
        System.out.println("resStr:" + resStr);
        int idx = resStr.indexOf("business\":") + 11;
        resStr = resStr.substring(idx);
        idx = resStr.indexOf("\"");
        String bizArea = resStr.substring(0,idx);
        return bizArea;
    }

    private static String sendGetRequest(String reqUrl) throws Exception{
        URL url = new URL(reqUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(8000);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        conn.connect();
        InputStream in = conn.getInputStream();
        BufferedReader bin = null;
        int resCode = conn.getResponseCode();
        StringBuilder sb = new StringBuilder();
        if (resCode == 200) {
            bin = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String line = null;
            while ((line = bin.readLine()) != null) {
                sb.append(line);
            }
        }else{
            logger.error("获取“商圈”错误，ResponseCode:{}",resCode);
        }
        if(bin != null){
            bin.close();
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getBizArea("114.396846", "30.502383"));
    }

}
