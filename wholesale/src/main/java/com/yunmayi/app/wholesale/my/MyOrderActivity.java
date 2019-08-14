package com.yunmayi.app.wholesale.my;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yunmayi.app.baselibrary.view.BaseActivity;
import com.yunmayi.app.wholesale.R;

import java.lang.reflect.Field;

import butterknife.BindView;

/**
 * Created by ys on 2018/11/21.
 * 我的订单
 */
public class MyOrderActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.tab_viewpager)
    ViewPager tabViewpager;

    private Fragment[] mFragmentArrays = new Fragment[4];
    private String[] mTabTitles = new String[4];

    @Override
    protected int getContentViewLayoutID() {
        setHeadColorWhite(true);
        return R.layout.activity_my_order;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitleText("我的订单");

        setFragment();
    }

    private void setFragment(){
        mTabTitles[0] = "全部";
        mTabTitles[1] = "待收货";
        mTabTitles[2] = "已完成";
        mTabTitles[3] = "已取货";

        tablayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        tablayout.setPadding(0, 10, 0, 10);

        AllOrderFragment allOrderFragment0 = AllOrderFragment.newInstance();
        mFragmentArrays[0] = allOrderFragment0;
        GoodsToReceivedFragment goodsToReceivedFragment = GoodsToReceivedFragment.newInstance();
        mFragmentArrays[1] = goodsToReceivedFragment;
        GoodsCompletedFragment goodsCompletedFragment = GoodsCompletedFragment.newInstance();
        mFragmentArrays[2] = goodsCompletedFragment;
        GoodsCancelledFragment goodsCancelledFragment = GoodsCancelledFragment.newInstance();
        mFragmentArrays[3] = goodsCancelledFragment;

        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentArrays, mTabTitles);
        tabViewpager.setAdapter(viewPagerAdapter);
        tabViewpager.setOffscreenPageLimit(4);
        //将ViewPager和TabLayout绑定
        tablayout.setupWithViewPager(tabViewpager);
        setTabWidth(tablayout,30);

    }

    public static void setTabWidth(final TabLayout tabLayout, final int padding){
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距 注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = padding;
                        params.rightMargin = padding;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
