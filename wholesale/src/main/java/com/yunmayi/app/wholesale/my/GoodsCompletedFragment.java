package com.yunmayi.app.wholesale.my;


import com.yunmayi.app.baselibrary.view.BaseFragment;
import com.yunmayi.app.wholesale.R;

/**
 * Created by ys on 2018/4/22.
 * 已完成
 */

public class GoodsCompletedFragment extends BaseFragment{
    private static GoodsCompletedFragment goodsCompletedFragment;

    public static GoodsCompletedFragment newInstance() {
        if (goodsCompletedFragment == null) {
            goodsCompletedFragment = new GoodsCompletedFragment();
        }
        return goodsCompletedFragment;
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