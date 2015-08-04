package com.handmark.pulltorefreshtask.app;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SwipeRefreshActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener,Runnable {
    private  SwipeRefreshLayout swipeRefreshLayout;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        swipeRefreshLayout= (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                int what = msg.what;
                switch (what){
                    case 998:
                        swipeRefreshLayout.setRefreshing(false);
                }

            }
        };



        //1.设置颜色指示器的颜色切换信息
        swipeRefreshLayout.setColorSchemeResources(R.color.red, R.color.green, R.color.blue);
        //2设置下拉刷新监听事件
        swipeRefreshLayout.setOnRefreshListener(this);

        //3.设置拉伸强度
        swipeRefreshLayout.setDistanceToTriggerSync(50);
        //4.修改圆形背景
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.YELLOW);

        //5.设置圆圈出厂大小，最终还是回归到默认
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
        //6.设置最终加载指示器的位置，
        swipeRefreshLayout.setProgressViewEndTarget(false,100);


        AdapterView listView = (AdapterView) findViewById(R.id.swipe_refresh_layout_list);

        List<String> lists =  new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            lists.add("java---"+i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lists);
        listView.setAdapter(adapter);


    }


    @Override
    public void onRefresh() {
        //TODO 联网，然后刷新数据，刷新之后关闭刷新动画
        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message msg = new Message();
        msg.what = 998;
        handler.sendMessage(msg);

    }
}
