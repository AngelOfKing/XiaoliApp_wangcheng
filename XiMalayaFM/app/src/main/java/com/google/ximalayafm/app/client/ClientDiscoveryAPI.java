package com.google.ximalayafm.app.client;

/**
 * Created by Administrator on 2015/7/28.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/28
 * Time:15:10
 */

import android.util.Log;
import com.google.ximalayafm.app.util.MyLog;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *发现 部分的API接口调用,获得的都是：JSONString
 */
public final class ClientDiscoveryAPI  {
    public static final String SERVER_MOBILE="http://mobile.ximalaya.com";
    private ClientDiscoveryAPI(){
    }

    /////////////////////////////////

    /**
     获取"发现"界面Tab的定义<br/>
     * 调用接口: http://mobile.ximalaya.com/mobile/discovery/v1/tabs?device=android
     * 不需要参数
     * @return
     */
    public static String getDiscoveryTabs(){
        String ret = null;
        String url = SERVER_MOBILE+"/mobile/discovery/v1/tabs?device=android";
        byte[] data = HttpUtil.doGet(url);
        if(data!=null){
            try {
                ret = new String(data,"utf-8");
            }
            catch (UnsupportedEncodingException e) {
                ret = new String(data);
            }
        }
        return ret;
    }

    /**
     * 获取"分类"Tag菜单<br/>
     * 调用接口: http://mobile.ximalaya.com/m/category_tag_menu<br/>
     * 请求方法: GET<br/>
     *
     * @param type 可选 默认是 user
     * @return
     */
    public static String getCategoryMenu(String type) throws IOException {
        String ret = null;
        StringBuilder sb = new StringBuilder();
        sb.append(SERVER_MOBILE);
        sb.append("/m/category_tag_menu");
        if(type!=null){
           sb.append("?type=").append(type);
            sb.append("&device=android");
        }
         String url = sb.toString();
        sb = null;

        byte[] data = HttpUtil.doGet(url);
        if(data!=null){
             ret = new String(data,0,data.length);
        }
        return ret;
    }

    /**
     * 获取"发现"的分类<br/>
     * 调用的接口:<br/>
     * http://mobile.ximalaya.com/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2<br/>
     * @return
     */

    public static String getDiscoveryCategory() {
        String ret = null;
        String url =
                SERVER_MOBILE + "/mobile/discovery/v1/categories"
                        + "?device=android"
                        + "&picVersion=10"
                        + "&scale=2";

        byte[] bytes = HttpUtil.doGet(url);
        if (bytes != null) {
            try {
                ret = new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ret = new String(bytes);
            }
        }
        return ret;
    }


    /**
     * 推荐的JSONString
     * http://mobile.ximalaya.com/mobile/discovery/v1/recommends?
     * channel=and-f6&device=android&includeActivity=true&
     * includeSpecial=true& &scale=2&version=4.1.7.1
     * @return
     */
    public static String getDiscoveryRecommend(){
        String ret = null;
        String url =
                SERVER_MOBILE + "/mobile/discovery/v1/recommends"
                        + "?channel=and-f6"
                        + "&device=android"
                        + "&includeActivity=true"
                        + "&includeSpecial=true"
                        + "&scale=2"
                        + "&version=4.1.7.1"
                ;
        byte[] bytes = HttpUtil.doGet(url);
        if(bytes!=null){
            try {
                ret = new String(bytes,"utf-8");
            }
            catch (UnsupportedEncodingException e) {
                ret = new String(bytes);
            }
        }
        return ret;
    }

    //得到专辑列表
    public static String getAlbum_tracksString(){
        String ret = null;
        String url = SERVER_MOBILE+"/mobile/others/ca/album/track/203355/true/1/20?" +
                "device=android&pageSize=20" +
                "&albumId=203355" +
                "&isAsc=true";
        byte[] bytes = HttpUtil.doGet(url);
        if(bytes!=null){
            try {
                ret = new String(bytes,"utf-8");
                MyLog.d("===ClAPT",ret);
            }
            catch (UnsupportedEncodingException e) {
               ret = new String(bytes);
            }
        }
        return ret;
    }
















//    public static String getDiscoveryCategory() throws IOException {
//        String ret = null;
//        String url = SERVER_MOBILE+"/discovery/v1/categories?device=android&picVersion=10&scale=2";
//        byte[] data = HttpUtil.doGet(url);
//
//        if(data!=null){
//            ret = new String(data,"UTF-8");
//        }
//        return ret;
//    }

//    public static String getBookMenu() throws UnsupportedEncodingException {
//        String ret = null;
//        String url = SERVER_MOBILE+" ";
//        byte[] data = HttpUtil.doGet(url);
//        if(data!=null){
//            ret = new String(data,"utf-8");
//        }
//        return ret;
//    }
//
//    /**
//     *13获取 发现-->分类-->综艺娱乐的JSONString
//     * 调用的接口：
//     * http://mobile.ximalaya.com/mobile/discovery/v1/category/tagsWithoutCover?categoryId=4&contentType=album&device=android
//     * @return
//     */
//
//    public static String getEntertainmentMenu(){
//        String ret = null;
//        String url = SERVER_MOBILE+"/mobile/discovery/v1/category/tagsWithoutCover?"
//                + "categoryId=4&contentType=album&device=android";
//        byte[] data = HttpUtil.doGet(url);
//        if(data!=null){
//            try {
//                ret = new String(data,"utf-8");
//            }
//            catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//        return ret;
//    }



}
