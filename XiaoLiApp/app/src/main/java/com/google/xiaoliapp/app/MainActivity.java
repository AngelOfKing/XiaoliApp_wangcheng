package com.google.xiaoliapp.app;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout commonHead = (RelativeLayout)findViewById(R.id.common_head);
       RelativeLayout commonBody = (RelativeLayout) findViewById(R.id.common_body);

        LayoutInflater.from(this).inflate(R.layout.activity_login, commonBody);
        TextView textView = (TextView)commonHead.findViewById(R.id.common_head_text);
        textView.setText("注册账户");
    }



}
