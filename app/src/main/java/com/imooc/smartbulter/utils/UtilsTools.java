package com.imooc.smartbulter.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * PROJECT_NAME: SmartBulter
 * PACKAGE_NAME: com.imooc.smartbulter.utils
 * FILE_NAME: UtilsTools
 * USER: TANGBO
 * DATE: 2018-05-20 21:53.
 * DESCRIBE: 工具统一类
 */
public class UtilsTools {

    public static void setFont(Context mContext, TextView textView){
        //设置字体
        Typeface fontType = Typeface.createFromAsset(mContext.getAssets(),"fonts/FONT.TTF");
        textView.setTypeface(fontType);
    }
}
