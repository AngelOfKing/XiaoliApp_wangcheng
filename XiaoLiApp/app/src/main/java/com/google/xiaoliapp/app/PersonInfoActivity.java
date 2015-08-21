package com.google.xiaoliapp.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import junit.framework.Test;

/**
 * 页面32----我的个人信息
 */
public class PersonInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout body = (RelativeLayout) this.findViewById(R.id.common_body);
        TextView view = (TextView)this.findViewById(R.id.common_head_text);
        view.setText("个人信息");
        LayoutInflater.from(this).inflate(R.layout.activity_person_info,body);
    }


}
