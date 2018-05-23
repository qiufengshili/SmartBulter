package com.imooc.smartbulter.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * PROJECT_NAME: SmartBulter
 * PACKAGE_NAME: com.imooc.smartbulter.ui
 * FILE_NAME: BaseActivity
 * USER: TB
 * DATE: 2018-05-20 11:49.
 * DESCRIBE: Activity 的基类
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * 主要做的事情
     * 1.统一的属性
     * 2.统一的接口
     * 3.统一的方法
     * @param savedInstanceState 保存的Activity的状态的
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //菜单栏操作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
