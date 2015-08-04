package com.google.ximalayafm.app.util;

import android.app.Application;
import com.google.ximalayafm.app.cache.FileCache;

/**
 * Created by Administrator on 2015/7/31.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/31
 * Time:19:14
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FileCache.CreatOutInstance(getApplicationContext());

    }
}
