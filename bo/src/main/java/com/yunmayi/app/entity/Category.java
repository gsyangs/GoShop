package com.yunmayi.app.entity;

/**
 * Created by ys on 2018/10/31.
 */

public class Category {

    private String category;
    private boolean isSelect;

    public Category(){

    }

    public Category(String category,boolean isSelect){
        this.category = category;
        this.isSelect = isSelect;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
