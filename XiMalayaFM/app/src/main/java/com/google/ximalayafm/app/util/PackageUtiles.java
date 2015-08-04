package com.google.ximalayafm.app.util;

/**
 * Created by Administrator on 2015/7/29.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/29
 * Time:9:58
 */

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


public final class PackageUtiles {
    private PackageUtiles(){

    }


    public static String getPackageVersionName(Context context){
        String ret = "1.0";
        if(context!=null){
            PackageManager packageManager = context.getPackageManager();

            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(
                        context.getPackageName(),
                        PackageManager.GET_ACTIVITIES);

                ret = packageInfo.versionName;
            }
            catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
}
