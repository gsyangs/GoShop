package com.yunmayi.app.wholesale.main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yunmayi.app.baselibrary.common.Banner;
import com.yunmayi.app.baselibrary.common.BottomBarView;
import com.yunmayi.app.baselibrary.common.UPMarqueeView;
import com.yunmayi.app.baselibrary.utils.AddGoodAnimationUtil;
import com.yunmayi.app.baselibrary.utils.StatusBarUtilNoBar;
import com.yunmayi.app.baselibrary.view.BaseActivity;
import com.yunmayi.app.entity.GoodsItem;
import com.yunmayi.app.entity.HomeMenuItem;
import com.yunmayi.app.entity.Type;
import com.yunmayi.app.wholesale.R;
import com.yunmayi.app.wholesale.good.GoodsDetailActivity;
import com.yunmayi.app.wholesale.good.GoodsSearchActivity;
import com.yunmayi.app.wholesale.my.MyOrderActivity;
import com.yunmayi.app.wholesale.other.AllGoodsActivity;
import com.yunmayi.app.wholesale.shopcar.GoodsCarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


@Route(path = "/wholesale/main")
public class MainActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener{


    @BindView(R.id.menu_list)
    RecyclerView menuList;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.marquee)
    UPMarqueeView marquee;
    @BindView(R.id.presale_list)
    RecyclerView presaleList;
    @BindView(R.id.special_list)
    RecyclerView specialList;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.nested_scrollview)
    NestedScrollView nestedScrollview;
    @BindView(R.id.iv_order)
    LinearLayout ivOrder;
    @BindView(R.id.iv_scan)
    LinearLayout ivScan;
    @BindView(R.id.main_container)
    RelativeLayout container;
    @BindView(R.id.fragment_bottom_bar)
    BottomBarView bottomBarView;
    private List<Integer> imgList;
    private List<HomeMenuItem> homeMenuItems;
    private HomeMenuItemAdapter homeMenuItmeAdapter;
    private List<String> marqueeList;

    private List<GoodsItem> goodsItems, goodsItems1;
    private HomeGoodsItemAdapter homeGoodsItmeAdapter, homeGoodsItmeAdapter1;
    private int height = 200;

    @Override
    protected int getContentViewLayoutID() {
        hideTitleLayout(true);
        return R.layout.activity_main_wholesale;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        floatStatusBar();

        addBannerData();
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(Banner.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setImages(imgList, null);
        //设置点击事件，下标是从1开始
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                startActivity(new Intent(MainActivity.this, GoodsDetailActivity.class));
            }
        });

        initMenuItem();
        homeMenuItmeAdapter = new HomeMenuItemAdapter(R.layout.item_column, homeMenuItems);
        homeMenuItmeAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        homeMenuItmeAdapter.setOnItemChildClickListener(this);

        GridLayoutManager menuLayout =  new GridLayoutManager(this, 4);
        menuLayout.setSmoothScrollbarEnabled(true);
        menuLayout.setAutoMeasureEnabled(true);
        menuList.setLayoutManager(menuLayout);
        menuList.setAdapter(homeMenuItmeAdapter);
        menuList.setHasFixedSize(true);
        menuList.setNestedScrollingEnabled(false);

        addMarqueeData();

        setMarquee();

        addPresalelea();
        homeGoodsItmeAdapter = new HomeGoodsItemAdapter(R.layout.goods_item, goodsItems, this);
        homeGoodsItmeAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        homeGoodsItmeAdapter.setOnItemChildClickListener(this);

        GridLayoutManager presaleLayout =  new GridLayoutManager(this, 2);
        presaleLayout.setSmoothScrollbarEnabled(true);
        presaleLayout.setAutoMeasureEnabled(true);

        presaleList.setLayoutManager(presaleLayout);
        presaleList.setAdapter(homeGoodsItmeAdapter);
        presaleList.setHasFixedSize(true);
        presaleList.setNestedScrollingEnabled(false);

        addPresalelea1();
        homeGoodsItmeAdapter1 = new HomeGoodsItemAdapter(R.layout.goods_item, goodsItems1, this);
        homeGoodsItmeAdapter1.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        homeGoodsItmeAdapter1.setOnItemChildClickListener(this);
        GridLayoutManager specialLayout =  new GridLayoutManager(this, 2);
        specialLayout.setSmoothScrollbarEnabled(true);
        specialLayout.setAutoMeasureEnabled(true);

        specialList.setLayoutManager(specialLayout);
        specialList.setAdapter(homeGoodsItmeAdapter1);
        specialList.setHasFixedSize(true);
        specialList.setNestedScrollingEnabled(false);

        nestedScrollview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            // 将透明度声明成局部变量用于判断
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY >= height) {
                    llTitle.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorAccent));
                    StatusBarUtilNoBar.setStatusBarColor(MainActivity.this, MainActivity.this.getResources().getColor(R.color.colorAccent));
                } else {
                    llTitle.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.bg_transparent));
                    StatusBarUtilNoBar.setStatusBarColor(MainActivity.this, MainActivity.this.getResources().getColor(R.color.bg_transparent));
                }
            }
        });

        bottomBarView.setTextColorAndBg(1);
    }


    private void floatStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            RelativeLayout.LayoutParams titleParams = (RelativeLayout.LayoutParams) llTitle.getLayoutParams();
            // 标题栏在上方留出一段距离，看起来仍在状态栏下方
            titleParams.topMargin = StatusBarUtilNoBar.getStatusBarHeight(this);
            llTitle.setLayoutParams(titleParams);
        }
    }

    @OnClick(R.id.search_title)
    public void searchTitle(){
        startActivity(new Intent(this, GoodsSearchActivity.class));
    }

    @OnClick(R.id.fragment_bottom_bar)
    public void goGoodsCar(){
        startActivity(new Intent(this, GoodsCarActivity.class));
    }

    /**
     * 初始化首页菜单项
     */
    private void initMenuItem() {
        homeMenuItems = new ArrayList<>();
        homeMenuItems.add(new HomeMenuItem("我常购买", R.mipmap.home_icon_regularpurchase, null));
        homeMenuItems.add(new HomeMenuItem("我的收藏", R.mipmap.home_icon_collect, null));
        homeMenuItems.add(new HomeMenuItem("我的订单", R.mipmap.home_icon_order, null));
        homeMenuItems.add(new HomeMenuItem("我的退货", R.mipmap.home_icon_refund, null));
        homeMenuItems.add(new HomeMenuItem("优惠券", R.mipmap.home_icon_coupon, null));
        homeMenuItems.add(new HomeMenuItem("预售活动", R.mipmap.home_icon_presale, null));
        homeMenuItems.add(new HomeMenuItem("特价商品", R.mipmap.home_icon_special, null));
        homeMenuItems.add(new HomeMenuItem("全部商品", R.mipmap.home_icon_all, null));
    }

    /**
     * 轮播图图片列表
     */
    private void addBannerData() {
        imgList = new ArrayList<>();
        imgList.add(R.mipmap.home_banner);
        imgList.add(R.mipmap.home_banner);
        imgList.add(R.mipmap.home_banner);
        imgList.add(R.mipmap.home_banner);
    }


    /**
     * 设置跑马灯
     */
    private void setMarquee() {
        List<View> views = new ArrayList<>();
        for (int i = 0; i < marqueeList.size(); i = i + 2) {
            LinearLayout view = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.marquee_text, null);
            TextView textTop = view.findViewById(R.id.text_top);
            TextView textBottom = view.findViewById(R.id.text_bottom);
            textTop.setText(marqueeList.get(i));
            if (marqueeList.size() > i + 1) {
                textBottom.setText(marqueeList.get(i + 1));
            }
            views.add(view);
        }
        marquee.setViews(views);
    }

    /**
     * 添加跑马灯数据
     */
    private void addMarqueeData() {
        marqueeList = new ArrayList<>();
        marqueeList.add("太疯狂！IPhone X首批1分钟卖光。");
        marqueeList.add("家人给2岁孩子喝这个，孩子智力倒退10岁!");
        marqueeList.add("自助餐里面的潜规则，想要吃回本其实很简单。");
        marqueeList.add("简直是白菜价！日本玩家33万甩卖15万张游戏王卡。");
    }

    /**
     * 初始化限时特价商品
     */
    private void addPresalelea() {
        goodsItems = new ArrayList<>();
        goodsItems.add(new GoodsItem("8月预售组合特惠活动", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 88.00f, "1", "",false,1,1,10, Type.DISABLE_SWIPE_MENU));
        goodsItems.add(new GoodsItem("8月预售组合特惠活动", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 88.00f, "1", "",false,1,1,10, Type.DISABLE_SWIPE_MENU));
        goodsItems.add(new GoodsItem("8月预售组合特惠活动", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 88.00f, "1", "",false,1,1,10, Type.DISABLE_SWIPE_MENU));
    }

    /**
     * 初始化限时特价商品
     */
    private void addPresalelea1() {
        goodsItems1 = new ArrayList<>();
        goodsItems1.add(new GoodsItem("旺旺仙贝540g加量装休闲零食饼干膨化小吃", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 88.00f, "1", "",false,10,10,10, Type.DISABLE_SWIPE_MENU));
        goodsItems1.add(new GoodsItem("旺旺仙贝540g加量装休闲零食饼干膨化小吃", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 88.00f, "1", "",false,10,10,10, Type.DISABLE_SWIPE_MENU));
        goodsItems1.add(new GoodsItem("旺旺仙贝540g加量装休闲零食饼干膨化小吃", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 88.00f, "1", "",false,10,10,10, Type.DISABLE_SWIPE_MENU));
        goodsItems1.add(new GoodsItem("旺旺仙贝540g加量装休闲零食饼干膨化小吃", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 88.00f, "1", "",false,10,10,10, Type.DISABLE_SWIPE_MENU));
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        int itemViewId = view.getId();
        switch (itemViewId){
            case R.id.good_item:
                startActivity(new Intent(MainActivity.this, GoodsDetailActivity.class));
                break;
            case R.id.goods_buy:
                try {
                    //添加购物车数量角标
                    bottomBarView.add(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //添加购物车动画
                AddGoodAnimationUtil.add(view,container,ivOrder,this);
                break;
            case R.id.menu_layout:
                HomeMenuItem homeMenuItem = homeMenuItems.get(position);
                switch (homeMenuItem.getMenuImageid()){
                    case R.mipmap.home_icon_regularpurchase:
                        //我常购买
                        break;
                    case R.mipmap.home_icon_collect:
                        //我的收藏
                        break;
                    case R.mipmap.home_icon_order:
                        //我的订单
                        startActivity(new Intent(MainActivity.this, MyOrderActivity.class));
                        break;
                    case R.mipmap.home_icon_refund:
                        //我的退货
                        break;
                    case R.mipmap.home_icon_coupon:
                        //优惠券
                        break;
                    case R.mipmap.home_icon_presale:
                        //预售活动
                        startActivity(new Intent(MainActivity.this,AllGoodsActivity.class));
                        break;
                    case R.mipmap.home_icon_special:
                        //特价商品
                        break;
                    case R.mipmap.home_icon_all:
                        //全部商品
                        break;
                }
                break;
        }
    }

}
