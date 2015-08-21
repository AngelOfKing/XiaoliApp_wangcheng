package com.google.ximalayafm.app;

/**
 * Created by Administrator on 2015/8/6.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/6
 * Time:17:44
 */
public class NetworkSingleton {
    private static NetworkSingleton ourInstance = new NetworkSingleton();

    public static NetworkSingleton getInstance() {
        return ourInstance;
    }

    private NetworkSingleton() {
    }
}
