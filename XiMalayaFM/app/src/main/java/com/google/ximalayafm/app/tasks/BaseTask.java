package com.google.ximalayafm.app.tasks;

import android.os.AsyncTask;
import org.json.JSONException;

/**
 * Created by Administrator on 2015/7/28.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/28
 * Time:12:21
 */


public abstract class BaseTask extends AsyncTask<String,Integer,TaskResult> {

    private  TaskCallback callback;

    public BaseTask(TaskCallback callback) {
        this.callback = callback;
    }

    //uns on the UI thread after doInBackground. The specified result is the value returned by
    @Override
    protected void onPostExecute(TaskResult taskResult) {
        if(callback !=null){
                callback.onFinished(taskResult);
        }
    }


}
