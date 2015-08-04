package com.google.ximalayafm.app.tasks.impl;

import com.google.ximalayafm.app.Contants;
import com.google.ximalayafm.app.client.ClientDiscoveryAPI;
import com.google.ximalayafm.app.tasks.BaseTask;
import com.google.ximalayafm.app.tasks.TaskCallback;
import com.google.ximalayafm.app.tasks.TaskResult;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Administrator on 2015/7/28.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/28
 * Time:16:37
 */

public class CategoryMenuTask extends BaseTask{

    public CategoryMenuTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        //////////////

        TaskResult ret = new TaskResult();
        ret.taskId = Contants.TASK_CATOGERY_MENU;

        String type = null;
        if(params != null&& params.length>0 ){
            type=params[0];
        }
        try {
            String jsonStr = ClientDiscoveryAPI.getCategoryMenu(type);
            if(jsonStr != null){
                JSONObject object = new JSONObject(jsonStr);
                 ret.data = object;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        return ret;
    }
}
