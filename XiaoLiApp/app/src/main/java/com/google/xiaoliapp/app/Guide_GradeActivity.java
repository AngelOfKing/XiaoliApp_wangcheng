package com.google.xiaoliapp.app;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.xiaoliapp.app.adapters.GradeAdapter;
import com.google.xiaoliapp.app.entities.Grade;

import java.util.*;


public class Guide_GradeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_guide__grade);

        TextView title = (TextView) findViewById(R.id.common_head_text);
        title.setText("阿三");
//        隐藏箭头按钮
        Button back = (Button) findViewById(R.id.common_back);
        back.setVisibility(View.INVISIBLE);
        RelativeLayout body = (RelativeLayout)findViewById(R.id.common_body);
        LayoutInflater.from(this).inflate(R.layout.activity_guide__grade, body);

        ListView listView = (ListView)findViewById(R.id.grade_list_view);
        List<Grade> list = new ArrayList<Grade>();
        Calendar c=Calendar.getInstance();


        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < 6; i++) {
            Grade grade = new Grade();
            grade.setNick("阿杰");
            grade.setScore("8.6分");
            grade.setCai("14");
            grade.setZan("100");
            grade.setDate((month+1)+"月"+day+"天");
            list.add(grade);
        }
        GradeAdapter adapter = new GradeAdapter(this,list);
        listView.setAdapter(adapter);




    }


}
