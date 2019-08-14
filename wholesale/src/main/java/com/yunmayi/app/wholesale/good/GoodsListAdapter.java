package com.yunmayi.app.wholesale.good;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yunmayi.app.entity.GoodsItem;
import com.yunmayi.app.wholesale.R;

import java.util.List;

/**
 * Created by ys on 2018/10/22.
 * 商品列表
 */

public class GoodsListAdapter extends BaseQuickAdapter<GoodsItem,BaseViewHolder>{

    private Context context;

    public GoodsListAdapter(int layoutResId, @Nullable List<GoodsItem> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, GoodsItem item) {
        if (holder != null) {
            Glide.with(context).load(item.getGoodsImage()).into((ImageView) holder.getView(R.id.good_image));
            ((TextView) holder.getView(R.id.good_name)).setText(item.getGoodsName());
            ((TextView) holder.getView(R.id.spec)).setText(item.getGoodsSpec());
            ((TextView) holder.getView(R.id.good_price)).setText("¥" + item.getGooodsPrice());

            holder.addOnClickListener(R.id.goods_buy);
        }
    }

}
