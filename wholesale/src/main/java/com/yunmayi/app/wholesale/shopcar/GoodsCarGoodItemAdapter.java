package com.yunmayi.app.wholesale.shopcar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yunmayi.app.baselibrary.listener.CarOnItemClickListener;
import com.yunmayi.app.baselibrary.listener.ChangeOrderNumberListener;
import com.yunmayi.app.entity.GoodsItem;
import com.yunmayi.app.entity.Type;
import com.yunmayi.app.wholesale.R;

import java.util.List;
import java.util.logging.Handler;

/**
 * Created by ys on 2018/10/22.
 * 购物车 详细商品
 */

public class GoodsCarGoodItemAdapter extends BaseMultiItemQuickAdapter<GoodsItem,BaseViewHolder> {

    private Context context;
    private int index;
    private CarOnItemClickListener onItemClickListener;
    private ChangeOrderNumberListener changeOrderNumberListener;
    private View view;
    private int state;

    public GoodsCarGoodItemAdapter(@Nullable List<GoodsItem> data ,Context context,int index, View view,int state) {
        super(data);
        addItemType(Type.RIGHT_MENU, R.layout.item_right_menu);
        this.context = context;
        this.index = index;
        this.view = view;
        this.state = state;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GoodsItem item) {
        if (helper != null){
            if (state != 0){
                helper.getView(R.id.select_good).setVisibility(View.GONE);
                helper.getView(R.id.item_count).setVisibility(View.VISIBLE);
                helper.getView(R.id.take_layout).setVisibility(View.GONE);
            }else{
                helper.getView(R.id.item_count).setVisibility(View.GONE);
                helper.getView(R.id.take_layout).setVisibility(View.VISIBLE);
                if (item.isSelect()){
                    Glide.with(context).load(R.mipmap.cart_checkbox_selected).into((ImageView) helper.getView(R.id.select_good));
                }else{
                    Glide.with(context).load(R.mipmap.cart_checkbox_normal).into((ImageView) helper.getView(R.id.select_good));
                }
            }
            Glide.with(context).load(item.getGoodsImage()).into((ImageView) helper.getView(R.id.good_image));
            ((TextView) helper.getView(R.id.good_name)).setText(item.getGoodsName());
            ((TextView) helper.getView(R.id.spec)).setText("规格：" + item.getGoodsSpec());
            ((TextView) helper.getView(R.id.buy_size)).setText("限购10箱");
            ((TextView) helper.getView(R.id.good_price)).setText(String.valueOf(item.getGooodsPrice()));
            ((TextView) helper.getView(R.id.buy_size)).setText("限购" + item.getMaxNumber() + "箱");

            final EditText goodNumber = helper.getView(R.id.good_number);
            goodNumber.setText(String.valueOf(item.getNumber()));
            goodNumber.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable == null || editable.toString().length() == 0){
                        goodNumber.setText(String.valueOf(item.getMinNumber()));
                    }
                    int newNumber = Integer.parseInt(goodNumber.getText().toString());
                    if (newNumber < item.getMinNumber()){
                        goodNumber.setText(String.valueOf(item.getMinNumber()));
                    }else if (newNumber > item.getMaxNumber()){
                        goodNumber.setText(String.valueOf(item.getMaxNumber()));
                    }
                    goodNumber.setSelection(goodNumber.getText().length());

                    if (changeOrderNumberListener != null){
                        int count = Integer.parseInt(goodNumber.getText().toString());
                        changeOrderNumberListener.change(count,index,helper.getLayoutPosition());
                    }
                }
            });


            helper.getView(R.id.decrease_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt(((EditText) helper.getView(R.id.good_number)).getText().toString());
                    if (count > item.getMinNumber()){
                        count--;
                        ((EditText)helper.getView(R.id.good_number)).setText(String.valueOf(count));
                    }

                    if (changeOrderNumberListener != null){
                        changeOrderNumberListener.change(count,index,helper.getLayoutPosition());
                    }
                }
            });
            helper.getView(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt(((EditText) helper.getView(R.id.good_number)).getText().toString());
                    if (count < item.getMaxNumber()){
                        count++;
                        ((EditText)helper.getView(R.id.good_number)).setText(String.valueOf(count));
                    }
                    if (changeOrderNumberListener != null){
                        changeOrderNumberListener.change(count,index,helper.getLayoutPosition());
                    }
                }
            });
        }

        helper.getView(R.id.select_good_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(v, helper.getLayoutPosition(),index,item,view);
                }
            }
        });
    }

    public void setOnItemClickListener(CarOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setChangeOrderNumberListener(ChangeOrderNumberListener changeOrderNumberListener){
        this.changeOrderNumberListener = changeOrderNumberListener;
    }

    public void setSelect(GoodsItem goodsItem,View v){
        ImageView imageView = v.findViewById(R.id.select_good);
        if (goodsItem.isSelect()){
            Glide.with(context).load(R.mipmap.cart_checkbox_selected).into(imageView);
        }else{
            Glide.with(context).load(R.mipmap.cart_checkbox_normal).into(imageView);
        }
    }
}
