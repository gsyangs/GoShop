package com.yunmayi.app.entity;

import java.util.List;

/**
 * Created by ys on 2018/10/22.
 * 购物车商品
 */

public class GoodsCarItem {
    private String supplierName;
    private int id;
    private List<GoodsItem> goodsItems;
    private GiftItem giftItem;
    private boolean isSelect;
    private String discountInfo;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<GoodsItem> getGoodsItems() {
        return goodsItems;
    }

    public void setGoodsItems(List<GoodsItem> goodsItems) {
        this.goodsItems = goodsItems;
    }

    public GiftItem getGiftItem() {
        return giftItem;
    }

    public void setGiftItem(GiftItem giftItem) {
        this.giftItem = giftItem;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getDiscountInfo() {
        return discountInfo;
    }

    public void setDiscountInfo(String discountInfo) {
        this.discountInfo = discountInfo;
    }
}
