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
 * Created by Administrator on 2015/7/29.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/29
 * Time:20:36
 */

/**
 * 发现部分分类获取的任务
 */
public class DiscoveryCategoryTask extends BaseTask {

    private TaskResult ret;

    public DiscoveryCategoryTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {

        ret = new TaskResult();
        ret.taskId = Contants.TASK_DISCOVERY_CATEGORY;
        //调用API
        try {
            String str = ClientDiscoveryAPI.getDiscoveryCategory();
            ret.data = new JSONObject(str);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
