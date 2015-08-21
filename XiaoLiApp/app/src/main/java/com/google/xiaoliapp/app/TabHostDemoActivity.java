package com.google.xiaoliapp.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;


public class TabHostDemoActivity extends ActionBarActivity {
    private ListView listView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_demo);

        TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);
        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

        //这里content的设置采用布局文件中的view
//        setIndicator(tab的名字)
//        setContent(内容的id，可以是布局或者视图)
//        tabHost.newTabSpec("")
        tabHost.addTab(tabHost.newTabSpec("第一季").setIndicator("第一季",getResources().getDrawable(R.drawable.photo)).
                setContent(R.id.view1));

        tabHost.addTab(tabHost.newTabSpec("第二季").setIndicator("第二季")
                .setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("第三季").setIndicator("tab3")
                .setContent(R.id.view3));

        listView = (ListView)findViewById(R.id.list_view);
        list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("java------"+i);
        }
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                list);
        listView.setAdapter(adapter);


        tabHost.addTab(tabHost.newTabSpec("listView").
                setIndicator("列表视图").
                setContent(R.id.list_view));




    }



}
