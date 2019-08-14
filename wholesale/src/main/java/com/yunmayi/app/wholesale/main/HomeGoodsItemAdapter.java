package com.yunmayi.app.wholesale.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yunmayi.app.entity.GoodsItem;
import com.yunmayi.app.entity.HomeMenuItem;
import com.yunmayi.app.wholesale.R;

import java.util.List;

/**
 * Created by ys on 2018/4/21.
 */

public class HomeGoodsItemAdapter extends BaseQuickAdapter<GoodsItem, BaseViewHolder> {

    private Context context;
    public HomeGoodsItemAdapter(int layoutResId, @Nullable List<GoodsItem> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, final GoodsItem goodsItem) {
        if (holder != null) {
            Glide.with(context).load(goodsItem.getGoodsImage()).into((ImageView) holder.getView(R.id.goods_image));
            ((TextView) holder.getView(R.id.goods_title)).setText(goodsItem.getGoodsName());
            ((TextView) holder.getView(R.id.goods_spec)).setText(goodsItem.getGoodsSpec());
            ((TextView) holder.getView(R.id.goods_price)).setText("¥" + goodsItem.getGooodsPrice());
            holder.addOnClickListener(R.id.good_item);
            holder.addOnClickListener(R.id.goods_buy);
        }
    }
}
