package com.yunmayi.app.baselibrary.api;

import android.content.Context;
import android.support.annotation.CallSuper;


import com.yunmayi.app.baselibrary.utils.NetworkUtil;
import com.yunmayi.app.bo.Result;

import rx.Subscriber;

/**
 * Created by ys on 2017/6/5.
 * 封装Subscriber 处理 onError
 */

public class BaseSubscriber<T> extends Subscriber<T>{

    private RequestCallback<T> mRequestCallback;
    private Context context;
    private String SUCCESS_CODE = "success";
    private String ERROR_CODE = "fail";
    private String NO_LOGIN = "nologin";

    public BaseSubscriber(RequestCallback<T> requestCallback,Context context) {
        mRequestCallback = requestCallback;
        this.context = context;

    }


    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        if (mRequestCallback != null) {
            mRequestCallback.beforeRequest();
        }
        if (!NetworkUtil.isNetworkConnected()) {
            mRequestCallback.requestError("无网络，请检查网络！");
            onCompleted();
        }
    }

    @Override
    public void onCompleted() {
        if (mRequestCallback != null) {
            mRequestCallback.requestComplete();
        }
    }
    @Override
    public void onError(Throwable e) {
        /**处理错误信息*/
        if (mRequestCallback != null) {
            ExceptionEngine.ResponeThrowable responeThrowable = ExceptionEngine.handleException(e);
            String message = responeThrowable.message;
            mRequestCallback.requestError(message);
        }
    }

    @Override
    public void onNext(T t) {
        if (mRequestCallback == null)
            return;
        if(t instanceof Result) {
            Result result = (Result)t;
            //判断是否返回错误信息
            if (SUCCESS_CODE.equals(result.getStatus())){
                mRequestCallback.requestSuccess(t);
            }else if(ERROR_CODE.equals(result.getStatus())){
                mRequestCallback.requestError(result.getInfo());
            }else if (NO_LOGIN.equals(result.getStatus())){
                mRequestCallback.requestError("登录过期，或者用户未登录！");
            }
        }
    }
}
