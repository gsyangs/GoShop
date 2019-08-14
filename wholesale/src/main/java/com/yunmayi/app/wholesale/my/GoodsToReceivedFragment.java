package com.yunmayi.app.wholesale.my;


import com.yunmayi.app.baselibrary.view.BaseFragment;
import com.yunmayi.app.wholesale.R;

/**
 * Created by ys on 2018/4/22.
 * 待收货
 */

public class GoodsToReceivedFragment extends BaseFragment{
    private static GoodsToReceivedFragment goodsToReceivedFragment;

    public static GoodsToReceivedFragment newInstance() {
        if (goodsToReceivedFragment == null) {
            goodsToReceivedFragment = new GoodsToReceivedFragment();
        }
        return goodsToReceivedFragment;
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