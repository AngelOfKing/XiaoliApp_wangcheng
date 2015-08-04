package com.google.ximalayafm.app;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.ximalayafm.app.adapter.AlbumTracksAdapter;
import com.google.ximalayafm.app.module.json17_album.Album;
import com.google.ximalayafm.app.module.json17_album.Album_tracks;
import com.google.ximalayafm.app.parsers.DataParse;
import com.google.ximalayafm.app.tasks.TaskCallback;
import com.google.ximalayafm.app.tasks.TaskResult;
import com.google.ximalayafm.app.tasks.impl.Album_listTask;
import com.google.ximalayafm.app.util.BaseActivity;
import com.google.ximalayafm.app.util.MyLog;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class PlaylistActivity extends BaseActivity implements TaskCallback {


    private AlbumTracksAdapter adapter;
    private PullToRefreshListView pullToRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);


        pullToRefresh = (PullToRefreshListView) findViewById(R.id.pull_to_refresh_listview);
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            strings.add("春秋五霸"+i);
        }
        pullToRefresh.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings));


//        ListView refreshableView = pullToRefresh.getRefreshableView();
//        refreshableView.setDividerHeight(5);
//
//        if(refreshableView!=null){
////            adapter = new AlbumTracksAdapter(this);
//            if(adapter!=null){
//                pullToRefresh.setAdapter(adapter);
//            }
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        //开启异步任务
        Album_listTask task = new Album_listTask(this);
        task.execute();
    }

    @Override
    public void onFinished(TaskResult taskResult) {
        if(taskResult!=null){
            taskResult = new TaskResult();
            if(taskResult.taskId==Contants.TASK_DISCOVERY_RECOMMEND_ALBUM){
                Object data = taskResult.data;
                if(data!=null){
                    if(data instanceof JSONObject){
                        JSONObject json = (JSONObject)data;
                            Album_tracks album_tracks = DataParse.parseAlbum_tracks(json);
                        MyLog.d("Playlist", "al====" + (album_tracks == null));
                        List<Album> list = album_tracks.getAlbumList();
                        MyLog.d("Playlist", "al====" + (list == null));

//                        adapter.setAlbum_tracks(album_tracks);

                    }

                }
            }
        }
    }




}
