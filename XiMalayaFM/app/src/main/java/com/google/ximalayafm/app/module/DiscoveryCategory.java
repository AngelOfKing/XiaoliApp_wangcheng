package com.google.ximalayafm.app.module;

/**
 * Created by Administrator on 2015/7/29.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/29
 * Time:20:13
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 发现的大分类
 *  "id": 24,
 "name": "youxi",
 "title": "游戏",
 "isChecked": false,
 "orderNum": 23,
 "coverPath": "http://fdfs.xmcdn.com/group10/M04/17/CD/wKgDZ1VxNaKiXC6uAAAIGURQCD0776.png",
 "selectedSwitch": false,
 "isFinished": false,
 "contentType": "album"
 */
public class DiscoveryCategory implements Comparable<DiscoveryCategory> {
    private int id;
    private String name;
    private String title;
    private boolean checked;
    private int orderNum;
    private String coverPath;
    private boolean selectedSwitch;
    private boolean finished;
    private String contentType;


    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
            id = jsonObject.getInt("id");
            name = jsonObject.optString("name");
            title = jsonObject.getString("title");
            checked = jsonObject.optBoolean("isChecked");
            orderNum = jsonObject.getInt("orderNum");
            coverPath = jsonObject.getString("coverPath");
            selectedSwitch = jsonObject.optBoolean("selectedSwitch");
            finished = jsonObject.optBoolean("isFinished");
            contentType = jsonObject.getString("contentType");
        }
    }


    public boolean isChecked() {
        return checked;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public String getContentType() {
        return contentType;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getId() {
        return id;
    }

    public boolean isSelectedSwitch() {
        return selectedSwitch;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(DiscoveryCategory another) {
        int ret = 0;
        if(another!=null){
           ret =  orderNum -another.orderNum;
        }

        return ret;
    }
}
