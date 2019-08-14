package com.yunmayi.app.baselibrary.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yunmayi.app.baselibrary.R;
import com.yunmayi.app.baselibrary.dialog.LoadingDialog;
import com.yunmayi.app.baselibrary.utils.LoadType;
import com.yunmayi.app.baselibrary.utils.StatusBarUtil;
import com.yunmayi.app.baselibrary.utils.StatusBarUtilNoBar;
import com.yunmayi.app.baselibrary.utils.ToastUtils;

import java.util.List;

import butterknife.ButterKnife;


/**
 * Activity基类，所有Activity应该继承此类
 * Author: ys
 * Date: 2017-04-07  14:33
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private TextView titleTextWhite,titleTextBlack;
    public TextView titleRightTextWhite,titleRightTextBlack;
    private ImageView icBackWhite,icBackBlack;
    public ImageButton titleRightWhite,titleRightBlack;
    private RelativeLayout titleWhite;
    private LinearLayout titleBlack;
    private FrameLayout body;
    private LoadingDialog loadingDialog;
    private boolean isNotHide, headColorWhite,hideBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewLayoutID() != 0) {
            beforeInit();
            setContentView(getContentViewLayoutID());
            initView(savedInstanceState);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if (!isNotHide){
            super.setContentView(R.layout.activity_title);
            body = findViewById(R.id.body);

            titleWhite = findViewById(R.id.title_white);
            titleBlack = findViewById(R.id.title_black);
            if (headColorWhite){
                if (hideBackLayout){
                    ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)body.getLayoutParams();
                    lp.setMargins(0, 0, 0, 0);
                    body.setLayoutParams(lp);
                    titleBlack.setVisibility(View.GONE);
                }else{
                    titleBlack.setVisibility(View.VISIBLE);
                }
                titleWhite.setVisibility(View.GONE);
            }else{
                titleWhite.setVisibility(View.VISIBLE);
                titleBlack.setVisibility(View.GONE);
            }

            titleTextWhite = findViewById(R.id.title_text_white);
            titleTextBlack = findViewById(R.id.title_text_black);

            titleRightTextWhite = findViewById(R.id.title_right_text_white);
            titleRightTextBlack = findViewById(R.id.title_right_text_black);

            icBackWhite = findViewById(R.id.ic_back_white);
            icBackBlack = findViewById(R.id.ic_back_black);

            titleRightWhite = findViewById(R.id.title_right_image_white);
            titleRightBlack = findViewById(R.id.title_right_image_black);

            body.requestFocus();
            getLayoutInflater().inflate(layoutResID, body, true);
            //返回结束当前页面
            icBackWhite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setBack();
                }
            });

            icBackBlack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setBack();
                }
            });
        }else{
            super.setContentView(R.layout.activity_title_null);
            body = findViewById(R.id.body);
            body.requestFocus();
            getLayoutInflater().inflate(layoutResID, body, true);
            StatusBarUtilNoBar.fullScreen(this);
        }
        ButterKnife.bind(this);
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
    }

    /**
     * 隐藏back
     */
    public void hideBack(){
        if (headColorWhite){
            icBackBlack.setVisibility(View.GONE);
        }else{
            icBackWhite.setVisibility(View.GONE);
        }
    }

    /**
     * 设计右边字样
     */
    public void setRightTitle(String title){
        titleRightTextBlack.setText(title);
    }

    /**
     * 显示右边
     */
    public void showRight(){
        if (headColorWhite){
            titleRightTextBlack.setVisibility(View.VISIBLE);
        }else{
            titleRightTextWhite.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 添加返回键事件
     * 默认finish
     */
    public void setBack(){
        finish();
    }
    /**
     * 获取布局ID
     *
     * @return 布局id
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 界面初始化前期准备
     */
    protected void beforeInit() {
        if (!isNotHide){
            if (headColorWhite){
                StatusBarUtil.transparencyBar(this,getResources().getColor(R.color.white)); //设置状态栏全透明
                StatusBarUtil.StatusBarLightMode(this); //设置白底黑字
            }else{
                StatusBarUtil.transparencyBar(this,getResources().getColor(R.color.colorAccent)); //设置状态栏全透明
            }
        }
    }

    /**
     * 显示加载动画
     */
    @Override
    public void showProgress() {
        if (!isFinishing()){
            loadingDialog.show();
        }
    }

    /**
     * 隐藏加载动画
     */
    @Override
    public void hideProgress() {
        if (!isFinishing()){
            loadingDialog.dismiss();
        }
    }

    /**
     * 设置标题
     * @param titleText string
     */
    public void setTitleText(String titleText){
        if (headColorWhite){
            this.titleTextBlack.setText(titleText);
        }else{
            this.titleTextWhite.setText(titleText);
        }
    }
    /**
     * 设置标题
     * @param textId int资源
     */
    public void setTitleTextId(int textId){
        if (headColorWhite){
            this.titleTextBlack.setText(getResources().getText(textId));
        }else{
            this.titleTextWhite.setText(getResources().getText(textId));
        }
    }

    /**
     * 隐藏头部 返回
     */
    public void hideBackLayout(boolean hideBackLayout) {
        this.hideBackLayout = hideBackLayout;
    }

    /**
     * 设置头部颜色
     */
    public void setHeadColorWhite(boolean headColorWhite){
        this.headColorWhite = headColorWhite;
    }

    /**
     * 设置隐藏头部
     */
    public void hideTitleLayout(boolean isNotHide){
        this.isNotHide = isNotHide;
    }

    /**
     * 弹出信息
     */
    @Override
    public void showMessage(String message) {
        ToastUtils.makeText(this, message);
    }

    /**
     * 列表返回处理 有分页处理
     * @param baseQuickAdapter
     * @param swipeRefreshLayout
     * @param list
     * @param loadType
     */
    public void setLoadDataResult(BaseQuickAdapter baseQuickAdapter, SwipeRefreshLayout swipeRefreshLayout, List list, @LoadType.checker int loadType) {
        switch (loadType) {
            case LoadType.TYPE_REFRESH_SUCCESS:
                baseQuickAdapter.setNewData(list);
                swipeRefreshLayout.setRefreshing(false);
                break;
            case LoadType.TYPE_REFRESH_ERROR:
                swipeRefreshLayout.setRefreshing(false);
                break;
            case LoadType.TYPE_LOAD_MORE_SUCCESS:
                if (list != null) {
                    baseQuickAdapter.addData(list);
                }
                break;
            case LoadType.TYPE_LOAD_MORE_ERROR:
                baseQuickAdapter.loadMoreFail();
                break;
        }
        if (list == null || list.isEmpty() || list.size() < 20) {
            baseQuickAdapter.loadMoreEnd(false);
        } else {
            baseQuickAdapter.loadMoreComplete();
        }
    }

}
