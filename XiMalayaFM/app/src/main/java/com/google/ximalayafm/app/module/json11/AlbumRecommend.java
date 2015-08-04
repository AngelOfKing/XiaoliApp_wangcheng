package com.google.ximalayafm.app.module.json11;

import org.json.JSONException;
import org.json.JSONObject;


public class AlbumRecommend {

    private int albumId;

    private String coverLarge;

    private String title;

    private String tags;

    private int tracks;

    private int playsCounts;

    private int isFinished;

    private int trackId;

    private String trackTitle;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {
            albumId = json.getInt("albumId");
            coverLarge = json.getString("coverLarge");
            title = json.getString("title");
            tags = json.getString("tags");
            tracks = json.getInt("tracks");
            playsCounts = json.getInt("playsCounts");
            isFinished = json.getInt("isFinished");
            trackId = json.getInt("trackId");
            trackTitle = json.getString("trackTitle");
        }
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public int getPlaysCounts() {
        return playsCounts;
    }

    public String getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public int getTrackId() {
        return trackId;
    }

    public int getTracks() {
        return tracks;
    }

    public String getTrackTitle() {
        return trackTitle;
    }
}
