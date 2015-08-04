package com.google.ximalayafm.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.google.ximalayafm.app.fragments.CustomFragment;
import com.google.ximalayafm.app.fragments.DiscoveryFragment;
import com.google.ximalayafm.app.fragments.DownloadTingFragment;
import com.google.ximalayafm.app.fragments.PreferFragment;
import com.google.ximalayafm.app.util.BaseActivity;

/**
 * ������
 */

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private DiscoveryFragment discoveryFragment;
    private CustomFragment customFragment;
    private DownloadTingFragment downloadTingFragment;
    private PreferFragment preferFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);



        //找到主页面下方的RadioGroup的
        RadioGroup tabBar = (RadioGroup) findViewById(R.id.main_bar);
        //设置监听
        tabBar.setOnCheckedChangeListener(this);
        tabBar.setOnClickListener(this);
        //设置默认为： 发现
        tabBar.check(R.id.main_tab_item_discovery);

    }

    //根据radioButton的id,显示出不同的Fragment界面
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = null;
        int index = checkedId;

        switch (index){
            case R.id.main_tab_item_discovery:
                //lazy快捷键
                if( discoveryFragment==null){
                    discoveryFragment = new DiscoveryFragment();
                }

                fragment = discoveryFragment;
                break;
            case R.id.main_tab_item_custom:
                if (customFragment == null) {
                    fragment = new CustomFragment();
                }
                break;
            case R.id.main_bar_item_download:
                if (downloadTingFragment == null) {
                    fragment = new DownloadTingFragment();
                }
                break;
            case R.id.main_bar_item_prefer:
                if (preferFragment == null) {
                    fragment = new PreferFragment();
                }
                break;
        }
        transaction.replace(R.id.main_container,fragment);
        //事务必须提交
        transaction.commit();
    }

    @Override
    protected int getExitAnimationId() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        boolean state = false;
        int id = v.getId();
        switch (id){
            case R.id.main_tab_item_discovery:
                Button btn_discovery = (Button) v.findViewById(R.id.main_tab_item_discovery);
               if(state){
                   btn_discovery.setBackgroundResource(R.drawable.tab1_down);
               }else{
                   btn_discovery.setBackgroundResource(R.drawable.tab1);
               }
                break;
        }
    }
}
