package com.google.ximalayafm.app.module.json17_album;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2015/8/2.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/2
 * Time:21:34
 */
public class Track {
    private int trackId;

    private int uid;

    private String playUrl64;

    private String playUrl32;

    private String downloadUrl;

    private String playPathAacv164;

    private String playPathAacv224;

    private String downloadAacUrl;

    private String title;

    private double duration;

    private int processState;

    private int createdAt;

    private String coverSmall;

    private String coverLarge;

    private String nickname;

    private String smallLogo;

    private int userSource;

    private int albumId;

    private String albumTitle;

    private String albumImage;

    private int orderNum;

    private int opType;

    private boolean isPublic;

    private int likes;

    private int playtimes;

    private int comments;

    private int shares;

    private int status;

    private int downloadSize;

    private int downloadAacSize;

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public int getComments() {
        return comments;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public int getDownloadAacSize() {
        return downloadAacSize;
    }

    public String getDownloadAacUrl() {
        return downloadAacUrl;
    }

    public int getDownloadSize() {
        return downloadSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getDuration() {
        return duration;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public int getLikes() {
        return likes;
    }

    public String getNickname() {
        return nickname;
    }

    public int getOpType() {
        return opType;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getPlayPathAacv164() {
        return playPathAacv164;
    }

    public String getPlayPathAacv224() {
        return playPathAacv224;
    }

    public int getPlaytimes() {
        return playtimes;
    }

    public String getPlayUrl32() {
        return playUrl32;
    }

    public String getPlayUrl64() {
        return playUrl64;
    }

    public int getProcessState() {
        return processState;
    }

    public int getShares() {
        return shares;
    }

    public String getSmallLogo() {
        return smallLogo;
    }

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public int getTrackId() {
        return trackId;
    }

    public int getUid() {
        return uid;
    }

    public int getUserSource() {
        return userSource;
    }

    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
            trackId = jsonObject.getInt("trackId");
            uid = jsonObject.getInt("uid");
            playUrl64 = jsonObject.getString("playUrl64");
            playUrl32 = jsonObject.getString("playUrl32");
            downloadUrl = jsonObject.getString("downloadUrl");
            playPathAacv164 = jsonObject.getString("playPathAacv164");
            playPathAacv224 = jsonObject.getString("playPathAacv224");
            downloadAacUrl = jsonObject.getString("downloadAacUrl");
            title = jsonObject.getString("title");
            duration = jsonObject.getDouble("duration");
            processState = jsonObject.getInt("processState");
            createdAt = jsonObject.getInt("createdAt");
            coverSmall = jsonObject.getString("coverSmall");
            coverLarge = jsonObject.getString("coverLarge");
            nickname = jsonObject.getString("nickname");
            smallLogo = jsonObject.getString("smallLogo");
            userSource = jsonObject.getInt("userSource");
            albumId = jsonObject.getInt("albumId");
            albumTitle = jsonObject.getString("albumTitle");
            albumImage = jsonObject.getString("albumImage");
            orderNum = jsonObject.getInt("orderNum");
            opType = jsonObject.getInt("opType");
            isPublic = jsonObject.getBoolean("isPublic");
            likes = jsonObject.getInt("likes");
            playtimes = jsonObject.getInt("playtimes");
            comments = jsonObject.getInt("comments");
            shares = jsonObject.getInt("shares");
            status = jsonObject.getInt("status");
            downloadSize = jsonObject.getInt("downloadSize");
            downloadAacSize = jsonObject.getInt("downloadAacSize");

        }
    }


}
