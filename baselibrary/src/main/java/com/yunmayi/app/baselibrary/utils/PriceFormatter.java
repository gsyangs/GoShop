package com.yunmayi.app.baselibrary.utils;

/**
 * Created by smile on 2017/4/25.
 */
public class PriceFormatter {

    public static String int2string(long price) {
        float priceFloat = price / 100f;
        return String.format("%.2f", priceFloat);
    }

    public static String int2string(long price, boolean withUnit) {
        StringBuilder sb = new StringBuilder();
        if (withUnit) {
            sb.append("￥");
        }
        sb.append(PriceFormatter.int2string(price));
        return sb.toString();
    }
    public static String int2string(double price) {
        double priceFloat = Arith.div(price,100f,2);
        return String.format("%.2f", priceFloat);
    }
}
