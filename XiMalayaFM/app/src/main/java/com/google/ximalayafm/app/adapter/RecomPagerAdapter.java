package com.google.ximalayafm.app.adapter;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/30.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/30
 * Time:17:43
 */
public class RecomPagerAdapter extends PagerAdapter {
    List<Bitmap> list = new ArrayList<Bitmap>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
