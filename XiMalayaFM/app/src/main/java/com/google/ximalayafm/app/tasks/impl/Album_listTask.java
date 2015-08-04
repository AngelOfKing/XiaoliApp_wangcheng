package com.google.ximalayafm.app.tasks.impl;

import com.google.ximalayafm.app.Contants;
import com.google.ximalayafm.app.client.ClientDiscoveryAPI;
import com.google.ximalayafm.app.tasks.BaseTask;
import com.google.ximalayafm.app.tasks.TaskCallback;
import com.google.ximalayafm.app.tasks.TaskResult;
import com.google.ximalayafm.app.util.MyLog;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2015/8/2.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/2
 * Time:23:54
 */
public class Album_listTask extends BaseTask {
    public Album_listTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
       TaskResult result = new TaskResult();
        result.data = Contants.TASK_DISCOVERY_RECOMMEND_ALBUM;
        //get the JSONString
        String album_tracks = ClientDiscoveryAPI.getAlbum_tracksString();
        MyLog.d("--------","taa"+ album_tracks);
        if(album_tracks!=null){
            try {
                result.data = new JSONObject(album_tracks);
                MyLog.d("Album_list",result.data.toString());
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
