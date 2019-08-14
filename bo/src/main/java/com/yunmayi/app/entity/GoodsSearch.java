package com.yunmayi.app.entity;

/**
 * Created by ys on 2018/10/17.
 */

public class GoodsSearch {

    private int goodId;
    private String goodName;

    public GoodsSearch(int goodId,String goodName){
        this.goodId = goodId;
        this.goodName = goodName;
    }
    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}
