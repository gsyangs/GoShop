package com.yunmayi.app.wholesale.good;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yunmayi.app.baselibrary.common.Banner;
import com.yunmayi.app.baselibrary.common.BottomBarView;
import com.yunmayi.app.baselibrary.utils.AddGoodAnimationUtil;
import com.yunmayi.app.baselibrary.view.BaseActivity;
import com.yunmayi.app.wholesale.R;
import com.yunmayi.app.wholesale.shopcar.GoodsCarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ys on 2018/10/15.
 * 商品详情
 */

public class GoodsDetailActivity extends BaseActivity {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.good_price)
    TextView goodPrice;
    @BindView(R.id.goods_spec)
    TextView goodsSpec;
    @BindView(R.id.goods_spec_name)
    TextView goodsSpecName;
    @BindView(R.id.whole_box_spec)
    TextView wholeBoxSpec;
    @BindView(R.id.spec_number)
    TextView specNumber;
    @BindView(R.id.goods_brand_name)
    TextView goodsBrandName;
    @BindView(R.id.good_guarantee_date_title)
    TextView goodGuaranteeDateTitle;
    @BindView(R.id.good_guarantee_date)
    TextView goodGuaranteeDate;
    @BindView(R.id.goods_standard_title)
    TextView goodsStandardTitle;
    @BindView(R.id.goods_standard_name)
    TextView goodsStandardName;
    @BindView(R.id.goods_retail_price)
    TextView goodsRetailPrice;
    @BindView(R.id.good_detail)
    LinearLayout goodDetail;
    @BindView(R.id.et_item_shopcart_cloth_num)
    EditText etItemShopcartClothNum;
    @BindView(R.id.tv_shopcart_submit)
    TextView tvShopcartSubmit;
    @BindView(R.id.iv_item_shopcart_cloth_minus)
    ImageView ivItemShopcartClothMinus;
    @BindView(R.id.iv_item_shopcart_cloth_add)
    ImageView ivItemShopcartClothAdd;
    @BindView(R.id.activity_good_detail)
    RelativeLayout container;
    @BindView(R.id.goods_car_view)
    LinearLayout goodsCarLayout;
    @BindView(R.id.goods_car)
    BottomBarView bottomBarView;
    private List<String> imgList;
    private int count = 1;

    @Override
    protected int getContentViewLayoutID() {
        setHeadColorWhite(true);
        hideBackLayout(true);
        return R.layout.activity_good_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        addBannerData();
        banner.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        banner.setBannerStyle(Banner.NUM_INDICATOR);
        banner.setIndicatorGravity(Banner.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setImages(imgList, null);

        //设置点击事件，下标是从1开始
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
//                Toast.makeText(getApplicationContext(), "你点击了：" + position, Toast.LENGTH_LONG).show();
            }
        });

        bottomBarView.setTextColorAndBg(2);

        etItemShopcartClothNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable == null || editable.toString().length() == 0){
                    etItemShopcartClothNum.setText("1");
                }
                etItemShopcartClothNum.setSelection(etItemShopcartClothNum.getText().length());
                count = Integer.parseInt(etItemShopcartClothNum.getText().toString());
            }
        });
    }

    @OnClick(R.id.iv_item_shopcart_cloth_minus)
    public void onIvItemShopClothMinus() {
        if (count > 1){
            count--;
            etItemShopcartClothNum.setText(String.valueOf(count));
        }
    }

    @OnClick(R.id.iv_item_shopcart_cloth_add)
    public void onIvItemShopClothAdd() {
        if (count < 10000){
            count++;
            etItemShopcartClothNum.setText(String.valueOf(count));
        }
    }

    @OnClick(R.id.back_good_detail)
    public void onBackGoodDetail() {
        this.finish();
    }

    @OnClick(R.id.goods_car)
    public void onGoodsCar() {
        startActivity(new Intent(this, GoodsCarActivity.class));
    }

    @OnClick(R.id.tv_shopcart_submit)
    public void onTvShopCartSubmit(){
        try {
            bottomBarView.add(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AddGoodAnimationUtil.add(tvShopcartSubmit,container,goodsCarLayout,this);
    }

    /**
     * 轮播图图片列表
     */
    private void addBannerData() {
        imgList = new ArrayList<>();
        imgList.add("http://pic1.womai.com/upload/601/603/606/6600/6604/642894/642894_1_pic1080_4083.jpg");
        imgList.add("http://pic1.womai.com/upload/601/603/606/6600/6604/642894/642894_1_pic1080_4083.jpg");
        imgList.add("http://pic1.womai.com/upload/601/603/606/6600/6604/642894/642894_1_pic1080_4083.jpg");
        imgList.add("http://pic1.womai.com/upload/601/603/606/6600/6604/642894/642894_1_pic1080_4083.jpg");
    }

}
