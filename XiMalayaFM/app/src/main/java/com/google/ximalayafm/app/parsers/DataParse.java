package com.google.ximalayafm.app.parsers;

import com.google.ximalayafm.app.module.DiscoverRecommend;
import com.google.ximalayafm.app.module.DiscoveryCategory;
import com.google.ximalayafm.app.module.CategoryTagMenu;
import com.google.ximalayafm.app.module.DiscoveryTab;
import com.google.ximalayafm.app.module.json17_album.Album_tracks;
import com.google.ximalayafm.app.util.MyLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/28.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/28
 * Time:17:02
 */
public final class DataParse {
    private DataParse() {
    }


    public static List<CategoryTagMenu> parseCategoryResultMenu(JSONObject json) throws JSONException {

        List<CategoryTagMenu> ret = null;
        if (json != null) {
            int code = json.getInt("ret");
            if (code == 0) {
                JSONObject data = json.getJSONObject("data");
                //////////////////////////////////
                int count = data.getInt("category_count");
                if(count>0){
                    ret =  new ArrayList<CategoryTagMenu>();

                    JSONArray category_list = data.getJSONArray("category_list");
                    for(int i=0;i<category_list.length();i++){
                        CategoryTagMenu categoryTagMenu = new CategoryTagMenu();
                        categoryTagMenu.parseJSON(category_list.getJSONObject(i));
                        ret.add(categoryTagMenu);
                    }

                }

            }
        }
        return ret;
    }


    //parse the JSOnString to get the DiscoveryTitles

    public static List<DiscoveryTab> parseDiscoveryTabResult(JSONObject jsonObject) throws JSONException {
        List<DiscoveryTab> discoveryTabs = null;

        if(jsonObject!=null){
            int code = jsonObject.getInt("ret");
            if(code == 0){
                JSONObject tabs = jsonObject.getJSONObject("tabs");

                    JSONArray array = tabs.getJSONArray("list");
                    if(array!=null){
                        discoveryTabs = new ArrayList<DiscoveryTab>();
                        for(int i=0;i< array.length();i++){
                            DiscoveryTab tab = new DiscoveryTab();
                            tab.parseJSON(array.getJSONObject(i));
                            discoveryTabs.add(tab);
                        }

                        //TODO 更新ViewPager 与TabLayout
                    }
            }
        }

        return discoveryTabs;
    }


    /**
     * 分类
     * @param jsonObject
     * @return
     */
    public static List<DiscoveryCategory> parseDiscoveryCategoryResult(JSONObject jsonObject){

        List<DiscoveryCategory> discoveryCategories = null;
        if(jsonObject!=null){
            try {
                int code = jsonObject.getInt("ret");
                if(code==0){
                    JSONArray array = jsonObject.getJSONArray("list");
                    int length = array.length();
                    if(length>0){
                        discoveryCategories = new ArrayList<DiscoveryCategory>();
                        for(int i=0;i<length;i++){
                            DiscoveryCategory discoveryCategory = new DiscoveryCategory();
                            discoveryCategory.parseJSON(array.getJSONObject(i));
                            discoveryCategories.add(discoveryCategory);
                        }
                    }
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
       return discoveryCategories;
    }

    public static DiscoverRecommend parseJSON(JSONObject jsonObject){
        DiscoverRecommend ret = null;

        if(jsonObject!=null){
            try {
                int code = jsonObject.getInt("ret");
                if(code==0){
                    ret = new DiscoverRecommend();
                    ret.parseJSON(jsonObject);
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return ret;
    }

    //获取---专辑详情
    public static Album_tracks parseAlbum_tracks(JSONObject jsonObject)  {
        Album_tracks ret = null;
        if(jsonObject!=null){
            int code = 0;
            try {
                code = jsonObject.getInt("ret");
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            if(code == 0){
                ret = new Album_tracks();
                try {
                    ret.parseJSON(jsonObject);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        MyLog.d("====Dataparse"," "+(ret==null));
        return ret;
    }





//    /**
//     * 得到 分类-->娱乐菜单的分类
//     * @param jsonObject
//     * @return
//     */
//    public static List<EntertainmentMenu> parseEntertainmentMenuResult(JSONObject jsonObject){
//        List<EntertainmentMenu> ret = null;
//        if(jsonObject!=null){
//            try {
//                int code = jsonObject.getInt("ret");
//                if(code==0){
//                    int count = jsonObject.getInt("count");
//                    if(count>0){
//                        ret = new ArrayList<EntertainmentMenu>();
//                        JSONArray array = jsonObject.getJSONArray("list");
//                        int length = array.length();
//                        if(length>0){
//                            for (int i = 0; i < length; i++) {
//                                EntertainmentMenu entertainmentMenu = new EntertainmentMenu();
//                                entertainmentMenu.parseJSON(array.getJSONObject(i));
//                                ret.add(entertainmentMenu);
//                            }
//                        }
//
//                    }
//                }
//            }
//            catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return ret;
//    }
//

}

