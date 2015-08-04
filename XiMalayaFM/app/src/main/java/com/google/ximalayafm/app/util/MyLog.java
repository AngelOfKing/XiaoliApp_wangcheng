package com.google.ximalayafm.app.util;

/**
 * Created by Administrator on 2015/7/31.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/31
 * Time:9:28
 */


import android.util.Log;
import com.google.ximalayafm.app.BuildConfig;

/**
 * 封装Android的log工具，能够增加日志的开关
 *
 */
public final class MyLog {

    /**
     * 日志的开关，在Release（发布软件包）的时候，关闭日志
     */
    public static final boolean ON = BuildConfig.DEBUG;


    /**
     * 通过变量 true,false控制日志的输出
     */
    private static final boolean DEBUG = true;
    public static final boolean  INFO = true;

    private MyLog(){

    }

    public static void d(String tag,String msg){
        if(ON){
            if(DEBUG){
                Log.d(tag,msg);
            }
        }
    }

    public static void i(String tag,String msg){
        if(ON){
            if(INFO){
                Log.i(tag,msg);
            }
        }
    }



}
