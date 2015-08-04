package com.google.ximalayafm.app.module;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2015/7/29.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/29
 * Time:17:01
 */
public class DiscoveryTab {

    private String title;

    private String contentType;

    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
            title = jsonObject.getString("title");

            contentType = jsonObject.getString("contentType");
        }
    }

    public String getContentType() {
        return contentType;
    }

    public String getTitle() {
        return title;
    }
}
