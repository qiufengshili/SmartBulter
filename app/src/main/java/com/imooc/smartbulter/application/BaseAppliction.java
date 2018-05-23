package com.imooc.smartbulter.application;

import android.app.Application;

import com.imooc.smartbulter.utils.StaticClass;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * PROJECT_NAME: SmartBulter
 * PACKAGE_NAME: com.imooc.smartbulter.application
 * FILE_NAME: BaseAppliction
 * USER: TB
 * DATE: 2018-05-19 17:41.
 * DESCRIBE: Appliction
 */

public class BaseAppliction extends Application {

    //创建
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, true);
    }
}
