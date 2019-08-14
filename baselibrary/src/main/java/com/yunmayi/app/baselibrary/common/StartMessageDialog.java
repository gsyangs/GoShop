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
 * 消息提醒
 */
public class StartMessageDialog {
	private android.app.AlertDialog ad;
	private Button ok;
	private Window window;
	public StartMessageDialog(Activity context) {
		G.initDisplaySize(context);
		ad = new android.app.AlertDialog.Builder(context).create();
		ad.show();
		//关键在下面的两行,使用window.setContentView,替换整个对话框窗口的布局
		window = ad.getWindow();
		window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		WindowManager.LayoutParams params = window.getAttributes();
		params.width = (int) (G.size.W * 0.8);
		params.height=WindowManager.LayoutParams.WRAP_CONTENT;
		window.setAttributes(params);
		window.setContentView(R.layout.alert_tips_dialog);
		ok = window.findViewById(R.id.ok);

	}

	/**
	 * 设置按钮
	 * @param listener
	 */
	public void setPositiveButton(View.OnClickListener listener) {
		ok.setOnClickListener(listener);
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
