package com.ch.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpJavaPost {

    public static String sendPost(String url, String param) throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();// 设置通用请求的属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json");// 我加的一个头
            String base64 = "appKey:941b5e2749704dea9b66c743";
            String encode = Base64Util.encode(base64.getBytes());
            conn.setRequestProperty("Authorization", encode);

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    result += line;

                }
            } catch (IOException e) {
                System.out.println("发送POST请求出现异常");
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            String s = HttpJavaPost.sendPost("https://api.im.jpush.cn/v1/users/", "username=sasja&password=12121");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
