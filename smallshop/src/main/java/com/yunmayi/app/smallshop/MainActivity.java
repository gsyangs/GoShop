package com.yunmayi.app.smallshop;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yunmayi.app.baselibrary.view.BaseActivity;
@Route(path = "/smallshop/main")
public class MainActivity extends BaseActivity {

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main_smallshop;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitleTextId(R.string.app_name);
    }
}
