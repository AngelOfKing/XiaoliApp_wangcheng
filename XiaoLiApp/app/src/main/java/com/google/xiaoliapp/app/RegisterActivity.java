package com.google.xiaoliapp.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = (TextView) this.findViewById(R.id.common_head_text);
        textView.setText("账号注册");
        RelativeLayout commonBody = (RelativeLayout) this.findViewById(R.id.common_body);
        LayoutInflater.from(this).inflate(R.layout.activity_register, commonBody);
    }



}
