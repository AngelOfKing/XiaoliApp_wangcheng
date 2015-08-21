package com.google.ximalayafm.app.module.json________book;

/**
 * Created by Administrator on 2015/7/30.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/30
 * Time:9:14
 */

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 *  "calcDimension": "hot",
 "tagName": "",
 "contentType": "album",
 "title": "最火",
 "hasMore": true,
 "list"
 */


public class BookMenu_categoryContents_List {
    private String calcDimension;
    private String tagName;
    private String contentType;
    private String title;
    private boolean hasMore;
    private List<BookMenu_categoryContents_List_List> list;


    public void parseJsonObject(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
            int id = jsonObject.getInt("id");
        }
    }



    public String getCalcDimension() {
        return calcDimension;
    }

    public String getContentType() {
        return contentType;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public List<BookMenu_categoryContents_List_List> getList() {
        return list;
    }

    public String getTagName() {
        return tagName;
    }

    public String getTitle() {
        return title;
    }
}
