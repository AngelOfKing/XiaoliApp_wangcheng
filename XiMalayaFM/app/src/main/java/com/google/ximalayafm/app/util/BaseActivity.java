package com.google.ximalayafm.app.util;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.google.ximalayafm.app.R;

/**
 * Created by Administrator on 2015/7/30.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/30
 * Time:10:39
 */


/**
 * 基础的Activity
 */


public class BaseActivity extends FragmentActivity {

    private TextView txtTitle;

    /**
     * 获取startActivity之后，新的Activity进入的动画<br/>
     * 默认从右往左，如果需要定制动画，重写即可
     * @return
     */

    //protected只有子类能够使用
    protected int getEnterAnimationId(){
        return R.anim.anim_slide_to_left;
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        //TODO 进行公共的一些控件的内容初始化

        //只要调用了super.setContentView就可以findViewById
        txtTitle = (TextView) findViewById(R.id.title);
    }

    /**
     * Activity设置标题的方法
     * @param title
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        if(title!=null){
            txtTitle.setText(title);
        }
    }

    /**
     * 启动activity，并且指定动画
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(getEnterAnimationId(),0);
    }


    protected int getExitAnimationId(){
        return R.anim.anim_down;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,getExitAnimationId());
    }


}
