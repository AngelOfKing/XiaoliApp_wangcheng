package com.google.xiaoliapp.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.xiaoliapp.app.adapters.ImpressAdapter;
import com.google.xiaoliapp.app.entities.Impress;
import java.util.ArrayList;
import java.util.List;


public class Guide_ImpressActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private List<Impress> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_impress);


        recyclerView = (RecyclerView) findViewById(R.id.impress_recycleView);

        initDatas();
        ImpressAdapter adapter = new ImpressAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    public void initDatas(){
        list = new ArrayList<Impress>();
        for (int i = 0; i < 3; i++) {
            Impress impress = new Impress();
            impress.setCai("27");
            impress.setZan("36");
            impress.setDate("6-7");
            impress.setNick("大寻求");
        }
    }





}
