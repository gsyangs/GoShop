package com.yunmayi.app;

import android.os.Bundle;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yunmayi.app.baselibrary.view.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentViewLayoutID() {
        hideTitleLayout(true);
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @OnClick(R.id.btn1)
    public void onBtn1(){
        ARouter.getInstance().build("/shoppingmall/main").navigation();
    }
    @OnClick(R.id.btn2)
    public void onBtn2(){
        ARouter.getInstance().build("/smallshop/main").navigation();
    }
    @OnClick(R.id.btn3)
    public void onBtn3(){
        ARouter.getInstance().build("/usercenter/main").navigation();
    }
    @OnClick(R.id.btn4)
    public void onBtn4(){
        ARouter.getInstance().build("/wholesale/main").navigation();
    }
}
