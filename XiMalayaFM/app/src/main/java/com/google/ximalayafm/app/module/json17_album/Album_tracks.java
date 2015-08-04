package com.google.ximalayafm.app.module.json17_album;

import com.google.ximalayafm.app.util.MyLog;
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
 * Time:23:30
 */
public class Album_tracks {
    private List<Album> albumList;
    private List<Tracks>  tracksList;

    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if(jsonObject!=null){
            JSONArray albumArray = jsonObject.getJSONArray("album");
            if(albumArray!=null){
                albumList = new ArrayList<Album>();
                MyLog.d("======ALbum_tracks","  "+albumList);
                for (int i = 0; i < albumArray.length(); i++) {
                    Album album = new Album();
                    album.parseJSON(albumArray.getJSONObject(i));
                    albumList.add(album);
                }
            }
            JSONArray tracksArray = jsonObject.getJSONArray("tracks");
            if(tracksArray!=null){
                tracksList = new ArrayList<Tracks>();
                for (int i = 0; i < tracksArray.length(); i++) {
                    Tracks tracks = new Tracks();
                    tracks.parseJSON(tracksArray.getJSONObject(i));
                    tracksList.add(tracks);
                    MyLog.d("====Album_tracks"," "+tracks);
                }

            }

        }

    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public List<Tracks> getTracksList() {
        return tracksList;
    }
}
