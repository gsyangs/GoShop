package com.yunmayi.app.baselibrary.application;

import android.app.Application;

/**
 * Created by ys on 2018/4/14.
 */
public class BaseAppLication extends Application {

    private static BaseAppLication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static BaseAppLication getInstance() {
        return INSTANCE;
    }

}
