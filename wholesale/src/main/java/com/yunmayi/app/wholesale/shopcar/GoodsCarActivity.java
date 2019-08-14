package com.yunmayi.app.wholesale.shopcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yunmayi.app.baselibrary.listener.BackOrderCountInfoListener;
import com.yunmayi.app.baselibrary.utils.Arith;
import com.yunmayi.app.baselibrary.utils.PriceFormatter;
import com.yunmayi.app.baselibrary.utils.PriceTransfer;
import com.yunmayi.app.baselibrary.view.BaseActivity;
import com.yunmayi.app.entity.GiftItem;
import com.yunmayi.app.entity.GoodsCarItem;
import com.yunmayi.app.entity.GoodsItem;
import com.yunmayi.app.entity.Type;
import com.yunmayi.app.wholesale.R;
import com.yunmayi.app.wholesale.order.ConfirmOrderActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ys on 2018/10/15.
 * 购物车
 */

public class GoodsCarActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener,BackOrderCountInfoListener{

    @BindView(R.id.good_item_list)
    RecyclerView goodItemList;
    @BindView(R.id.cart_checkbox)
    ImageView cartCheckbox;
    @BindView(R.id.tv_shopcart_addselect)
    TextView tvShopcartAddselect;
    @BindView(R.id.tv_shopcart_totalprice)
    TextView tvShopcartTotalprice;
    @BindView(R.id.tv_shopcart_submit)
    TextView tvShopcartSubmit;
    @BindView(R.id.ll_pay)
    ConstraintLayout llPay;

    private GoodsCarAdapter goodsCarAdapter;
    private List<GoodsCarItem> goodsCarItems;
    private boolean isAllSelect;

    @Override
    protected int getContentViewLayoutID() {
        setHeadColorWhite(true);
        return R.layout.activity_good_car;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitleText("购物车");
        showRight();
        setRightTitle("编辑");
        goodsCarItems = new ArrayList<>();
        goodsCarAdapter = new GoodsCarAdapter(R.layout.good_car_item,goodsCarItems,this,0);
        goodsCarAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        goodsCarAdapter.setOnItemChildClickListener(this);
        goodsCarAdapter.setBackOrderCountInfoListener(this);
        goodItemList.setLayoutManager(new LinearLayoutManager(this));
        goodItemList.setAdapter(goodsCarAdapter);

        getGoodsCarList();
    }

    @OnClick(R.id.cart_checkbox)
    public void onCartCheckbox(){
        if (isAllSelect){
            isAllSelect = false;
        }else{
            isAllSelect = true;
        }
        for (int i = 0; i < goodsCarItems.size(); i++){
            selectAllOne(2,i);
        }
        isAllSelect(2);
    }

    @OnClick(R.id.tv_shopcart_submit)
    public void onTvShopcartSubmit(){
        startActivity(new Intent(this, ConfirmOrderActivity.class));
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

    /**
     * 一类点击选择
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        selectAllOne(1,position);
        isAllSelect(1);
    }

    /**
     * 选中一个类目
     * @param type 1 单点类目 2 全选 （正反）
     * @param position  选择项
     */
    public void selectAllOne(int type,int position){
        GoodsCarItem goodsCarItem = goodsCarItems.get(position);
        if (type == 1){
            if (goodsCarItem.isSelect()){
                goodsCarItem.setSelect(false);
            }else{
                goodsCarItem.setSelect(true);
            }
        }else if (type == 2){
            goodsCarItem.setSelect(isAllSelect);
        }

        List<GoodsItem> goodsItems = goodsCarItems.get(position).getGoodsItems();
        for (int i = 0; i < goodsItems.size(); i++){
            GoodsItem goodsItem = goodsItems.get(i);
            goodsItem.setSelect(goodsCarItem.isSelect());
            goodsItems.set(i,goodsItem);
        }
        goodsCarItem.setGoodsItems(goodsItems);
        goodsCarItems.set(position,goodsCarItem);
        goodsCarAdapter.setData(position,goodsCarItem);
    }

    /**
     * 选择后回调选中的商品
     * @param goodsCarItem
     */
    @Override
    public void backInfo(GoodsCarItem goodsCarItem,int index) {
        goodsCarItems.set(index,goodsCarItem);
        isAllSelect(1);
    }

    /**
     * 判断是否全选
     * @param type 1 单点类目 2 全选 （正反）
     */
    public void isAllSelect(int type){
        if (type == 1){
            boolean newState = true;//临时状态
            for (GoodsCarItem carItem : goodsCarItems){
                for (GoodsItem item : carItem.getGoodsItems()){
                    if (!item.isSelect()){//如果有一个未选中的 则终止 临时状态为false
                        newState = false;
                        break;
                    }
                }
                if (!newState){// 如果临时状态为终止的， 外层也终止
                    break;
                }
            }

            if (newState){
                isAllSelect = true;
            }else{
                isAllSelect = false;
            }
        }
        double countPrice = 0;
        int countSize = 0;
        for (GoodsCarItem carItem : goodsCarItems){
            for (GoodsItem item : carItem.getGoodsItems()){
                if (item.isSelect()){
                    countSize ++;
                    countPrice = Arith.add(countPrice,Arith.mul(item.getNumber(),item.getGooodsPrice()));
                    System.out.println("选中的商品有：" +  item.getGoodsName() + " 价格为：" + item.getGooodsPrice() + " 数量：" + item.getNumber());
                }
            }
        }

        tvShopcartTotalprice.setText("¥" + PriceTransfer.chageMoneyToString(countPrice));
        tvShopcartSubmit.setText("去结算(" + countSize + ")");
        if (isAllSelect){
            Glide.with(this).load(R.mipmap.cart_checkbox_selected).into(cartCheckbox);
        }else{
            Glide.with(this).load(R.mipmap.cart_checkbox_normal).into(cartCheckbox);
        }
    }

}
