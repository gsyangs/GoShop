package com.yunmayi.app.shoppingmall;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yunmayi.app.baselibrary.view.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = "/shoppingmall/main")
public class MainActivity extends BaseActivity {

    @BindView(R.id.text)
    TextView text;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main_shoppingmall;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitleTextId(R.string.app_name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
