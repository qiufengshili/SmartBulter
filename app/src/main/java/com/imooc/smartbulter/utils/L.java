package com.imooc.smartbulter.utils;

import android.util.Log;

/**
 * PROJECT_NAME: SmartBulter
 * PACKAGE_NAME: com.imooc.smartbulter.utils
 * FILE_NAME: L
 * USER: TB
 * DATE: 2018-05-21 23:09.
 * DESCRIBE: Log 封装类
 */
public class L {

    //封装
    public static final boolean  DEBUG = true;
    //TAG
    public static final String TAG = "Smartbulter";

    public static void d(String text){
        if(DEBUG) {
            Log.d(TAG,text);
        }
    }

    public static void i(String text){
        if(DEBUG) {
            Log.d(TAG,text);
        }
    }

    public static void w(String text){
        if(DEBUG) {
            Log.d(TAG,text);
        }
    }

    public static void e(String text){
        if(DEBUG) {
            Log.d(TAG,text);
        }
    }

    public static void f(String text){
        if(DEBUG) {
            Log.d(TAG,text);
        }
    }


}
