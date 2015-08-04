package com.google.ximalayafm.app.module.json17_album;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2015/8/2.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/2
 * Time:21:30
 */
public class Album {
    private int albumId;

    private int categoryId;

    private String categoryName;

    private String title;

    private String coverOrigin;

    private String coverSmall;

    private String coverLarge;

    private String coverWebLarge;

    private int createdAt;

    private int updatedAt;

    private int uid;

    private String nickname;

    private boolean isVerified;

    private String avatarPath;

    private String intro;

    private String introRich;

    private String tags;

    private int tracks;

    private int shares;

    private boolean hasNew;

    private boolean isFavorite;

    private int playTimes;

    private int status;

    private int serializeStatus;


    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
            albumId = jsonObject.getInt("albumId");
            categoryId = jsonObject.getInt("categoryId");
            title = jsonObject.getString("title");
            coverOrigin = jsonObject.getString("coverOrigin");
            coverSmall = jsonObject.getString("coverSmall");
            coverLarge = jsonObject.getString("coverLarge");
            coverWebLarge = jsonObject.getString("coverWebLarge");
            createdAt = jsonObject.getInt("createdAt");
            updatedAt = jsonObject.getInt("updatedAt");
            uid = jsonObject.getInt("uid");
            nickname = jsonObject.getString("nickname");
            isVerified = jsonObject.getBoolean("isVerified");
            avatarPath = jsonObject.getString("avatarPath");
            intro = jsonObject.getString("intro");
            introRich = jsonObject.getString("introRich");
            tags = jsonObject.getString("tags");
            tracks = jsonObject.getInt("tracks");
            shares = jsonObject.getInt("shares");
            hasNew = jsonObject.getBoolean("hasNew");
            isFavorite = jsonObject.getBoolean("isFavorite");
            playTimes = jsonObject.getInt("playTimes");
            status = jsonObject.getInt("status");
            serializeStatus = jsonObject.getInt("serializeStatus");
        }
    }


}
