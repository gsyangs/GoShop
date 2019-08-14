package com.yunmayi.app.wholesale.my;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by ys on 2018/4/21.
 * 首页适配
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragmentArrays;
    private String[] mTabTitles;

    public ViewPagerAdapter(FragmentManager fragmentManager, Fragment[] mFragmentArrays, String[] mTabTitles) {
        super(fragmentManager);
        this.mFragmentArrays = mFragmentArrays;
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrays[position];
    }

    @Override
    public int getCount() {
        return mFragmentArrays.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}