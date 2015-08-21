package com.google.xiaoliapp.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

/**
 * 情礼提醒
 */
public class GiftsWarnActivity extends ActionBarActivity {

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_warn);

//        Intent intent = new Intent(Intent.ACTION_INSERT);
//        intent.setData(CalendarContract.Events.CONTENT_URI);
//        startActivity(intent);

        Intent intent = new Intent(Intent.ACTION_INSERT_OR_EDIT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        startActivity(intent);
    }

}





































