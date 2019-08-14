package com.yunmayi.app.entity;

/**
 * Created by ys on 2018/10/22.
 * 赠送信息
 */

public class GiftItem {
    private int id;
    private String goodName;
    private String otherInfo;

    public GiftItem(){
    }

    public GiftItem(int id,String goodName,String otherInfo){
        this.id = id;
        this.goodName = goodName;
        this.otherInfo = otherInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
