package com.yunmayi.app.baselibrary.utils;

import java.text.DecimalFormat;

/**
 * Created by ys on 2017/6/13.
 * 转换金钱格式
 */

public class PriceTransfer {

    public static final String chageMoneyToString(Double money){
        if (money != null){
            DecimalFormat decimalFormat = new DecimalFormat("######0.00");
            return decimalFormat.format(money);
        }else{
            return  null;
        }
    }
}
