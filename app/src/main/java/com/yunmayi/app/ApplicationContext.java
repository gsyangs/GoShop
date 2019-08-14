package com.yunmayi.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by ys on 2018/6/8.
 */

public class ApplicationContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
