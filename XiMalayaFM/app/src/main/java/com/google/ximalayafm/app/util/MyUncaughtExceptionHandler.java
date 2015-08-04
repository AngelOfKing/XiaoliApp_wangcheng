package com.google.ximalayafm.app.util;

/**
 * Created by Administrator on 2015/7/31.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/31
 * Time:9:59
 */


import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 未捕获异常处理器
 */
public class MyUncaughtExceptionHandler  implements Thread.UncaughtExceptionHandler{
    private Context context;//用来获取文件路径的


    public MyUncaughtExceptionHandler(Context context) {
        this.context = context;
    }

    //当某一个线程发生了未捕获异常的时候，回调这个方法
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
            //TODO 将异常信息保存到文件中，下次启动获取并且上传服务器
        if(context!=null){
            File filesDir = context.getFilesDir();
            String state = Environment.getExternalStorageState();
            if(state==Environment.MEDIA_MOUNTED){
                File files = Environment.getExternalStoragePublicDirectory("files");
                File file = new File(files,"app.log");
                FileWriter fw = null;
                PrintWriter pw = null;
                try {
                    fw = new FileWriter(file);
                    pw = new PrintWriter(fw);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    StreamUtil.close(pw);
                    StreamUtil.close(fw);
                }
            }
        }

        System.exit(1);
    }
}
