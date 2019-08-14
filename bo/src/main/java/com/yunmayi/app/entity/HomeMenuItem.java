package com.yunmayi.app.entity;

import android.app.Activity;

/**
 * Created by ys on 2018/9/27.
 * 功能菜单
 */

public class HomeMenuItem {

    private String menuName;
    private int menuImageid;
    private Activity activity;

    public HomeMenuItem(String menuName,int menuImageid,Activity activity){
        this.menuName = menuName;
        this.menuImageid = menuImageid;
        this.activity = activity;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuImageid() {
        return menuImageid;
    }

    public void setMenuImageid(int menuImageid) {
        this.menuImageid = menuImageid;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
