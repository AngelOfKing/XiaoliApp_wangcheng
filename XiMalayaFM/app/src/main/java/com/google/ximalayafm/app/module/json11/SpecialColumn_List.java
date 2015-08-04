package com.google.ximalayafm.app.module.json11;

/**
 * Created by Administrator on 2015/7/30.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/30
 * Time:17:06
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 "columnType": 1,
 "specialId": 348,
 "title": "5个如雷贯耳的脱口秀，高智商必听！",
 "subtitle": "人生不应该只有眼前的苟且，还有诗和远方！\r\n生活从来就不应该只有简单的吃饭穿衣，安身立命，人生除了温饱，还应该有另一个精神的高度，最终决定这个高度的，一定是眼界和见识，以及你碰到一个什么样的人生导师",
 "footnote": "5张专辑",
 "coverPath": "http://fdfs.xmcdn.com/group14/M04/4E/68/wKgDY1WyIl_jgde2AAG79hZ3Ml4209_mobile_small.jpg",
 "contentType": "1"
 */
public class SpecialColumn_List {
    private int columnType;
    private int specialId;
    private String title;
    private String subtitle;
    private String footnote;
    private String coverPath;
    private int contentType;


    public void parseJSon(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
             columnType = jsonObject.getInt("columnType");
          specialId = jsonObject.getInt("specialId");
           title = jsonObject.getString("title");
             subtitle = jsonObject.getString("subtitle");
             footnote = jsonObject.getString("footnote");
             coverPath = jsonObject.getString("coverPath");
            contentType = jsonObject.getInt("contentType");
        }
    }


    public int getContentType() {
        return contentType;
    }

    public int getColumnType() {
        return columnType;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public String getFootnote() {
        return footnote;
    }

    public int getSpecialId() {
        return specialId;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }
}
