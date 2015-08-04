package com.google.ximalayafm.app.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.ximalayafm.app.R;

import java.util.List;

/**
 * Created by Administrator on 2015/7/29.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/29
 * Time:10:49
 */


/**
 * ViewPager��������
 */
public class GuideAdapter extends PagerAdapter {
    private List<Integer> images;
    private Context context;
    private View.OnClickListener goOnClickListener;

    public void setGoOnClickListener(View.OnClickListener goOnClickListener) {
        this.goOnClickListener = goOnClickListener;
    }

    public GuideAdapter(Context context, List<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view ==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View ret = null;
        Integer resId = images.get(position);
        if(position==images.size()-1){

            FrameLayout frameLayout = new FrameLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(resId);
            ViewGroup.LayoutParams lp1 =
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                            );
            imageView.setLayoutParams(lp1);
            frameLayout.addView(imageView);

            Button btnGo = new Button(context);
            btnGo.setText(R.string.guide_start_main);
            FrameLayout.LayoutParams lp2 =
                    new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            //ָ��button��λ��
                            Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM
            );


            lp2.bottomMargin = 80;

            btnGo.setLayoutParams(lp2);
            btnGo.setOnClickListener(goOnClickListener);
            frameLayout.addView(btnGo);
            //���봴����button��û��ID�ģ�ͨ��tag���Խ��а�ť������
            btnGo.setTag("GO");
            ret = frameLayout;
        }else{

            ImageView imageView = new ImageView(context);
            imageView.setImageResource(resId);
            ret = imageView;

        }
        container.addView(ret);

        return ret;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       if(object instanceof View){
           container.removeView((View)object);
       }
    }
}
