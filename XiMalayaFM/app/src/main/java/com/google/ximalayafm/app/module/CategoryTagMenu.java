package com.google.ximalayafm.app.module;

/**
 * Created by Administrator on 2015/7/28.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/28
 * Time:17:06
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.LinkedList;
import java.util.List;



public class CategoryTagMenu {

    private int id;
    private String name;
    private String title;
    private String intro;
    private boolean display;
    private String cover_path;
    private List<String> tag_list;



    /**

     * @param jsonObject
     */
    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
            id = jsonObject.getInt("id");
            name = jsonObject.getString("name");
            title = jsonObject.getString("title");
            intro = jsonObject.optString("intro");
            display = jsonObject.getBoolean("is_display");
            cover_path = jsonObject.getString("cover_path");
            JSONArray jsonArray = jsonObject.optJSONArray("tag_list");
            int length = jsonArray.length();
            tag_list = new LinkedList<String>();
            for(int i=0;i<length;i++){
                String string = jsonArray.getString(i);
                tag_list.add(string);
            }
        }
    }


    public String getCover_path() {
        return cover_path;
    }

    public boolean isDisplay() {
        return display;
    }

    public int getId() {
        return id;
    }

    public String getIntro() {
        return intro;
    }

    public String getName() {
        return name;
    }

    public List<String> getTag_list() {
        return tag_list;
    }

    public String getTitle() {
        return title;
    }


}
