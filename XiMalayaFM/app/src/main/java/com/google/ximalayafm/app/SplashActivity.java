package com.google.ximalayafm.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Window;
import com.google.ximalayafm.app.tasks.impl.CategoryMenuTask;
import com.google.ximalayafm.app.module.CategoryTagMenu;
import com.google.ximalayafm.app.parsers.DataParse;
import com.google.ximalayafm.app.tasks.TaskCallback;
import com.google.ximalayafm.app.tasks.TaskResult;
import com.google.ximalayafm.app.util.MyUncaughtExceptionHandler;
import com.google.ximalayafm.app.util.PackageUtiles;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;




public class SplashActivity extends FragmentActivity implements TaskCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //清除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //启动扉页

        CategoryMenuTask task = new CategoryMenuTask(this);
        task.execute();

    }

    @Override
    public void onFinished(TaskResult taskResult)  {
        if(taskResult !=null){
            int taskId = taskResult.taskId;
            Object data = taskResult.data;
            if(taskId == Contants.TASK_CATOGERY_MENU){
                if(data!=null){
                    if(data instanceof JSONObject){
                        JSONObject json = (JSONObject)data;
                        try {
                            List<CategoryTagMenu> categoryTagMenus=
                                    DataParse.parseCategoryResultMenu(json);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // TODO 存储CategoryTagMenu
                    }
                }

                SharedPreferences sp = getSharedPreferences(Contants.SP_NAME, MODE_PRIVATE);

                String lastVer = sp.getString(Contants.SP_KEY_GUIDE_LAST_SHOW_VER, null);

                String versionName = PackageUtiles.getPackageVersionName(this);
                Intent intent = null;

                if(!versionName.equals(lastVer)){
                    //TODO 显示教程
                    intent = new Intent(this,GuideActivity.class);
                }else {
                    //TODO 显示主界面
                    intent = new Intent(this,MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }
    }
}
