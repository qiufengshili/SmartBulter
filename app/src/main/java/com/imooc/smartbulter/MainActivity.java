package com.imooc.smartbulter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.imooc.smartbulter.fragment.BulterFragment;
import com.imooc.smartbulter.fragment.GirlFragment;
import com.imooc.smartbulter.fragment.UserFragment;
import com.imooc.smartbulter.fragment.WechatFragment;
import com.imooc.smartbulter.ui.SettingActivity;
import com.imooc.smartbulter.utils.L;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //标签
    private TabLayout mTabLayout;
    //引导页
    private ViewPager mViewPager;
    //标签名
    private List<String> mTitle;
    //Fragment容器
    private List<Fragment> mFragment;
    //悬浮按钮
    private FloatingActionButton fab_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        //去掉阴影title上面的一条黑色阴影
        getSupportActionBar().setElevation(0);

    }

    //初始化数据
    private void initData(){
        mTitle = new ArrayList<>();

        //重点：中文字符一定要写在Values里面
        mTitle.add(getString(R.string.text_bulter));
        mTitle.add(getString(R.string.text_wechat));
        mTitle.add(getString(R.string.text_girl));
        mTitle.add(getString(R.string.text_user));

        mFragment = new ArrayList<>();
        mFragment.add(new BulterFragment());
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlFragment());
        mFragment.add(new UserFragment());
    }

    //初始化View
    private void initView(){
        mTabLayout = findViewById(R.id.mTabLayout); //标签
        mViewPager = findViewById(R.id.mViewPager); //滑动页面
        fab_setting = findViewById(R.id.fab_setting); //悬浮设置按钮
        fab_setting.setOnClickListener(this);

        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());

        //mViewPager的滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //这个方法会在屏幕滚动过程中不断被调用
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当前被选中页面
            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    fab_setting.setVisibility(View.GONE);
                } else {
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            //这个方法在手指操作屏幕的时候发生变化。有三个值：1(PRESS) , 2(UP) ,0（END）,
            //手按下去只要是带滑动状态（不管怎么滑动）state就是1 然后手放开接着就会是2，然后是0
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            //选中的item
            @Override
            public Fragment getItem(int position) {
                L.d("!!!!!!!!!"+position);
                return mFragment.get(position);
            }

            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }

            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }

        });

        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_setting:  //设置按钮跳转到设置页面
                startActivity(new Intent(this, SettingActivity.class));
                break;
        }
    }
}
