package com.yunmayi.app.wholesale.common;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yunmayi.app.wholesale.R;


/**
 * Created by ys on 2018/9/6.
 * 选择商品
 */

public class SelectGoodsWindow extends PopupWindow {

    ImageView goodImage;
    TextView goodName;
    TextView goodPrice;
    TextView spec;
    TextView buySize;
    ImageView decreaseBtn;
    ImageView addBtn;

    private View mView;

    private OnDismissChangeBgListener onDismissChangeBgListener;

    public SelectGoodsWindow(Context mContext) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.select_goods_window, null);

        goodImage = mView.findViewById(R.id.good_image);
        goodName = mView.findViewById(R.id.good_name);
        goodPrice = mView.findViewById(R.id.good_price);
        spec = mView.findViewById(R.id.spec);
        buySize = mView.findViewById(R.id.buy_size);
        decreaseBtn = mView.findViewById(R.id.decrease_btn);
        addBtn = mView.findViewById(R.id.add_btn);


        // 设置外部可点击
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.mView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                int height = mView.findViewById(R.id.ll_popup).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        onDismissChangeBgListener.onDismissChangeBg(1f);
                        dismiss();
                    }
                }
                return true;
            }
        });

        /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.mView);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

        // 设置弹出窗体可点击
        this.setFocusable(true);

        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.take_photo_anim);

        this.mView.setFocusable(true);
        this.mView.setFocusableInTouchMode(true); // 设置view能够接听事件
        this.mView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int arg1, KeyEvent keyEvent) {
                if (arg1 == KeyEvent.KEYCODE_BACK) {
                    //如果PopupWindow处于显示状态，则关闭PopupWindow
                    if (isShowing()) {
                        onDismissChangeBgListener.onDismissChangeBg(1f);
                        dismiss();
                    }
                }
                return false;
            }
        });
    }

    /**
     * @param onDismissChangeBgListener
     */
    public void setOnDismissChangeBgListener(OnDismissChangeBgListener onDismissChangeBgListener) {
        this.onDismissChangeBgListener = onDismissChangeBgListener;
    }

    public interface OnDismissChangeBgListener {
        void onDismissChangeBg(float bgAlpha);
    }

}
