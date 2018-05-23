package com.imooc.smartbulter.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.imooc.smartbulter.MainActivity;
import com.imooc.smartbulter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT_NAME: SmartBulter
 * PACKAGE_NAME: com.imooc.smartbulter.ui
 * FILE_NAME: GuideActivity
 * USER: TB
 * DATE: 2018-05-22 15:31.
 * DESCRIBE:引导页
 */
public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    //引导页
    private ViewPager mViewPager;
    //View容器
    private List<View> mList = new ArrayList<>();
    private View view1,view2,view3;
    //小圆点
    private ImageView point1, point2, point3;
    //跳过
    private ImageView iv_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    //初始化View
    private void initView() {
        mViewPager = findViewById(R.id.mViewPager);

        //初始化引导页面
        view1 = View.inflate(this,R.layout.pager_item_one,null);
        view2 = View.inflate(this,R.layout.pager_item_two,null);
        view3 = View.inflate(this,R.layout.pager_item_three,null);

        //初始化小圆点
        point1 = findViewById(R.id.point1);
        point2 = findViewById(R.id.point2);
        point3 = findViewById(R.id.point3);

        //初始化跳过
        iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);

        view3.findViewById(R.id.btn_start).setOnClickListener(this);

        mList.add(view1);
        mList.add(view2);
        mList.add(view3);

        //预加载
        mViewPager.setOffscreenPageLimit(mList.size());

        //mViewPager的滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当前被选中页面
            @Override
            public void onPageSelected(int position) {
               switch (position){
                   case 0:
                       setPointImg(true,false,false);
                       iv_back.setVisibility(View.VISIBLE);
                       break;
                   case 1:
                       setPointImg(false,true,false);
                       iv_back.setVisibility(View.VISIBLE);
                       break;
                    case 2:
                        setPointImg(false,false,true);
                        iv_back.setVisibility(View.GONE);
                       break;
               }
            }

            //这个方法在手指操作屏幕的时候发生变化。有三个值：1(PRESS) , 2(UP) ,0（END）,
            //手按下去只要是带滑动状态（不管怎么滑动）state就是1 然后手放开接着就会是2，然后是0
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置适配器
        mViewPager.setAdapter(new GuideAdapter());
    }

    //监听事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                break;
            case R.id.btn_start:
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                break;
        }
    }

    class GuideAdapter extends PagerAdapter {

        //获取总的item数量
        @Override
        public int getCount() {
            return mList.size();
        }

        //View 是否和 Object有关联关系
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        //初始化一个item数据的时候回调
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(mList.get(position));
            return mList.get(position);
        }

        //销毁一个item数据的时候会回调
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ((ViewPager)container).removeView(mList.get(position));
            //super.destroyItem(container, position, object);
        }
    }

    private void setPointImg(boolean isCheck1,boolean isCheck2,boolean isCheck3){
        if(isCheck1){
            point1.setBackgroundResource(R.drawable.point_on);
        } else {
            point1.setBackgroundResource(R.drawable.point_off);
        }

        if(isCheck2){
            point2.setBackgroundResource(R.drawable.point_on);
        } else {
            point2.setBackgroundResource(R.drawable.point_off);
        }

        if(isCheck3){
            point3.setBackgroundResource(R.drawable.point_on);
        } else {
            point3.setBackgroundResource(R.drawable.point_off);
        }
    }

}
