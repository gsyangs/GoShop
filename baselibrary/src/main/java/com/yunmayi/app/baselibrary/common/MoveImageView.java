package com.yunmayi.app.baselibrary.common;

import android.content.Context;
import android.graphics.PointF;
import android.widget.ImageView;

/**
 * Created by ys on 2018/9/28.
 * 购物车运动轨迹图
 */

public class MoveImageView extends ImageView {
    public MoveImageView(Context context) {
        super(context);
    }

    public void setMPointF(PointF pointF) {
        setX(pointF.x);
        setY(pointF.y);
    }
}
