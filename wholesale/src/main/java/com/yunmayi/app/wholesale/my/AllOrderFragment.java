package com.yunmayi.app.wholesale.my;


import com.yunmayi.app.baselibrary.view.BaseFragment;
import com.yunmayi.app.wholesale.R;

/**
 * Created by ys on 2018/4/22.
 * 全部
 */

public class AllOrderFragment extends BaseFragment{
    private static AllOrderFragment allOrderFragment;

    public static AllOrderFragment newInstance() {
        if (allOrderFragment == null) {
            allOrderFragment = new AllOrderFragment();
        }
        return allOrderFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_order;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void stopLoad() {
        super.stopLoad();

    }

}