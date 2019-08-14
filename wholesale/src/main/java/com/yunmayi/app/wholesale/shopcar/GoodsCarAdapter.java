package com.yunmayi.app.wholesale.shopcar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yunmayi.app.baselibrary.listener.BackOrderCountInfoListener;
import com.yunmayi.app.baselibrary.listener.CarOnItemClickListener;
import com.yunmayi.app.baselibrary.listener.ChangeOrderNumberListener;
import com.yunmayi.app.entity.GoodsCarItem;
import com.yunmayi.app.entity.GoodsItem;
import com.yunmayi.app.wholesale.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ys on 2018/10/22.
 * 购物车商品组
 */

public class GoodsCarAdapter extends BaseQuickAdapter<GoodsCarItem,BaseViewHolder> implements CarOnItemClickListener ,ChangeOrderNumberListener{

    private Context context;
    private List<GoodsItem> goodsItems;
    private GoodsCarGoodItemAdapter goodsCarGoodItemAdapter;
    private BackOrderCountInfoListener backOrderCountInfoListener;
    private int state;
    public GoodsCarAdapter(int layoutResId, @Nullable List<GoodsCarItem> data,Context context,int state) {
        super(layoutResId, data);
        this.context = context;
        this.state = state;
    }

    @Override
    protected void convert(BaseViewHolder holder, GoodsCarItem item) {
        if (holder != null) {
            if (state != 0){
                holder.getView(R.id.cart_checkbox).setVisibility(View.GONE);
            }else{
                if (item.isSelect()){
                    Glide.with(context).load(R.mipmap.cart_checkbox_selected).into((ImageView) holder.getView(R.id.cart_checkbox));
                }else{
                    Glide.with(context).load(R.mipmap.cart_checkbox_normal).into((ImageView) holder.getView(R.id.cart_checkbox));
                }
            }

            TextView cartCheckboxTitle = holder.getView(R.id.cart_checkbox_title);
            cartCheckboxTitle.setText(item.getSupplierName());
            TextView discountInfo = holder.getView(R.id.discount_info);
            discountInfo.setText(item.getDiscountInfo());

            RecyclerView goodsList = holder.getView(R.id.goods_list);
            goodsItems = new ArrayList<>();
            goodsItems.addAll(item.getGoodsItems());
            goodsCarGoodItemAdapter = new GoodsCarGoodItemAdapter(goodsItems,context,holder.getLayoutPosition(),holder.itemView,state);
            goodsCarGoodItemAdapter.setOnItemClickListener(this);
            goodsCarGoodItemAdapter.setChangeOrderNumberListener(this);

            LinearLayoutManager goodsLayout = new LinearLayoutManager(context);
            goodsLayout.setSmoothScrollbarEnabled(true);
            goodsLayout.setAutoMeasureEnabled(true);
            goodsList.setLayoutManager(goodsLayout);

            goodsList.setAdapter(goodsCarGoodItemAdapter);
            goodsList.setHasFixedSize(true);
            goodsList.setNestedScrollingEnabled(false);

            holder.addOnClickListener(R.id.cart_checkbox_layout);
        }

    }
    /**
     * 选择子项，关联选择中当前父项
     * @param carItem
     * @param v
     */
    public void setSelect(GoodsCarItem carItem,View v){
        ImageView imageView = v.findViewById(R.id.cart_checkbox);
        if (carItem.isSelect()){
            Glide.with(context).load(R.mipmap.cart_checkbox_selected).into(imageView);
        }else{
            Glide.with(context).load(R.mipmap.cart_checkbox_normal).into(imageView);
        }
    }

    /**
     * 点击子项
     * @param view  点击的view
     * @param position 点击的下标
     * @param index 父项下标
     * @param o1 商品信息
     * @param v 父项 关联view
     */
    @Override
    public void onClick(View view, int position,int index, Object o1,View v) {
        GoodsItem goodsItem = (GoodsItem) o1;
        if (goodsItem.isSelect()){
            goodsItem.setSelect(false);
        }else{
            goodsItem.setSelect(true);
        }

        GoodsCarItem goodsCarItem = getData().get(index);
        List<GoodsItem> goodsItems = goodsCarItem.getGoodsItems();//当前子项商品信息
        goodsItems.set(position,goodsItem);//设置最新的商品数据选择状态

        goodsCarItem.setGoodsItems(goodsItems);//设置当前大类选中的商品

        boolean allFalse = false;
        for (int i = 0; i < goodsItems.size(); i++){
            if (goodsItems.get(i).isSelect()){
                allFalse = true;
            }
        }
        if (allFalse){
            goodsCarItem.setSelect(true);
        }else{
            goodsCarItem.setSelect(false);
        }
        goodsCarGoodItemAdapter.setSelect(goodsItem,view);//设置 子项选择状态
        this.setSelect(goodsCarItem,v);//设置 当前选择大类的选择状态

        if (backOrderCountInfoListener != null){
            backOrderCountInfoListener.backInfo(goodsCarItem,index);
        }
    }
    public void setBackOrderCountInfoListener(BackOrderCountInfoListener backOrderCountInfoListener) {
        this.backOrderCountInfoListener = backOrderCountInfoListener;
    }

    @Override
    public void change(int count, int index,int position) {
        GoodsCarItem goodsCarItem = getData().get(index);
        List<GoodsItem> goodsItems = goodsCarItem.getGoodsItems();//当前子项商品信息
        GoodsItem goodsItem = goodsItems.get(position);
        goodsItem.setNumber(count);
        goodsItems.set(position,goodsItem);
        goodsCarItem.setGoodsItems(goodsItems);//设置当前大类选中的商品
        if (backOrderCountInfoListener != null){
            backOrderCountInfoListener.backInfo(goodsCarItem,index);
        }
    }
}
