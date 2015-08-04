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
        // 设置菜单在左侧,
        menu.setMode(SlidingMenu.LEFT_RIGHT);

        //添加Activity，第二个参数
        //代表是够连标题一起推出，SlidingMenu.SLIDING_XXX
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //当attachActivity之后,添加菜单
        menu.setMenu(R.layout.menu_main);
        menu.setSecondaryMenu(R.layout.menu_profile);

        menu.setBehindOffset(100);
//        设置滚动的x坐标的倍数；
//        0不进行移动，内容从上方移走，
//        1菜单跟随内容移动
        menu.setBehindScrollScale(1);

//        menu的控制

        //菜单的打开之后监听事件
        menu.setOnOpenedListener(this);
        menu.setOnOpenListener(this);//打开第一个菜单

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
        //TODO 菜单打开之后,
        if(menu.isSecondaryMenuShowing()){//SecondaryMenu右边的菜单显示才触发
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
