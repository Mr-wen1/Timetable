package com.potato.timetable.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.potato.timetable.R;

public class Config {
    private static int currentWeek = 1;//表示当前周数
    private static boolean flagCurrentWeek = false;//利用该flag,进行周一的周数更新
    private static float cardViewAlpha = 1.0f;//卡片布局的透明度 值为0.0-1.0
    private static int MAX_WEEK_NUM = 25;//最大周数
    private static int MAX_CLASS_NUM = 12;
    private static String collegeName;


    private static final String KEY_WEEK_OF_TERM = "long_current_week";
    private static final String KEY_FLAG_WEEK = "flag_week";
    private static final String KEY_CARD_VIEW_ALPHA = "card_view_alpha";
    private static final String KEY_COLLEGE_NAME="college_name";


    public static int getMaxWeekNum() {
        return MAX_WEEK_NUM;
    }

    public static int getMaxClassNum() {
        return MAX_CLASS_NUM;
    }


    public static int currentWeekAdd() {
        return ++currentWeek;
    }

    public static int getCurrentWeek() {
        return currentWeek;
    }

    public static void setCurrentWeek(int currentWeek) {
        Config.currentWeek = currentWeek;
    }

    public static boolean isFlagCurrentWeek() {
        return flagCurrentWeek;
    }

    public static void setFlagCurrentWeek(boolean flagCurrentWeek) {
        Config.flagCurrentWeek = flagCurrentWeek;
    }

    public static String getCollegeName() {
        return collegeName;
    }

    public static void setCollegeName(String collegeName) {
        Config.collegeName = collegeName;
    }



    /**
     * 保存
     * @param context
     */
    public static void saveCurrentWeek(final Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Log.d("weeknum", "save=" + (Utils.getWeekNum() - currentWeek));
        editor.putLong(KEY_WEEK_OF_TERM, Utils.getWeekNum() - currentWeek);
        editor.apply();
    }

    /**
     * 读取用户设置
     *
     * @param context
     */
    public static void readFormSharedPreferences(Context context) {
        //读取当前周
        SharedPreferences sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);

        long weekNum = Utils.getWeekNum();
        currentWeek = (int) (weekNum - sharedPreferences.getLong(KEY_WEEK_OF_TERM, weekNum - 1));
        Log.d("weeknum", "currentWeek=" + currentWeek);
        currentWeek = currentWeek > 0 ? currentWeek : 1;
        flagCurrentWeek = sharedPreferences.getBoolean(KEY_FLAG_WEEK, false);//用于更新当前周数

        cardViewAlpha = sharedPreferences.getFloat(KEY_CARD_VIEW_ALPHA, 1.0f);
    }
}
