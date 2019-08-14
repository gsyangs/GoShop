package com.yunmayi.app.wholesale.good;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yunmayi.app.baselibrary.flowlayout.FlowLayoutManager;
import com.yunmayi.app.baselibrary.flowlayout.SpaceItemDecoration;
import com.yunmayi.app.baselibrary.utils.DisplayUtil;
import com.yunmayi.app.baselibrary.utils.ToastUtils;
import com.yunmayi.app.baselibrary.view.BaseActivity;
import com.yunmayi.app.entity.GoodsSearch;
import com.yunmayi.app.wholesale.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ys on 2018/10/17.
 * 商品搜索界面
 */

public class GoodsSearchActivity extends BaseActivity {

    @BindView(R.id.back_good_detail)
    ImageView backGoodDetail;
    @BindView(R.id.hot_search_title_list)
    RecyclerView hotSearchTitleList;
    @BindView(R.id.history_search_title_list)
    RecyclerView historySearchTitleList;
    @BindView(R.id.keyword)
    EditText mKeyword;

    private List<GoodsSearch> goodsSearches,historyGoods;
    private HotGoodsAdapter hotGoodsAdapter;
    private HotGoodsAdapter historyGoodsAdapter;
    @Override
    protected int getContentViewLayoutID() {
        setHeadColorWhite(true);
        hideBackLayout(true);
        return R.layout.activity_good_search;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        goodsSearches = new ArrayList<>();
        hotGoodsAdapter = new HotGoodsAdapter(R.layout.hot_goods_item, goodsSearches);
        hotGoodsAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        hotSearchTitleList.addItemDecoration(new SpaceItemDecoration(DisplayUtil.dip2px(this,10)));
        //设置layoutManager
        hotSearchTitleList.setLayoutManager(new FlowLayoutManager());
        hotSearchTitleList.setAdapter(hotGoodsAdapter);

        getHotGoodsList();

        historyGoods = new ArrayList<>();
        historyGoodsAdapter = new HotGoodsAdapter(R.layout.history_goods_item, historyGoods);
        historyGoodsAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        //设置layoutManager
        historySearchTitleList.setLayoutManager(new LinearLayoutManager(this));
        historySearchTitleList.setAdapter(historyGoodsAdapter);
        getHistoryGoodsList();

    }

    /**
     * 获取热门搜索
     */
    private void getHotGoodsList(){
        goodsSearches.add(new GoodsSearch(1,"旺仔"));
        goodsSearches.add(new GoodsSearch(1,"康师傅"));
        goodsSearches.add(new GoodsSearch(1,"伊利"));
        goodsSearches.add(new GoodsSearch(1,"牛奶"));
        goodsSearches.add(new GoodsSearch(1,"农夫山泉"));
        goodsSearches.add(new GoodsSearch(1,"王老吉"));
        goodsSearches.add(new GoodsSearch(1,"盼盼小面包"));
        goodsSearches.add(new GoodsSearch(1,"百事可乐"));

        hotGoodsAdapter.notifyDataSetChanged();
    }

    /**
     * 获取热门搜索
     */
    private void getHistoryGoodsList(){
        historyGoods.add(new GoodsSearch(1,"加多宝"));
        historyGoods.add(new GoodsSearch(1,"旺仔牛奶硬糖"));
        historyGoods.add(new GoodsSearch(1,"低脂纯牛奶"));
        historyGoods.add(new GoodsSearch(1,"碳酸饮料"));
        historyGoods.add(new GoodsSearch(1,"洗漱用品"));
        historyGoods.add(new GoodsSearch(1,"饮料"));

        historyGoodsAdapter.notifyDataSetChanged();
        addFooterView();

    }

    /**
     * 添加底部布局
     */
    private void addFooterView() {
        View footerView = getLayoutInflater().inflate(R.layout.history_footer_item, null);
        footerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        historyGoodsAdapter.addFooterView(footerView);
        footerView.findViewById(R.id.clear_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.makeText(GoodsSearchActivity.this,"清理历史啦！");
            }
        });
    }

    @OnClick(R.id.back_good_detail)
    public void OnBackGoodDetail(){
        this.finish();
    }

    @OnClick(R.id.goods_search)
    public void onGoodsSearch(){
        String keyword = mKeyword.getText().toString();
        Intent intent = new Intent(this,GoodsListActivity.class);
        intent.putExtra("keyword",keyword);
        startActivity(intent);
        this.finish();
    }

}
