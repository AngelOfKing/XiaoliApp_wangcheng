package com.google.ximalayafm.app.data;

/**
 * Created by Administrator on 2015/7/29.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/29
 * Time:19:52
 */

import com.google.ximalayafm.app.module.DiscoveryCategory;
import com.google.ximalayafm.app.module.json17_album.Album_tracks;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 公共数据的存储区
 */
public class DataStore {
    private static DataStore ourInstance ;

    public static DataStore getInstance() {

        if (ourInstance == null) {
            ourInstance = new DataStore();
        }
        return ourInstance;
    }

    //
    public static void release(){
        ourInstance = null;
    }

    private List<DiscoveryCategory> discoveryCategories;

    public void setDiscoveryCategories(List<DiscoveryCategory> discoveryCategories) {

        if(discoveryCategories!=null&&!discoveryCategories.isEmpty()){
            discoveryCategories.clear();
            discoveryCategories.addAll(discoveryCategories);
            Collections.sort(discoveryCategories);
        }

    }

    private DataStore() {
        discoveryCategories = new LinkedList<DiscoveryCategory>();
    }
    //获取已经加载过的分类列表

    public List<DiscoveryCategory> getDiscoveryCategories() {
        return discoveryCategories;
    }



}
