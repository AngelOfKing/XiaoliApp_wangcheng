package com.google.ximalayafm.app.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.ximalayafm.app.Contants;
import com.google.ximalayafm.app.R;
import com.google.ximalayafm.app.adapter.CommonFragmentPagerAdapter;
import com.google.ximalayafm.app.fragments.discovery_fragment.*;
import com.google.ximalayafm.app.tasks.impl.DiscoveryTabTask;
import com.google.ximalayafm.app.module.DiscoveryTab;
import com.google.ximalayafm.app.parsers.DataParse;
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
public class DiscoveryFragment extends Fragment implements View.OnClickListener, TabLayout.OnTabSelectedListener, TaskCallback {

    private ViewPager pager;

    //设置上方的Tab,
    private TabLayout tabBar;
    private List<DiscoveryTab>  discoveryTabList;
    private List<Fragment> subFragments;

    public DiscoveryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        discoveryTabList = new ArrayList<DiscoveryTab>();

        subFragments = new ArrayList<Fragment>();
    }


    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_discovery, container, false);

       View btnSearch = ret.findViewById(R.id.discovery_title_search);
        if(btnSearch!=null){
            btnSearch.setOnClickListener(this);
        }

        //从布局文件中获取tab
        tabBar = (TabLayout) ret.findViewById(R.id.discover_tab_bar);

        //TabBar的数据从网络获取
         tabBar.setOnTabSelectedListener(this);
        ///////////////////////////////
        //获取View pager
        pager = (ViewPager) ret.findViewById(R.id.discover_pager);
        //TabLayout+viewPager
        //设置adapter

        //TODO 由于Tab动态设置的，所以ViewPager Adapter 也需要动态设置
        //viewPager在滑动页面的时候来添加监听器，
        //监听由TabLayoutOnPageChangeListener()从而实现ViewPager滚动，上面的
        //TabLayout跟随滚动Tab
        pager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabBar));


        //来加载tabs
        DiscoveryTabTask task = new DiscoveryTabTask(this);
        //开启获取发现界面上方的5个tab
        task.execute();
        return ret;
    }


    @Override
    public void onClick(View v) {

    }

    //选中tab
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        pager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        //TODO 进行刷新
    }
////////////////////////////////////////


    @Override
    public void onFinished(TaskResult taskResult)  {
        if(taskResult!=null){
            int ta = taskResult.taskId;
            Object data = taskResult.data;
            if(ta == Contants.TASK_DISCOVERY_TABS)
            {
                if(data !=null&&data instanceof JSONObject){
                    //解析json

                        JSONObject jsonObject = (JSONObject)data;
                    try {
                        discoveryTabList = DataParse.parseDiscoveryTabResult(jsonObject);
                        updateTabs();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    // TODO 其他操作
                }
            }
        }
    }


    private  void updateTabs(){
        if(discoveryTabList!=null){
            for (DiscoveryTab tabTitle : discoveryTabList) {
                TabLayout.Tab tab = tabBar.newTab();
                tab.setText(tabTitle.getTitle());
                tabBar.addTab(tab);

                //根据内容类型，来设置指定的Fragment
                String type = tabTitle.getContentType();
                if("recommend".equals(type)){
                    subFragments.add(new DiscoveryRecommendFragment());
                }else if("category".equals(type)){
                    subFragments.add(new DiscoveryCategoryFragment());
                }else if("live".equals(type)){
                    subFragments.add(new DiscoveryLiveFragment());
                }else if("raking".equals(type)){
                    subFragments.add(new DiscoveryRakingFragment());
                }else if("anchor".equals(type)){
                    subFragments.add(new DiscoveryAnchorFragment());
                }
            }
        }

        CommonFragmentPagerAdapter adapter =
                new CommonFragmentPagerAdapter(
                        getChildFragmentManager(),
                        subFragments);
        pager.setAdapter(adapter);

    }



}
