package com.yunmayi.app.wholesale.main;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yunmayi.app.entity.HomeMenuItem;
import com.yunmayi.app.wholesale.R;
import java.util.List;

/**
 * Created by ys on 2018/4/21.
 */

public class HomeMenuItemAdapter extends BaseQuickAdapter<HomeMenuItem, BaseViewHolder> {

    public HomeMenuItemAdapter(int layoutResId, @Nullable List<HomeMenuItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final HomeMenuItem homeMenuItem) {
        if (helper != null) {
            ((ImageView) helper.getView(R.id.menu_image)).setImageResource(homeMenuItem.getMenuImageid());
            ((TextView) helper.getView(R.id.menu_name)).setText(homeMenuItem.getMenuName());
            helper.addOnClickListener(R.id.menu_layout);
        }
    }
}
