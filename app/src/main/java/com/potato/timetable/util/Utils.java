package com.potato.timetable.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 工具类：
 * 设置背景
 * <p>
 * 获取更新
 */
public class Utils {

    private static String PATH;


    public static void setPATH(String PATH) {
        Utils.PATH = PATH;
    }



    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 计算1970年1月4号0时0分0秒(周一)至今有多少周
     * 用于更新周数，用一年周数的话跨年会产生问题
     *
     * @return
     */
    public static long getWeekNum() {
        //System.currentTimeMillis()返回的是1970年1月4号0时0分0秒距今多少毫秒
        long day = System.currentTimeMillis() / (1000 * 60 * 60 * 24) - 4;//减四为1月4日距今多少天
        //Log.d("weeknum",String.valueOf(day/7+1));
        return day / 7 + 1;
    }


    /**
     * 获取星期
     *
     * @return 返回1-7代表周几 周日为1
     */
    public static int getWeekOfDay() {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
