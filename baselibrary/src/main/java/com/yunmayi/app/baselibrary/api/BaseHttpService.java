package com.yunmayi.app.baselibrary.api;

import com.yunmayi.app.bo.Result;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by ys on 17/5/27.
 * api
 */
public interface BaseHttpService {

    /**获取验证码*/
    @GET("graborder/passport/getSmsVerifyCode")
    Observable<Result> getSmsVerifyCode(@QueryMap Map<String, Object> params);

}
