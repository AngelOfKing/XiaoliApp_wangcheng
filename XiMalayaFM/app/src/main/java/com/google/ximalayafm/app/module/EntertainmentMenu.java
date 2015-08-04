package com.google.ximalayafm.app.module;

/**
 * Created by Administrator on 2015/7/29.
 * Project:ZhuFengFM
 * User:king
 * Date:2015/7/29
 * Time:23:56
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 娱乐菜单下的分类
 *  "tname": "笑话段子",
    "category_id": 4
 */
public class EntertainmentMenu {
    private String tname;
    private int category_id;

    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
            tname = jsonObject.getString("tname");
            category_id = jsonObject.getInt("category_id");
        }
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getTname() {
        return tname;
    }
}