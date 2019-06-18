package com.ch.util;

import java.util.Random;

public class IdUtil {

    private static long tmpID = 0;

    private static boolean tmpIDlocked = false;

    public static long getId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }

    public static void main(String[] args) {
        System.out.println(IdUtil.getId());
    }
}
