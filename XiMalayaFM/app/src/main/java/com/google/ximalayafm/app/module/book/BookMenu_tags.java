package com.google.ximalayafm.app.module.book;

/**
 * Created by Administrator on 2015/7/30.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/30
 * Time:8:53
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 分类--->电子听书
 *  "tname": "浪漫言情",
 "category_id": 3
 */
public class BookMenu_tags {
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
