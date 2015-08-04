package com.google.ximalayafm.app.fragments.discovery_fragment;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import com.google.ximalayafm.app.Contants;
import com.google.ximalayafm.app.PlaylistActivity;
import com.google.ximalayafm.app.R;
import com.google.ximalayafm.app.adapter.DiscoverRecommendAdapter;
import com.google.ximalayafm.app.module.DiscoverRecommend;
import com.google.ximalayafm.app.parsers.DataParse;
import com.google.ximalayafm.app.tasks.impl.DiscoveryRecommendTask;
import com.google.ximalayafm.app.tasks.TaskCallback;
import com.google.ximalayafm.app.tasks.TaskResult;
import com.google.ximalayafm.app.util.MyLog;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryRecommendFragment extends Fragment implements TaskCallback, View.OnClickListener {


//    private ListView listView;
    private DiscoverRecommendAdapter adapter;
    private PullToRefreshListView listView;

    public DiscoveryRecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_discovery_recommend, container, false);

//        listView = (ListView) ret.findViewById(R.id.list);
//        if(listView !=null){
//            //TODO 设置实际数据的Adapter
//            adapter = new DiscoverRecommendAdapter(getActivity());
//
//            //adapter设置点击事件
//            adapter.setOnClickListener(this);
//
//            listView.setAdapter(adapter);
//        }


        listView = (PullToRefreshListView) ret.findViewById(R.id.list);
        if(listView !=null){
            adapter = new DiscoverRecommendAdapter(getActivity());
            adapter.setOnClickListener(this);
            listView.setAdapter(adapter);

            listView.setMode(PullToRefreshBase.Mode.BOTH);
            //取其内部的ListView
            ListView refreshableView = listView.getRefreshableView();
            refreshableView.setDivider(new ColorDrawable(0xff999999));
            refreshableView.setDividerHeight(5);
        }

        return ret;
    }


    @Override
    public void onResume() {
        super.onResume();

        //开启异步任务：
        DiscoveryRecommendTask task = new DiscoveryRecommendTask(this);

        task.execute();
    }

    @Override
    public void onFinished(TaskResult taskResult) {
       {
            if(taskResult!=null){
                int taskId = taskResult.taskId;
                Object data = taskResult.data;
                if(taskId== Contants.TASK_DISCOVERY_RECOMMEND){
                    if(data!=null){
                        if(data instanceof JSONObject){
                            JSONObject json = (JSONObject) data;
                            //解析DiscoveryRecommend
                            DiscoverRecommend discoverRecommend = DataParse.parseJSON(json);
                            MyLog.d("+++++++++",discoverRecommend.toString());
                            adapter.setRecommend(discoverRecommend);
                        }
                    }
                }

            }
        }
    }


    /**
     * 要判断点击的是：更多 -or 图片按钮
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Object tag = v.getTag();
        //进入到更多界面
        if (id == R.id.item_recommend_album_more) {
            String s = (String) tag;
            if ("editor".equals(tag)) {
                Toast.makeText(getActivity(), "小编推荐", Toast.LENGTH_SHORT).show();
            } else if (s.startsWith("hotRecommend")) {

                //TODO 热门推荐的更多
                int index = s.indexOf(":");
                s = s.substring(index + 1);
                int cid = Integer.parseInt(s);

                Toast.makeText(getActivity(), "更多id="+cid, Toast.LENGTH_SHORT).show();
            }
        } else if (v instanceof ImageView) {
            //TODO 8.1 如果是图片，相当于点击了专辑，跳转到专辑列表
            if (tag != null) {
                if (tag instanceof String[]) {
                    String[] ss = (String[]) tag;
                    if (ss.length>2) {
                        String albumId = ss[1];
                        String trackId = ss[2];
                        Intent intent =
                                new Intent(getActivity(), PlaylistActivity.class);

                        startActivity(intent);

                        //打开新界面，调用接口 20
                        Toast.makeText(getActivity(),
                                "图片albumId="+albumId+"--trackId="+trackId, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
