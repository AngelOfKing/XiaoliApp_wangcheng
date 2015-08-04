package com.google.ximalayafm.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.ximalayafm.app.R;
import com.google.ximalayafm.app.module.json17_album.Album_tracks;
import com.google.ximalayafm.app.module.json17_album.Track;
import com.google.ximalayafm.app.module.json17_album.Tracks;
import com.google.ximalayafm.app.util.MyLog;

import java.util.List;

/**
 * Created by Administrator on 2015/8/3.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/3
 * Time:0:53
 */
public class AlbumTracksAdapter extends BaseAdapter {
    private Album_tracks album_tracks;
    private Context context;
    private List<Tracks> tracksList;

    public AlbumTracksAdapter(Context context) {
        this.context = context;
    }

    public void setAlbum_tracks(Album_tracks album_tracks) {
        this.album_tracks = album_tracks;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        int ret = 0;
        tracksList = album_tracks.getTracksList();
        MyLog.d("ALbumTracksA"," "+(tracksList==null));
        if(tracksList !=null){
            ret = tracksList.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        Tracks tracks = tracksList.get(position);
        return tracks;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View ret = null;
       if(convertView!=null){
           ret = convertView;
       }else {
         ret = LayoutInflater.from(context).inflate(R.layout.item_album_task,parent,false);
       }

        AlbumTaskHolder holder = (AlbumTaskHolder) ret.getTag();
        if(holder==null){
            holder = new AlbumTaskHolder();
            holder.txtTitle = (TextView) ret.findViewById(R.id.item_album_title);
           ret.setTag(holder);
            }
        Tracks tracks = new Tracks();
        List<Track> list = tracks.getList();
        for (int i = 0; i < list.size(); i++) {
            Track track = list.get(i);
            String title = track.getTitle();
            holder.txtTitle.setText(title);

        }

        return ret;
    }

    private static class AlbumTaskHolder{
        private TextView txtTitle;
    }


}
