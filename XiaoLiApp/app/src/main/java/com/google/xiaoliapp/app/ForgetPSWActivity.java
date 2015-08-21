package com.google.xiaoliapp.app;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.xiaoliapp.app.BaseActivity;
import com.google.xiaoliapp.app.R;

public class ForgetPSWActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView headTile = (TextView) this.findViewById(R.id.common_head_text);
        headTile.setText("忘记密码");
        RelativeLayout commonBody = (RelativeLayout) this.findViewById(R.id.common_body);
        LayoutInflater.from(this).inflate(R.layout.activity_forget_psw,commonBody);

    }



}
