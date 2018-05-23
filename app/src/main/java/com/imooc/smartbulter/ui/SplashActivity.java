package com.imooc.smartbulter.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.imooc.smartbulter.MainActivity;
import com.imooc.smartbulter.R;
import com.imooc.smartbulter.utils.ShareUtils;
import com.imooc.smartbulter.utils.StaticClass;
import com.imooc.smartbulter.utils.UtilsTools;

/**
 * PROJECT_NAME: SmartBulter
 * PACKAGE_NAME: com.imooc.smartbulter.ui
 * FILE_NAME: SplashActivity
 * USER: TB
 * DATE: 2018-05-22 14:42.
 * DESCRIBE: 闪屏页
 */
public class SplashActivity  extends AppCompatActivity{

    /**
     * 1.延迟2000ms
     * 2.判断程序是否第一次运行
     * 3.自定义字体
     * 4.Activity全屏主题
     */

    private TextView tv_splash;

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case StaticClass.HANDLER_SPLASH:
                    //判断程序是否是第一次运行
                    if(isFirst()){
                        //跳转到引导页
                        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    } else {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    //初始化View
    private void initView(){
        //延时2000ms发送
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);
        tv_splash = findViewById(R.id.tv_splash);
        //设置字体
        UtilsTools.setFont(this,tv_splash);

    }

    //判断程序是否第一次运行
    private boolean isFirst(){
        boolean isFirst = ShareUtils.getBoolean(this,StaticClass.SHARE_IS_FIRST,true);
        if(isFirst){ //第一次运行 没有值
            //第一次运行以后把值更改为false
            ShareUtils.putBoolean(this, StaticClass.SHARE_IS_FIRST, false);
            return true;
        } else {
            return false;
        }
    }

    //禁止返回键
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
