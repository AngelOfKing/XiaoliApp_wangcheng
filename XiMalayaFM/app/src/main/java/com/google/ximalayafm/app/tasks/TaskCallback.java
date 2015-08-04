package com.google.ximalayafm.app.tasks;

/**
 * Created by Administrator on 2015/7/28.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/28
 * Time:12:28
 */



/**
 * TaskCallback 异步任务执行成功之后，由 onPostExecute 来回调
 */
public interface TaskCallback {

   void onFinished(TaskResult taskResult) ;
}
