package com.yunmayi.app.wholesale.order;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yunmayi.app.baselibrary.common.CouponListDialog;
import com.yunmayi.app.baselibrary.common.ItemTextView;
import com.yunmayi.app.baselibrary.common.StartMessageDialog;
import com.yunmayi.app.baselibrary.view.BaseActivity;
import com.yunmayi.app.entity.GiftItem;
import com.yunmayi.app.entity.GoodsCarItem;
import com.yunmayi.app.entity.GoodsItem;
import com.yunmayi.app.entity.Type;
import com.yunmayi.app.wholesale.R;
import com.yunmayi.app.wholesale.shopcar.GoodsCarAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ys on 2018/11/12.
 * 确认订单
 */

public class ConfirmOrderActivity extends BaseActivity {

    @BindView(R.id.order_item)
    RecyclerView orderItem;
    @BindView(R.id.total_amount)
    ItemTextView totalAmount;
    @BindView(R.id.full_subtraction)
    ItemTextView fullSubtraction;
    @BindView(R.id.category_discount)
    ItemTextView categoryDiscount;
    @BindView(R.id.coupon)
    ItemTextView coupon;
    @BindView(R.id.tv_shopcart_title)
    TextView tvShopcartTitle;
    @BindView(R.id.tv_shopcart_totalprice)
    TextView tvShopcartTotalprice;
    @BindView(R.id.tv_shopcart_submit)
    TextView tvShopcartSubmit;
    @BindView(R.id.ll_pay)
    ConstraintLayout llPay;
    private GoodsCarAdapter goodsCarAdapter;
    private List<GoodsCarItem> goodsCarItems;

    @Override
    protected int getContentViewLayoutID() {
        setHeadColorWhite(true);
        return R.layout.activity_confirm_order;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitleText("确认订单");

        totalAmount.initLabel("总金额","188.99");
        fullSubtraction.initLabel("满就减", "-50.00");
        categoryDiscount.initLabel("类目折扣", "-00.00");
        coupon.initLabel("优惠券", "暂无");

        goodsCarItems = new ArrayList<>();
        goodsCarAdapter = new GoodsCarAdapter(R.layout.good_car_item,goodsCarItems,this,1);
        goodsCarAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        LinearLayoutManager orderLayout =  new LinearLayoutManager(this);
        orderLayout.setSmoothScrollbarEnabled(true);
        orderLayout.setAutoMeasureEnabled(true);
        orderItem.setLayoutManager(orderLayout);
        orderItem.setAdapter(goodsCarAdapter);
        orderItem.setHasFixedSize(true);
        orderItem.setNestedScrollingEnabled(false);

        getGoodsCarList();
    }

