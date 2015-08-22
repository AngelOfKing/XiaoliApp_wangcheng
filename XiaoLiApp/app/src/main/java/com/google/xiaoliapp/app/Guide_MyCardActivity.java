package com.google.xiaoliapp.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.google.xiaoliapp.app.adapters.MycardAdapter;
import com.google.xiaoliapp.app.entities.Guide_Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的卡券页面
 */

public class Guide_MyCardActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_my_card);


        ListView listView = (ListView)findViewById(R.id.my_card_listView);

        List<Guide_Card>  cardList = new ArrayList<Guide_Card>();
        //TODO 添加数据需要动态调整
        for (int i = 0; i < 6; i++) {
            Guide_Card card = new Guide_Card(R.drawable.mycard,
                        "使用限制xxxxxxxx",
                        "使用规则xxxxxxxx",
                        "晓礼网创意婚庆礼品优惠券",
                        "2015-6-15至2015-8-15"
                    );
            cardList.add(card);
        }
        MycardAdapter adapter = new MycardAdapter(cardList,this);
        listView.setAdapter(adapter);
    }


}
