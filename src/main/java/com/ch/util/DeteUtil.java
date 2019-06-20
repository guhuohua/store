package com.ch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeteUtil {
    public static String  forMat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        return format;
    }
}