    private void getGoodsCarList(){
        GoodsCarItem goodsCarItem1 = new GoodsCarItem();
        goodsCarItem1.setId(10000001);
        goodsCarItem1.setGiftItem(new GiftItem(1,"获赠伊利无菌砖纯牛奶250ml*24盒，营养早餐牛奶","再购买1箱即可获赠伊利无菌砖250ml*24盒共2箱"));
        goodsCarItem1.setSupplierName("订单由平台【杭州】提供配送");
        List<GoodsItem> goodsItems1 = new ArrayList<>();
        GoodsItem goodsItem1 = new GoodsItem("特仑苏低脂纯牛奶250ml*12盒", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 48.88f, "690000001" , "250ml*24盒",false,1,1,10, Type.RIGHT_MENU);
        goodsItems1.add(goodsItem1);
        GoodsItem goodsItem2 = new GoodsItem("伊利纯牛奶 250ml*20盒", "http://pifa.yunmayi.com/upload/2017/02/23/290e979ca4341b88f9a1db6a3290fc40.jpg", 68.00f, "690000002"  , "250ml*20盒",false,2,2,10, Type.RIGHT_MENU);
        goodsItems1.add(goodsItem2);
        GoodsItem goodsItem3 = new GoodsItem("伊利QQ星营养果汁酸奶香蕉奶 200ml*16瓶", "http://pifa.yunmayi.com/upload/2016/07/11/1a06496c872f9e83d3786c35e25dc91c.jpg", 40.00f, "690000003", "200ml*16瓶",false,3,3,10, Type.RIGHT_MENU);
        goodsItems1.add(goodsItem3);
        goodsCarItem1.setGoodsItems(goodsItems1);
        goodsCarItem1.setSelect(false);
        goodsCarItem1.setDiscountInfo("享受28.88元的类目折扣");
        goodsCarItems.add(goodsCarItem1);

        GoodsCarItem goodsCarItem2 = new GoodsCarItem();
        goodsCarItem2.setId(10000002);
        goodsCarItem2.setGiftItem(new GiftItem(1,"获赠伊利无菌砖纯牛奶250ml*24盒，营养早餐牛奶","再购买1箱即可获赠伊利无菌砖250ml*24盒共2箱"));
        goodsCarItem2.setSupplierName("订单由平台【上海】提供配送");
        List<GoodsItem> goodsItems2 = new ArrayList<>();
        GoodsItem goodsItem4 = new GoodsItem("力士闪亮冰爽沐浴乳200ml 1020", "http://pifa.yunmayi.com/upload/2015/03/10/50df2b8005e36ac6d36213a4ef43b7f1.jpg", 9.50f, "690000004", "12瓶",false ,5,5,30, Type.RIGHT_MENU);
        goodsItems2.add(goodsItem4);
        GoodsItem goodsItem5 = new GoodsItem("三笑深层洁净系列中毛牙刷 6933", "http://pifa.yunmayi.com/upload/2016/02/29/5764e1cbc10842b248b2ee15719de23b.jpg", 26.30f, "690000005", "1箱*10组*30支",false,6,6,30, Type.RIGHT_MENU);
        goodsItems2.add(goodsItem5);
        GoodsItem goodsItem6 = new GoodsItem("口留乡豆花串80g", "http://pifa.yunmayi.com/upload/2016/04/28/276e009212f152ac058ce3b28bbf431c.jpg", 2.10f, "690000006", "80g*60包/箱",false,10,10,30, Type.RIGHT_MENU);
        goodsItems2.add(goodsItem6);
        GoodsItem goodsItem7 = new GoodsItem("康师傅劲爽拉面红烧牛肉桶面 107g*12", "http://pifa.yunmayi.com/upload/2016/03/18/93d9c37f93dac4d47c564eac98babf9c.jpg", 30.50f, "690000007", "107g*12桶",false,5,5,30, Type.RIGHT_MENU);
        goodsItems2.add(goodsItem7);
        goodsCarItem2.setGoodsItems(goodsItems2);
        goodsCarItem2.setSelect(false);
        goodsCarItem2.setDiscountInfo("享受28.88元的类目折扣");
        goodsCarItems.add(goodsCarItem2);

        goodsCarAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.select_address)
    public void onSelectAddress(){
        final CouponListDialog couponListDialog = new CouponListDialog(this);
        couponListDialog.setColose(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                couponListDialog.dismiss();
            }
        });
    }

    @OnClick(R.id.tv_shopcart_submit)
    public void onTvShopcartSubmit(){
//        final AlertDeleteDialog deleteDialog = new AlertDeleteDialog(this);
//        deleteDialog.setAlertTitle("确定取消订单？");
//        deleteDialog.setAlertMessage("删除订单后如需再次购买需重新下单");
//        deleteDialog.setCanceledOnTouchOutside(true);
//        deleteDialog.setPositiveButton(getResources().getString(R.string.confirm), new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteDialog.dismiss();
//            }
//        });
//        deleteDialog.setNegativeButton(getResources().getString(R.string.cancel), new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteDialog.dismiss();
//            }
//        });

        final StartMessageDialog startMessageDialog = new StartMessageDialog(this);
        startMessageDialog.setPositiveButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMessageDialog.dismiss();
            }
        });

    }

}
