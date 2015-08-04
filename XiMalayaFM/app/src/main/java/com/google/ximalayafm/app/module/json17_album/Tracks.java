package com.google.ximalayafm.app.module.json17_album;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/2.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/2
 * Time:16:28
 */


public class Tracks {
    private List<Track> list;

    private int pageId;
    private int pageSize;
    private int maxPageId;
    private int totalCount;

    public List<Track> getList() {
        return list;
    }

    public int getMaxPageId() {
        return maxPageId;
    }

    public int getPageId() {
        return pageId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void parseJSON(JSONObject json) throws JSONException {
        if(json!=null){
            pageId = json.getInt("pageId");
            pageSize = json.getInt("pageSize");
            maxPageId = json.getInt("maxPageId");
            totalCount = json.getInt("totalCount");

            JSONArray data = json.getJSONArray("list");
           list = new ArrayList<Track>();
            if(data!=null){
                for (int i = 0; i < data.length(); i++) {
                   Track track = new Track();
                    track.parseJSON(data.getJSONObject(i));
                    list.add(track);
                }
            }
        }
    }

}
