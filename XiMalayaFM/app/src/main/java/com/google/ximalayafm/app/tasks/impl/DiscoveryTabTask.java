package com.google.ximalayafm.app.tasks.impl;

import com.google.ximalayafm.app.Contants;
import com.google.ximalayafm.app.client.ClientDiscoveryAPI;
import com.google.ximalayafm.app.tasks.BaseTask;
import com.google.ximalayafm.app.tasks.TaskCallback;
import com.google.ximalayafm.app.tasks.TaskResult;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2015/7/29.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/29
 * Time:17:06
 */
public class DiscoveryTabTask extends BaseTask {

    public DiscoveryTabTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret = new TaskResult();
        ret.taskId = Contants.TASK_DISCOVERY_TABS;
        String str = ClientDiscoveryAPI.getDiscoveryTabs();

        if(str!=null){
            try {
                ret.data = new JSONObject(str);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
