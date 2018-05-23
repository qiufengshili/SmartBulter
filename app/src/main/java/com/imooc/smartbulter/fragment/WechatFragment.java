package com.imooc.smartbulter.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.smartbulter.R;

/**
 * PROJECT_NAME: SmartBulter
 * PACKAGE_NAME: com.imooc.smartbulter.fragment
 * FILE_NAME: WechatFragment
 * USER: TB
 * DATE: 2018-05-21 16:19.
 * DESCRIBE: 微信精选
 */
public class WechatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wechat,null);
        return view;
    }
}
