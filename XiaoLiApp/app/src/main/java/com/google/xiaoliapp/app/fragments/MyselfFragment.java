package com.google.xiaoliapp.app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.google.xiaoliapp.app.MainActivity;
import com.google.xiaoliapp.app.R;
import com.google.xiaoliapp.app.adapters.MyselfAdapter;
import com.google.xiaoliapp.app.entities.Myself;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyselfFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    public MyselfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myself, container, false);
        ListView listView = (ListView)view.findViewById(R.id.myself_listView);
        List<Myself> list = new ArrayList<Myself>();

            Myself myself01 = new Myself();
            myself01.setImageId(R.drawable.photo);
            myself01.setName("阿妹");
             list.add(myself01);
        Myself myself02 = new Myself();
        myself02.setImageId(R.drawable.myself01);
        myself02.setName("打分记录");
             list.add(myself02);
        Myself myself03 = new Myself();
        myself03.setImageId(R.drawable.myself02);
        myself03.setName("印象记录");
        list.add(myself03);
        Myself myself04 = new Myself();
        myself04.setImageId(R.drawable.myself03);
        myself04.setName("我的故事");
        Myself myself05 = new Myself();
        myself05.setImageId(R.drawable.myself04);
        myself05.setName("我的收藏");
        list.add(myself02);
        Myself myself06 = new Myself();
        myself06.setImageId(R.drawable.myself05);
        myself06.setName("草稿箱");
        list.add(myself06);
        Myself myself07 = new Myself();
        myself07.setImageId(R.drawable.myself06);
        myself07.setName("设置");
        list.add(myself07);

        MyselfAdapter adapter = new MyselfAdapter(getActivity(),list);
        listView.setAdapter(adapter);
        listView.setOnItemSelectedListener(this);
        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
