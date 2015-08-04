package com.handmark.pulltorefreshtask.app;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class SlidingMenuTestActivity extends AppCompatActivity implements SlidingMenu.OnOpenedListener, SlidingMenu.OnOpenListener {

    private SlidingMenu menu;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_menu_task);


        menu = new SlidingMenu(this);
        // ���ò˵������,
        menu.setMode(SlidingMenu.LEFT_RIGHT);

        //���Activity���ڶ�������
        //�����ǹ�������һ���Ƴ���SlidingMenu.SLIDING_XXX
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //��attachActivity֮��,��Ӳ˵�
        menu.setMenu(R.layout.menu_main);
        menu.setSecondaryMenu(R.layout.menu_profile);

        menu.setBehindOffset(100);
//        ���ù�����x����ı�����
//        0�������ƶ������ݴ��Ϸ����ߣ�
//        1�˵����������ƶ�
        menu.setBehindScrollScale(1);

//        menu�Ŀ���

        //�˵��Ĵ�֮������¼�
        menu.setOnOpenedListener(this);
        menu.setOnOpenListener(this);//�򿪵�һ���˵�

        menu.setSecondaryOnOpenListner(new SlidingMenu.OnOpenListener() {
            @Override
            public void onOpen() {
                Toast.makeText(SlidingMenuTestActivity.this, "Second", Toast.LENGTH_SHORT).show();
            }
        });

        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

    }




    @Override
    public void onOpened() {
        //TODO �˵���֮��,
        if(menu.isSecondaryMenuShowing()){//SecondaryMenu�ұߵĲ˵���ʾ�Ŵ���
            setTitle("Person");
        }else if (menu.isMenuShowing()){//
            setTitle("Menu");
        }
    }

    @Override
    public void onOpen() {
        Toast.makeText(this,"opened",Toast.LENGTH_SHORT).show();
    }

    public void btn_closeMenu(View view) {
        menu.showContent();
    }
}
