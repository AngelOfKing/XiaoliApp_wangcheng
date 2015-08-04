package com.google.ximalayafm.app.fragments.discovery_fragment;


import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.ximalayafm.app.Contants;
import com.google.ximalayafm.app.R;
import com.google.ximalayafm.app.data.DataStore;
import com.google.ximalayafm.app.module.DiscoveryCategory;
import com.google.ximalayafm.app.parsers.DataParse;
import com.google.ximalayafm.app.tasks.impl.DiscoveryCategoryTask;
import com.google.ximalayafm.app.tasks.TaskCallback;
import com.google.ximalayafm.app.tasks.TaskResult;
import com.google.ximalayafm.app.util.MyLog;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * 分类
 */
public class DiscoveryCategoryFragment extends Fragment implements TaskCallback {
    private static final String TAG = "tag";

    public DiscoveryCategoryFragment() {
        // Required empty public constructor
    }

    //用来加载数据
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //1.判断有没有分类
        List<DiscoveryCategory> categoryList = new ArrayList<DiscoveryCategory>();
        if(categoryList!=null&&!categoryList.isEmpty()){
            MyLog.d(TAG, "Discover category has.");

        }else {
            //无分类
            MyLog.d(TAG, "Discover category need request!");
            DiscoveryCategoryTask task =
                    new DiscoveryCategoryTask(this);
            task.execute();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discovery_category, container, false);
    }


    @Override
    public void onFinished(TaskResult taskResult)  {
        if(taskResult!=null){
            int taskId = taskResult.taskId;
            Object data = taskResult.data;
            if(taskId== Contants.TASK_DISCOVERY_CATEGORY){
                if(data!=null){
                    if(data instanceof JSONObject){
                        List<DiscoveryCategory> categories = DataParse. parseDiscoveryCategoryResult((JSONObject)data);
                        if(categories!=null){
                            DataStore.getInstance().setDiscoveryCategories(categories);

                            //TODO 利用分类更新UI
                        }
                    }
                }
            }
        }
    }
}
