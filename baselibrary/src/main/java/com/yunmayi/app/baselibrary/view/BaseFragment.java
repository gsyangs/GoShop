package com.yunmayi.app.baselibrary.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yunmayi.app.baselibrary.dialog.LoadingDialog;
import com.yunmayi.app.baselibrary.utils.LoadType;
import com.yunmayi.app.baselibrary.utils.ToastUtils;

import java.util.List;

import butterknife.ButterKnife;

/**
 * baseFragment
 * @author ys
 */
public abstract class BaseFragment extends Fragment implements BaseView{

	public Activity mBaseActivity;
	private LoadingDialog loadingDialog;
	protected boolean isInit = false;
	protected boolean isLoad = false;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		View mRootView = inflater.inflate(getLayoutId(), container, false);
		ButterKnife.bind(this,mRootView);

		if (loadingDialog == null && mBaseActivity != null) {
			loadingDialog = new LoadingDialog(mBaseActivity);
		}
		initView();

		isInit = true;
		/**初始化的时候去加载数据**/
		isCanLoadData();

		return mRootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	/**
	 * 是否可以加载数据
	 * 可以加载数据的条件：
	 * 1.视图已经初始化
	 * 2.视图对用户可见
	 */
	private void isCanLoadData() {
		if (!isInit) {
			return;
		}
		if (getUserVisibleHint()) {
			initData();
			isLoad = true;
		} else {
			if (isLoad) {
				stopLoad();
			}
		}
	}
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		isCanLoadData();
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mBaseActivity = activity;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		isInit = false;
		isLoad = false;
	}

	public abstract int getLayoutId();

	public abstract void initView();

	@Override
	public void showProgress() {
		loadingDialog.show();
	}

	@Override
	public void hideProgress() {
		loadingDialog.dismiss();
	}

	@Override
	public void showMessage(String message) {
		ToastUtils.makeText(mBaseActivity, message);
	}

	/**
	 * 可见-初始化数据
	 */
	public abstract void initData();

	/**
	 * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
	 */
	public void stopLoad() {
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
		if (list == null || list.isEmpty() || list.size() < 10) {
			baseQuickAdapter.loadMoreEnd(false);
		} else {
			baseQuickAdapter.loadMoreComplete();
		}
	}

}