package com.yunmayi.app.wholesale.good;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yunmayi.app.entity.GoodsSearch;
import com.yunmayi.app.wholesale.R;

import java.util.List;

/**
 * Created by ys on 2018/10/17.
 */

public class HotGoodsAdapter extends BaseQuickAdapter<GoodsSearch,BaseViewHolder> {

    public HotGoodsAdapter(int layoutResId , @Nullable List<GoodsSearch> data) {
        super(layoutResId, data);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    protected void convert(BaseViewHolder holder, GoodsSearch item) {
        if (holder != null) {
            ((TextView) holder.getView(R.id.goods_title)).setText(item.getGoodName());
        }
    }
}
