package com.google.ximalayafm.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;


public class PlayActivity extends ActionBarActivity {

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setMax(100);

        RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = ratingBar.getOnRatingBarChangeListener();
    }



}
