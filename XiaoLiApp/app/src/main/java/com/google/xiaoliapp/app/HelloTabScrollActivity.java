package com.google.xiaoliapp.app;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;


public class HelloTabScrollActivity extends Activity implements TabHost.TabContentFactory {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_scroll);

        /** Call setup() before adding tabs if loading TabHost
         * using findViewById().
         * However: You do not need to call setup() after getTabHost() in TabActivity.
         * Example:
         mTabHost = (TabHost)findViewById(R.id.tabhost);
         mTabHost.setup();
         mTabHost.addTab(TAB_TAG_1, "Hello, world!", "Tab 1");

         TabActivity在
         */

//        TabActivity

        //从布局中获取TabHost并建立
        TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);
        tabHost.setup();//

        for (int i = 0; i <= 30; i++) {
            String name = "Tab" + i;
            //添加Tab
            //Get a new TabHost.TabSpec associated with this tab host.
            tabHost.addTab(tabHost.newTabSpec(name).
                    setIndicator(name).
                    setContent(this));
//   Specify a TabHost.TabContentFactory to use to create the content of the tab.
        }

    }


































    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_host_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public View createTabContent(String tag) {
        final TextView textView = new TextView(this);
        textView.setText("Content for tab with tag" + tag);
        return textView;
    }
}
