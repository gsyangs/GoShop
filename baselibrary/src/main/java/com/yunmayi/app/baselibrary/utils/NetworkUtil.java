package com.yunmayi.app.baselibrary.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.yunmayi.app.baselibrary.application.BaseAppLication;

/**
 * 判断是否有网
 * Created by smile on 2017/3/6.
 */
public class NetworkUtil {

    private static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) BaseAppLication.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = NetworkUtil.getConnectivityManager();
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isAvailable();
    }

    public static boolean isWIFI() {
        ConnectivityManager connectivityManager = NetworkUtil.getConnectivityManager();
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }

    public static String getMachineIpAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled()) {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int ipAddress = wifiInfo.getIpAddress();
            return intToIp(ipAddress);
        }
        return "0.0.0.0";
    }

    private static String intToIp(int ipAddress) {
        return (ipAddress & 0xFF) + "." + ((ipAddress >> 8) & 0xFF) + "." + ((ipAddress >> 16) & 0xFF)
                + "." + (ipAddress >> 24 & 0xFF);
    }

}
