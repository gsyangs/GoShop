package com.yunmayi.app.baselibrary.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本工具类
 * *Created by ys on 17/5/27.
 */
public class TextUtils {

    //判断是否为空
    public static boolean isEmpty(String txt) {
        //判断引用对象是否为空，内容是否为空，长度是否为0
        if ((txt == null) || (txt.equals(null)) || (txt.length() == 0))
            return true;
        else
            return false;
    }

    /**
     * 是否是手机号码
     * @param mobiles 手机号码
     */
    public static boolean isMobileNumber(String mobiles) {
        Pattern p = Pattern.compile("^1[3578]\\d{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 比较版本号
     * @param version1
     * @param version2
     * @return 0 版本不变 1 低于当前版本 -1 高于当前版本
     */
    public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;

        while (index < minLen && (diff = Integer.parseInt(version1Array[index]) - Integer.parseInt(version2Array[index])) == 0) {
            index ++;
        }

        if (diff == 0) {
            for (int i = index; i < version1Array.length; i ++) {
                if (Integer.parseInt(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i ++) {
                if (Integer.parseInt(version2Array[i]) > 0) {
                    return -1;
                }
            }

            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }
}
