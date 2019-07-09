package com.ch.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GaoDeUtil {

    private static Pattern pattern= Pattern.compile("\"location\":\"(\\d+\\.\\d+),(\\d+\\.\\d+)\"");

    public static List<String> getLon(String address) {
        try {
            String url = "http://restapi.amap.com/v3/geocode/geo?address="+address+"&output=JSON&key=433e5fbab4d1349c0ca01e14306504d9";
            URL myURL = null;
            URLConnection httpsConn = null;
            try {
                myURL = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            InputStreamReader insr = null;
            BufferedReader br = null;
            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
            if (httpsConn != null) {
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = "";
                String line = null;
                while((line= br.readLine())!=null){
                    data+=line;
                }
                Matcher matcher = pattern.matcher(data);
                if (matcher.find() && matcher.groupCount() == 2) {
                    double[] gps = new double[2];
                    List<String> list = new ArrayList<>();
                    list.add(matcher.group(1));
                    list.add(matcher.group(2));
                    return list;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
