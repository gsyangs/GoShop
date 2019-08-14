package com.yunmayi.app.baselibrary.common;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yunmayi.app.baselibrary.R;
import com.yunmayi.app.baselibrary.utils.G;
import com.yunmayi.app.entity.Coupon;

import java.util.ArrayList;
import java.util.List;

/**
 * 优惠券列表
 */
public class CouponListDialog {
	private android.app.AlertDialog ad;
	private Window window;
	private ImageView iconClose;
	private RecyclerView couponList;
	private CouponListAdapter couponListAdapter;
	private List<Coupon> coupons;

	public CouponListDialog(Activity context) {
		G.initDisplaySize(context);
		ad = new android.app.AlertDialog.Builder(context).create();
		ad.show();
		//关键在下面的两行,使用window.setContentView,替换整个对话框窗口的布局
		window = ad.getWindow();
		window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		WindowManager.LayoutParams params = window.getAttributes();
		params.width = G.size.W;
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		window.setAttributes(params);
		window.setGravity(Gravity.BOTTOM);
		window.setContentView(R.layout.alert_coupon_dialog);
		iconClose = window.findViewById(R.id.icon_close);
		couponList = window.findViewById(R.id.coupon_list);
		coupons = new ArrayList<>();
		for (int i = 0 ; i < 3; i++){
			Coupon coupon = new Coupon();
			coupons.add(coupon);
		}

		couponListAdapter = new CouponListAdapter(R.layout.coupon_list_item,coupons);
		couponListAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
		LinearLayoutManager orderLayout =  new LinearLayoutManager(context);
		orderLayout.setSmoothScrollbarEnabled(true);
		orderLayout.setAutoMeasureEnabled(true);

		couponList.setLayoutManager(orderLayout);
		couponList.setAdapter(couponListAdapter);
		couponList.setHasFixedSize(true);
		couponList.setNestedScrollingEnabled(false);
	}

	/**
	 * 关闭按钮
	 * @param listener
	 */
	public void setColose(View.OnClickListener listener) {
		iconClose.setOnClickListener(listener);
	}

	/**
	 * 关闭对话框
	 */
	public void dismiss() {
		ad.dismiss();
	}

	/**
	 * 显示对话框
	 */
	public void show() {
		ad.show();
	}

	/**
	 * 边框外点击不消失
	 */
	public void setCanceledOnTouchOutside(boolean isFalse){
		ad.setCanceledOnTouchOutside(isFalse);
	}

	class CouponListAdapter extends BaseQuickAdapter<Coupon,BaseViewHolder>{

		public CouponListAdapter(int layoutResId, @Nullable List<Coupon> data) {
			super(layoutResId, data);
		}

		@Override
		public int getItemViewType(int position) {
			return super.getItemViewType(position);
		}

		@Override
		protected void convert(BaseViewHolder holder, Coupon item) {
			if (holder != null) {
//				((TextView) holder.getView(R.id.goods_title)).setText(item.getGoodName());
			}
		}
	}
}
