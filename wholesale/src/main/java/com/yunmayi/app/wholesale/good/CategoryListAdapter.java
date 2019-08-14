package com.yunmayi.app.wholesale.good;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yunmayi.app.entity.Category;
import com.yunmayi.app.wholesale.R;

import java.util.List;

/**
 * Created by ys on 2018/10/17.
 */

public class CategoryListAdapter extends BaseQuickAdapter<Category,BaseViewHolder> {

    private int type;
    private Context context;

    public CategoryListAdapter(int layoutResId , @Nullable List<Category> data,int type,Context context){
        super(layoutResId, data);
        this.type = type;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    protected void convert(BaseViewHolder holder, Category category) {
        if (holder != null) {
            switch (type){
                case 1:
                    ((TextView) holder.getView(R.id.category_title)).setText(category.getCategory());
                    if (category.isSelect()){
                        holder.getView(R.id.category_title).setBackgroundResource(R.drawable.category_select_bg);
                        ((TextView) holder.getView(R.id.category_title)).setTextColor(context.getResources().getColor(R.color.white));
                    }else{
                        holder.getView(R.id.category_title).setBackgroundResource(R.drawable.category_bg);
                        ((TextView) holder.getView(R.id.category_title)).setTextColor(context.getResources().getColor(R.color.text_color_3));
                    }
                    holder.addOnClickListener(R.id.category_title);
                    break;
                case 2:
                    ((TextView) holder.getView(R.id.brand_title)).setText(category.getCategory());
                    if (category.isSelect()){
                        holder.getView(R.id.brand_title).setBackgroundResource(R.drawable.category_select_bg);
                        ((TextView) holder.getView(R.id.brand_title)).setTextColor(context.getResources().getColor(R.color.white));
                    }else{
                        holder.getView(R.id.brand_title).setBackgroundResource(R.drawable.category_bg);
                        ((TextView) holder.getView(R.id.brand_title)).setTextColor(context.getResources().getColor(R.color.text_color_3));
                    }
                    holder.addOnClickListener(R.id.brand_title);
                    break;
            }

        }
    }
}
