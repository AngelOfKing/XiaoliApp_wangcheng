package com.google.xiaoliapp.app;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TabViewActivity extends Activity {

    private LinearLayout mLayout;
    private LinearLayout mLayoutHidden;

    private int screenWidth;
    float density;
    private Animation expandAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view);

        mLayoutHidden = (LinearLayout)findViewById(R.id.hidden);
        mLayout = (LinearLayout)findViewById(R.id.container);

        /**
         * A structure describing general information about a display, such as its size,
         * density, and font scaling.
         To access the DisplayMetrics members, initialize an object like this:
         */

        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        screenWidth = metric.widthPixels;//屏幕宽度
        density = metric.density;//密度
        screenWidth -= 40 * density;
        String[] skills = getResources().getStringArray(R.array.skill);
        //获取字符串数组
        View view = null;
        for (int i = 0; i < skills.length; i++) {
            view = initView(skills[i]);
            mLayoutHidden.addView(view);//添加view
        }

        expandAnim = AnimationUtils.loadAnimation(this, R.anim.expand);

        new TabTask().execute();
    }
    //初始化布局
    private LinearLayout initLayout() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);//设置方向
        layout.setGravity(Gravity.CENTER_HORIZONTAL);//设置Gravity
        layout.setAnimationCacheEnabled(true);//设置动画
        layout.setLayoutAnimation(new LayoutAnimationController(expandAnim));
        return layout;
    }
    //初始化视图，即使TextView设置文字
    private View initView(String str) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab_view, null);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText(str);
        return view;
    }

    //添加布局
    private void addLayout(List<TextView> items){
        LinearLayout layout = initLayout();
        for (TextView textView : items) {
            layout.addView(initView(textView.getText().toString()));
        }
        mLayout.addView(layout);
    }

    //TODO 点击按钮，添加tabView
    public void btn_addView(View view) {

    }


    class TabTask extends AsyncTask<Void, TextView, Boolean> {

        int lineWidth = 0;
        LinearLayout lineLayout = null;
        List<TextView> items = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            items = new ArrayList<TextView>();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            for (int i = 0; i < mLayoutHidden.getChildCount(); i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                View view = mLayoutHidden.getChildAt(i);
                publishProgress((TextView)view.findViewById(R.id.text));
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(TextView... values) {
            super.onProgressUpdate(values);

            lineWidth += values[0].getWidth() + 20 * density;
            if(lineWidth > screenWidth){
                addLayout(items);
                items.clear();
                items.add(values[0]);
                lineWidth = values[0].getWidth();
            } else {
                items.add(values[0]);
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            addLayout(items);
            mLayoutHidden.removeAllViews();
        }
    }
}
