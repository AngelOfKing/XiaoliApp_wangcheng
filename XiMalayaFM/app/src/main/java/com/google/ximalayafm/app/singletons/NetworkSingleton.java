package com.google.ximalayafm.app.singletons;

/**
 * Created by Administrator on 2015/8/4.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/4
 * Time:20:30
 */
public class NetworkSingleton {
    private static NetworkSingleton ourInstance = new NetworkSingleton();

    public static NetworkSingleton getInstance() {
        return ourInstance;
    }

    private NetworkSingleton() {
    }
}
