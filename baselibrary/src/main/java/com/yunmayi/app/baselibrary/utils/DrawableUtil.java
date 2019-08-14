package com.yunmayi.app.baselibrary.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by ys on 2018/4/12.
 */

public class DrawableUtil {

    /**
     * 头部 圆角 粉色背景
     * @param context
     * @return
     */
    public static GradientDrawable GetSettingShape(Context context){
        int fillColor = Color.parseColor("#FF4081");
        int roundRadius = DisplayUtil.dip2px(context,10f);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadii(new float[]{roundRadius,roundRadius,roundRadius,roundRadius,0,0,0,0});
        gd.setColor(fillColor);
        return gd;
    }

    /**
     * 反馈背景
     */
    public static GradientDrawable GetVipBackShape(Context context){
        int fillColor = Color.parseColor("#ffffff");
        int roundRadius = DisplayUtil.dip2px(context,10f);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(roundRadius);
        gd.setColor(fillColor);
        return gd;
    }

    /**
     * 反馈背景
     */
    public static GradientDrawable GetFeedBackShape(Context context){
        int fillColor = Color.parseColor("#fcfbfe");
        int roundRadius = DisplayUtil.dip2px(context,3f);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(roundRadius);
        gd.setColor(fillColor);
        return gd;
    }

    /**
     * 提交按钮背景
     */
    public static GradientDrawable GetBtnShape(Context context){
        int roundRadius = DisplayUtil.dip2px(context,80f);
        int colors[] = { 0xffef73a8 , 0xffef73a8, 0xffec7794 };//分别为开始颜色，中间夜色，结束颜色
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gd.setCornerRadius(roundRadius);
        return gd;
    }

    /**
     * 其他按钮背景
     */
    public static GradientDrawable GetBtn1Shape(Context context){
        int roundRadius = DisplayUtil.dip2px(context,5f);
        int colors[] = { 0xffef73a8 , 0xffef73a8, 0xffec7794 };//分别为开始颜色，中间夜色，结束颜色
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gd.setCornerRadius(roundRadius);
        return gd;
    }


    /**
     * item 选择后加边框
     */
    public static GradientDrawable GetRecyclerShape(Context context){
        int strokeColor = Color.parseColor("#fb6648");
        int roundRadius = DisplayUtil.dip2px(context,0f);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(roundRadius);
        gd.setStroke(2,strokeColor);
        return gd;
    }

    /**
     * item 透明
     */
    public static GradientDrawable GetRecyclerTransShape(Context context){
        int strokeColor = Color.parseColor("#00000000");
        int roundRadius = DisplayUtil.dip2px(context,0f);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(roundRadius);
        gd.setStroke(1,strokeColor);
        return gd;
    }

    /**
     * 圆
     */
    public static GradientDrawable GetCircularShape(Context context,String color){
        int strokeColor = Color.parseColor(color);
        int roundRadius = DisplayUtil.dip2px(context,0f);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(roundRadius);
        gd.setShape(GradientDrawable.OVAL);
        gd.setUseLevel(false);
        gd.setColor(strokeColor);
        return gd;
    }

    /**
     * 联系客服
     * @param context
     * @return
     */
    public static GradientDrawable GetSettingBtnShape(Context context){
        int fillColor = Color.parseColor("#FF4081");
        int roundRadius = DisplayUtil.dip2px(context,10f);
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(roundRadius);
        gd.setStroke(2,fillColor);
        return gd;
    }
}
