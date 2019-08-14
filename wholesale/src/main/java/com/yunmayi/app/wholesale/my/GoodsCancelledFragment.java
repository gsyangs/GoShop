package com.yunmayi.app.wholesale.my;


import com.yunmayi.app.baselibrary.view.BaseFragment;
import com.yunmayi.app.wholesale.R;

/**
 * Created by ys on 2018/4/22.
 * 已取消
 */

public class GoodsCancelledFragment extends BaseFragment{
    private static GoodsCancelledFragment goodsCancelledFragment;

    public static GoodsCancelledFragment newInstance() {
        if (goodsCancelledFragment == null) {
            goodsCancelledFragment = new GoodsCancelledFragment();
        }
        return goodsCancelledFragment;
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