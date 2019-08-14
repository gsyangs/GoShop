package com.yunmayi.app.wholesale.good;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yunmayi.app.wholesale.common.SelectGoodsWindow;
import com.yunmayi.app.baselibrary.view.BaseActivity;
import com.yunmayi.app.entity.Category;
import com.yunmayi.app.entity.GoodsItem;
import com.yunmayi.app.entity.Type;
import com.yunmayi.app.wholesale.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ys on 2018/10/15.
 * 商品列表
 */

public class GoodsListActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener ,SelectGoodsWindow.OnDismissChangeBgListener{
    @BindView(R.id.back_good_detail)
    ImageView backGoodDetail;
    @BindView(R.id.keyword)
    EditText mKeyword;
    @BindView(R.id.goods_search)
    TextView goodsSearch;
    @BindView(R.id.good_list)
    RecyclerView goodList;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.category_list)
    RecyclerView categoryList;
    @BindView(R.id.brand_list)
    RecyclerView brandList;

    private List<GoodsItem> goodsItems;
    private GoodsListAdapter goodsListAdapter;
    private List<Category> categorys;
    private List<Category> brands;
    private CategoryListAdapter categoryListAdapter1, categoryListAdapter2;
    private SelectGoodsWindow addPopupwindow;
    @Override
    protected int getContentViewLayoutID() {
        setHeadColorWhite(true);
        hideBackLayout(true);
        return R.layout.activity_good_list;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        String keyword = getIntent().getStringExtra("keyword");
        mKeyword.setText(keyword);
        goodsItems = new ArrayList<>();
        goodsListAdapter = new GoodsListAdapter(R.layout.good_list_item, goodsItems, this);
        goodsListAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        goodsListAdapter.setOnItemChildClickListener(this);
        goodList.setLayoutManager(new LinearLayoutManager(this));
        goodList.setAdapter(goodsListAdapter);

        getGoodsCarList();

        //初始化右边的侧滑菜单
        initDrawerRightLayout();

    }

    /**
     * 右边侧滑
     */
    private void initDrawerRightLayout() {
        categoryList.setLayoutManager(new GridLayoutManager(this, 3));
        categorys = new ArrayList<>();
        Category category1 = new Category("食品零售", false);
        Category category2 = new Category("酒水饮料", false);
        Category category3 = new Category("家用百货", false);
        Category category4 = new Category("母婴用品", false);
        Category category5 = new Category("饼干点心", false);
        Category category6 = new Category("方便食品", false);
        categorys.add(category1);
        categorys.add(category2);
        categorys.add(category3);
        categorys.add(category4);
        categorys.add(category5);
        categorys.add(category6);

        categoryListAdapter1 = new CategoryListAdapter(R.layout.category_item, categorys, 1, this);
        categoryListAdapter1.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        categoryListAdapter1.setOnItemChildClickListener(this);
        categoryList.setAdapter(categoryListAdapter1);

        brandList.setLayoutManager(new GridLayoutManager(this, 3));
        brands = new ArrayList<>();
        Category brand1 = new Category("蒙牛", false);
        Category brand2 = new Category("维他奶", false);
        Category brand3 = new Category("伊利", false);
        Category brand4 = new Category("康师傅", false);
        Category brand5 = new Category("和路雪", false);
        Category brand6 = new Category("阿尔卑斯山", false);
        Category brand7 = new Category("卡夫", false);
        Category brand8 = new Category("好阿婆", false);
        brands.add(brand1);
        brands.add(brand2);
        brands.add(brand3);
        brands.add(brand4);
        brands.add(brand5);
        brands.add(brand6);
        brands.add(brand7);
        brands.add(brand8);

        categoryListAdapter2 = new CategoryListAdapter(R.layout.brand_item, brands, 2, this);
        categoryListAdapter2.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        categoryListAdapter2.setOnItemChildClickListener(this);

        brandList.setAdapter(categoryListAdapter2);
    }

    private void getGoodsCarList() {
        GoodsItem goodsItem1 = new GoodsItem("特仑苏低脂纯牛奶250ml*12盒", "http://www.lkhs.cn/UserFile/ProductMain/20160505112642527f.gif", 48.88f, "690000001", "250ml*24盒", false, 1, 1, 10, Type.RIGHT_MENU);
        goodsItems.add(goodsItem1);
        GoodsItem goodsItem2 = new GoodsItem("伊利纯牛奶 250ml*20盒", "http://pifa.yunmayi.com/upload/2017/02/23/290e979ca4341b88f9a1db6a3290fc40.jpg", 68.00f, "690000002", "250ml*20盒", false, 2, 2, 10, Type.RIGHT_MENU);
        goodsItems.add(goodsItem2);
        GoodsItem goodsItem3 = new GoodsItem("伊利QQ星营养果汁酸奶香蕉奶 200ml*16瓶", "http://pifa.yunmayi.com/upload/2016/07/11/1a06496c872f9e83d3786c35e25dc91c.jpg", 40.00f, "690000003", "200ml*16瓶", false, 3, 3, 10, Type.RIGHT_MENU);
        goodsItems.add(goodsItem3);
        GoodsItem goodsItem4 = new GoodsItem("力士闪亮冰爽沐浴乳200ml 1020", "http://pifa.yunmayi.com/upload/2015/03/10/50df2b8005e36ac6d36213a4ef43b7f1.jpg", 9.50f, "690000004", "12瓶", false, 5, 5, 30, Type.RIGHT_MENU);
        goodsItems.add(goodsItem4);
        GoodsItem goodsItem5 = new GoodsItem("三笑深层洁净系列中毛牙刷 6933", "http://pifa.yunmayi.com/upload/2016/02/29/5764e1cbc10842b248b2ee15719de23b.jpg", 26.30f, "690000005", "1箱*10组*30支", false, 6, 6, 30, Type.RIGHT_MENU);
        goodsItems.add(goodsItem5);
        GoodsItem goodsItem6 = new GoodsItem("口留乡豆花串80g", "http://pifa.yunmayi.com/upload/2016/04/28/276e009212f152ac058ce3b28bbf431c.jpg", 2.10f, "690000006", "80g*60包/箱", false, 10, 10, 30, Type.RIGHT_MENU);
        goodsItems.add(goodsItem6);
        GoodsItem goodsItem7 = new GoodsItem("康师傅劲爽拉面红烧牛肉桶面 107g*12", "http://pifa.yunmayi.com/upload/2016/03/18/93d9c37f93dac4d47c564eac98babf9c.jpg", 30.50f, "690000007", "107g*12桶", false, 5, 5, 30, Type.RIGHT_MENU);
        goodsItems.add(goodsItem7);

        goodsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        int id = view.getId();
        switch (id) {
            case R.id.goods_buy:
                if (addPopupwindow == null) {
                    addPopupwindow = new SelectGoodsWindow(this);
                }
                addPopupwindow.setOnDismissChangeBgListener(this);
                backgroundAlpha(0.4f);
                break;
            case R.id.category_title:
                for (int i = 0; i < categorys.size(); i++) {
                    Category category = categorys.get(i);
                    category.setSelect(false);
                    categorys.set(i, category);
                }
                Category category = categorys.get(position);
                category.setSelect(true);
                categorys.set(position, category);
                categoryListAdapter1.notifyDataSetChanged();
                break;
            case R.id.brand_title:
                for (int i = 0; i < brands.size(); i++) {
                    Category category1 = brands.get(i);
                    category1.setSelect(false);
                    brands.set(i, category1);
                }
                Category category1 = brands.get(position);
                category1.setSelect(true);
                brands.set(position, category1);
                categoryListAdapter2.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onDismissChangeBg(float bgAlpha) {
        backgroundAlpha(bgAlpha);
    }

    /**
     * 弹出分享
     */
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

            }
        }
    };

    /**
     * 设置窗口透明度
     * @param bgAlpha
     */
    private void backgroundAlpha(float bgAlpha){
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);//这句就是设置窗口里崆件的透明度的．０.０全透明．１.０不透明．
        addPopupwindow.showAtLocation(findViewById(R.id.extension_layout), Gravity.CENTER, 0, 0);
    }
}
