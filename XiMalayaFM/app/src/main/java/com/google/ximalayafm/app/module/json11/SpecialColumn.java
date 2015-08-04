package com.google.ximalayafm.app.module.json11;

/**
 * Created by Administrator on 2015/7/30.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/30
 * Time:17:11
 */

import com.google.ximalayafm.app.util.MyLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * "ret": 0,
 "title": "精品听单",
 "hasMore": true,
 */
public class SpecialColumn {
    private String title;
    private boolean hasMore;
    private List<SpecialColumn_List> lists;


    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
                 title = jsonObject.getString("title");
                hasMore = jsonObject.getBoolean("hasMore");
                lists = new ArrayList<SpecialColumn_List>();

                JSONArray array = jsonObject.getJSONArray("list");
                for (int i = 0; i < array.length(); i++) {
                    SpecialColumn_List list = new SpecialColumn_List();
                    list.parseJSon(array.getJSONObject(i));
                    lists.add(list);
                }
        }
    }


    public boolean isHasMore() {
        return hasMore;
    }

    public List<SpecialColumn_List> getLists() {
        return lists;
    }

    public String getTitle() {
        return title;
    }
}
