package com.yunmayi.app.baselibrary.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ys on 2018/4/12.
 */

public class AssetsUtil {

    //从Assets中获取Drawable
    public static Drawable getDrawableFromAsset(Context context, String name)
    {
        Bitmap image = null;
        AssetManager am =context.getResources().getAssets();
        try
        {
            InputStream is = am.open(name);
            image = BitmapFactory.decodeStream(is);
            is.close();
            Drawable drawable =new BitmapDrawable(image);
            return drawable;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
