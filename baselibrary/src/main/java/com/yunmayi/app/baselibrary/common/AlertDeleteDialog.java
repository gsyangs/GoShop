package com.yunmayi.app.baselibrary.common;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.yunmayi.app.baselibrary.R;
import com.yunmayi.app.baselibrary.utils.G;

/**
 * 删除提示框
 */
public class AlertDeleteDialog {
	private android.app.AlertDialog ad;
	private TextView alertMessage,alertTitle;
	private Button no_onclik,yes_onclik;
	private Window window;
	public AlertDeleteDialog(Activity context) {
		G.initDisplaySize(context);
		ad = new android.app.AlertDialog.Builder(context).create();
		ad.show();
		//关键在下面的两行,使用window.setContentView,替换整个对话框窗口的布局
		window = ad.getWindow();
		window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		WindowManager.LayoutParams params = window.getAttributes();
		params.width = (int) (G.size.W * 0.8);
		params.height  =WindowManager.LayoutParams.WRAP_CONTENT;
		window.setAttributes(params);
		window.setContentView(R.layout.alert_delete_dialog);
		yes_onclik = window.findViewById(R.id.yes_onclik);
		no_onclik = window.findViewById(R.id.no_onclik);
		alertMessage = window.findViewById(R.id.alert_message);
		alertTitle = window.findViewById(R.id.alert_title);

	}
	public void setAlertMessage(int resId) {
		alertMessage.setText(resId);
	}

	public void setAlertMessage(String message)
	{
		alertMessage.setText(message);
	}

	/**
	 * 设置按钮
	 * @param text
	 * @param listener
	 */
	public void setPositiveButton(String text, final View.OnClickListener listener) {
		yes_onclik.setText(text);
		yes_onclik.setOnClickListener(listener);
	}
 
	/**
	 * 设置按钮
	 * @param text
	 * @param listener
	 */
	public void setNegativeButton(String text, final View.OnClickListener listener) {
		no_onclik.setText(text);
		no_onclik.setOnClickListener(listener);
	}
	/**
	 * 设置版本信息
	 * @param version
	 */
	public void setAlertTitle(String version) {
		alertTitle.setText(version);
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
}
