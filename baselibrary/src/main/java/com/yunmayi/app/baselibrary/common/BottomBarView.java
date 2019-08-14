package com.yunmayi.app.baselibrary.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yunmayi.app.baselibrary.R;

/**
 * Created by ys on 2018/10/18.
 * 角标工具类
 */

public class BottomBarView extends RelativeLayout {
    private Context context;
    private TextView bar_num;
    private int count = 0;
    public BottomBarView(Context context) {
        this(context, null);
    }
    public BottomBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public BottomBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        RelativeLayout rl = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.bottom_bar_view, this, true);
        bar_num =  rl.findViewById(R.id.bar_num);
        bar_num.setVisibility(INVISIBLE);
    }
    public void add() {
        bar_num.setVisibility(VISIBLE);
        count++;
        if (count < 100) {
            bar_num.setText(count + "");
        } else {
            bar_num.setText("99+");
        }
    }
    public void add(int n) throws Exception {
        if(n<0){
            throw new Exception(BottomBarView.class.getSimpleName()+" add(int n).The param must be a positive num");
        }
        bar_num.setVisibility(VISIBLE);
        count += n;
        if (count < 100) {
            bar_num.setText(count + "");
        } else {
            bar_num.setText("99+");
        }
    }
    public void delete() {
        if (count == 0) {
            bar_num.setVisibility(INVISIBLE);
        } else {
            count--;
            if (count == 0) {
                bar_num.setVisibility(INVISIBLE);
            } else if (count > 0 && count < 100) {
                bar_num.setVisibility(VISIBLE);
                bar_num.setText(count + "");
            } else {
                bar_num.setVisibility(VISIBLE);
                bar_num.setText("99+");
            }
        }
    }
    public void deleteAll() {
        count = 0;
        bar_num.setVisibility(INVISIBLE);
    }

    /**
     * 设置背景颜色 和 字体颜色
     * @param  bg = 1 白色底 红色字  bg = 2 红色底 白色字
     */
    public void setTextColorAndBg(int bg){
        switch (bg){
            case 1:
                bar_num.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_car_radius));
                bar_num.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                bar_num.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_car_radius));
                bar_num.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }
}
