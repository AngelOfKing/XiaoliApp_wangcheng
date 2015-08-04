package com.google.ximalayafm.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.google.ximalayafm.app.adapter.GuideAdapter;
import com.google.ximalayafm.app.util.PackageUtiles;

import java.util.ArrayList;
import java.util.List;


/**
 * �̳�ҳ
 */
public class GuideActivity extends FragmentActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //�̳�ҳҲ����Ҫ����
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_guide);

        ViewPager viewPager =(ViewPager) findViewById(R.id.guide_view_pager);
        List<Integer> images = new ArrayList<Integer>();
        if(viewPager!=null){
            for(int i=0;i<4;i++){
                images.add(R.mipmap.ic_launcher);
            }
            GuideAdapter adapter = new GuideAdapter(this,images);
            adapter.setGoOnClickListener(this);
            viewPager.setAdapter(adapter);
        }

        SharedPreferences sp = getSharedPreferences(Contants.SP_NAME, MODE_PRIVATE);
        String versionName = PackageUtiles.getPackageVersionName(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Contants.SP_KEY_GUIDE_LAST_SHOW_VER,versionName);
        editor.commit();

    }



    @Override
    public void onClick(View v) {
       startMain();
    }

    public void startMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        startMain();
    }
}
