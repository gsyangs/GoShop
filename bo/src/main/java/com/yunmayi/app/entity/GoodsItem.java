package com.yunmayi.app.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by ys on 2018/9/27.
 */

public class GoodsItem implements MultiItemEntity{

    private String goodsName;
    private String goodsImage;
    private float gooodsPrice;
    private String goodsId;
    private String goodsSpec;
    private boolean isSelect;
    private int minNumber;
    private int number;
    private int maxNumber;
    private int type;
    public GoodsItem(){

    }

    public GoodsItem(String goodsName,String goodsImage,float gooodsPrice,String goodsId,String goodsSpec,boolean isSelect,int mixNumber,int number,int maxNumber,int type){
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsImage = goodsImage;
        this.gooodsPrice = gooodsPrice;
        this.goodsSpec = goodsSpec;
        this.isSelect = isSelect;
        this.minNumber = mixNumber;
        this.number = number;
        this.maxNumber = maxNumber;
        this.type = type;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public float getGooodsPrice() {
        return gooodsPrice;
    }

    public void setGooodsPrice(float gooodsPrice) {
        this.gooodsPrice = gooodsPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
