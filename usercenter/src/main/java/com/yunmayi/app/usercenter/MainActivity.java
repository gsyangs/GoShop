package com.yunmayi.app.usercenter;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yunmayi.app.baselibrary.view.BaseActivity;

@Route(path = "/usercenter/main")
public class MainActivity extends BaseActivity {

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main_usercenter;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitleTextId(R.string.app_name);
    }
}
