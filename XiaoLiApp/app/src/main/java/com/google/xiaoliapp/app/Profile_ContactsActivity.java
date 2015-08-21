package com.google.xiaoliapp.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * 页面14 -----我的----通讯录整理
 */
public class Profile_ContactsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile__contacts);
        TextView headTitle = (TextView)findViewById(R.id.common_head_text);
        headTitle.setText("通讯录整理");
        RelativeLayout body = (RelativeLayout)findViewById(R.id.common_body);
        LayoutInflater.from(this).inflate(R.layout.activity_profile__contacts,body);

    }



}
