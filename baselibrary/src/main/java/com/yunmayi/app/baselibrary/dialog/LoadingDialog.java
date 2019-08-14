package com.yunmayi.app.baselibrary.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunmayi.app.baselibrary.R;


/**
 * @author ys
 */
public class LoadingDialog extends Dialog {
	private Context mContext;
	private boolean mCancelable;
    private String title;
    private boolean showLoadingPercent;
    private TextView percentTxt;
	private ImageView loadingView;

	public LoadingDialog(Context context) {
		super(context, R.style.dialog);
		mContext = context;
	}
	public LoadingDialog(Context context, String title) {
        super(context, R.style.dialog);
        mContext = context;
        this.title = title;
    }
	public LoadingDialog(Context context, boolean cancelable) {
		super(context, R.style.dialog);
		mContext = context;
		mCancelable = cancelable;
	}
	
	public LoadingDialog(Context context, String title, boolean showLoadingPercent, boolean cancelable) {
        super(context, R.style.dialog);
        mContext = context;
		mCancelable = cancelable;
		this.title = title;
		this.showLoadingPercent = showLoadingPercent;
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading_dialog_layout);
		this.setCanceledOnTouchOutside(false);
		this.setCancelable(mCancelable);
		loadingView = (ImageView)findViewById(R.id.loading_image);
		if(this.title != null && !"".equals(title)) {
		    ((TextView)findViewById(R.id.loading_title)).setText(title);
		}
		if(showLoadingPercent) {
		    percentTxt = ((TextView)findViewById(R.id.loading_percent));
		    percentTxt.setVisibility(View.VISIBLE);
		}
	}
	public void setPercent(String percent) {
	    if(percentTxt == null) {
        return;
	    }
		percentTxt.setText(percent + "%");
	}
	public void setTitle(String title){
		if(title == null) {
			return;
		}
		((TextView)findViewById(R.id.loading_title)).setText(title);
	}

	@Override
	public void show() {
		super.show();
		loadingView.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.progress_anim));
	}
}
