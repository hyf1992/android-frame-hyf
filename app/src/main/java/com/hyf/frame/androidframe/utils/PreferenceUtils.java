package com.hyf.frame.androidframe.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.blankj.utilcode.util.Utils;

/**
 * Created by hyf on 2018/3/27.
 */

public class PreferenceUtils {
    private static final String FILE_NAME = "preference_data";

    /**
     * 保存数据到文件
     *
     * @param key
     * @param data
     */
    public static void saveData(String key, Object data) {
        String type = data.getClass().getSimpleName();
        SharedPreferences sharedPreferences = Utils.getContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) data);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) data);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) data);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) data);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) data);
        }
        editor.apply();
    }

    /**
     * 从文件中读取数据
     *
     * @param key
     * @param defValue
     * @return
     */
    public static Object getData(String key, Object defValue) {

        String type = defValue.getClass().getSimpleName();
        SharedPreferences sharedPreferences = Utils.getContext().getSharedPreferences
                (FILE_NAME, Context.MODE_PRIVATE);

        //defValue为为默认值，如果当前获取不到数据就返回它
        if ("Integer".equals(type)) {
            return sharedPreferences.getInt(key, (Integer) defValue);
        } else if ("Boolean".equals(type)) {
            return sharedPreferences.getBoolean(key, (Boolean) defValue);
        } else if ("String".equals(type)) {
            return sharedPreferences.getString(key, (String) defValue);
        } else if ("Float".equals(type)) {
            return sharedPreferences.getFloat(key, (Float) defValue);
        } else if ("Long".equals(type)) {
            return sharedPreferences.getLong(key, (Long) defValue);
        }
        return null;
    }
}
