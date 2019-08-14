package com.yunmayi.app.baselibrary.listener;

import com.yunmayi.app.entity.GoodsCarItem;

/**
 * Created by yangs on 2016/11/29.
 */

public interface BackOrderCountInfoListener {
    void backInfo(GoodsCarItem goodsCarItem,int index);
}
