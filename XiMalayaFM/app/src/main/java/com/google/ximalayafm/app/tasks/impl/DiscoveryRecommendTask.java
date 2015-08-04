package com.google.ximalayafm.app.tasks.impl;

import com.google.ximalayafm.app.Contants;
import com.google.ximalayafm.app.client.ClientDiscoveryAPI;
import com.google.ximalayafm.app.tasks.BaseTask;
import com.google.ximalayafm.app.tasks.TaskCallback;
import com.google.ximalayafm.app.tasks.TaskResult;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by Administrator on 2015/8/2.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/2
 * Time:12:53
 */
public class DiscoveryRecommendTask extends BaseTask {

    public DiscoveryRecommendTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult task = new TaskResult();
        task.taskId = Contants.TASK_DISCOVERY_RECOMMEND;
       String str = ClientDiscoveryAPI.getDiscoveryRecommend();
        if(str!=null){
            try {
                task.data = new JSONObject(str);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return task;
    }
}
