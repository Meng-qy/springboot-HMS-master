package com.meng.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
    public static String getNowTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
