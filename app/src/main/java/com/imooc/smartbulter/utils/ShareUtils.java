package com.imooc.smartbulter.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * PROJECT_NAME: SmartBulter
 * PACKAGE_NAME: com.imooc.smartbulter.utils
 * FILE_NAME: ShareUtils
 * USER: TB
 * DATE: 2018-05-22 14:08.
 * DESCRIBE: SharedPreferences 封装类
 */
public class ShareUtils {
   /*
     haredPreferences是一种轻型的数据存储方式，它的本质是基于XML文件存储key-value键
     对数据，通常来存储一些简单的配置信息
     SharedPreferences对象本身只能获取数据而不支持存储和修改，存储修改是通过Editor对象实现的
     1. 根据Context获取SharedPreferences对象
     2. 利用edit()方法获取editor对象
     3. 通过Editor对象存储key-value键值对数据
     4. 通过commit()方法提交数据    */

    public static final String NAME = "config";

    public static void putString(Context mContext, String key, String value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }

    public static String getString(Context mContext, String key, String defValue){
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void putInt(Context mContext, String key, int value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }

    public static int getInt(Context mContext, String key, int defValue){
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void putBoolean(Context mContext, String key, boolean value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }

    public static boolean getBoolean(Context mContext, String key, boolean defValue){
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void deleShare(Context mContext, String key){
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }

    public static void deleAll(Context mContext){
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }

}
