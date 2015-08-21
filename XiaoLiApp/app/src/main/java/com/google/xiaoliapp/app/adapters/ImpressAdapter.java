package com.google.xiaoliapp.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.xiaoliapp.app.R;
import com.google.xiaoliapp.app.entities.Impress;

import java.util.List;

/**
 * Created by Administrator on 2015/8/20.
 * Project:XiaoLiApp
 * User:king
 * Date:2015/8/20
 * Time:14:43
 */
public class ImpressAdapter extends Adapter<ViewHolder> {
    private Context context;
    private List<Impress> list;
    private LayoutInflater layoutInflater;

    public ImpressAdapter(Context context, List<Impress> list) {
        this.context = context;
        this.list = list;
       layoutInflater = LayoutInflater.from(context);

    }

    //创建ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       View view = null;
        view = layoutInflater.inflate(R.layout.item_impress_recycle_view,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    //绑定ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

     MyViewHolder holder = new MyViewHolder(viewHolder.itemView);
        holder.imageView = (ImageView)viewHolder.itemView.findViewById(R.id.item_impress_image);
        holder.nick = (TextView)viewHolder.itemView.findViewById(R.id.item_impress_nick);
        holder.date = (TextView)viewHolder.itemView.findViewById(R.id.item_impress_text_date);
        holder.btn_cai = (CheckBox) viewHolder.itemView.findViewById(R.id.item_impress_cai);
        holder.btn_zan = (CheckBox) viewHolder.itemView.findViewById(R.id.item_impress_zan);

        Impress impress = list.get(i);
        holder.imageView.setImageResource(impress.getImage());
        holder.nick.setText(impress.getNick());
        holder.date.setText(impress.getDate());
        holder.btn_zan.setText(impress.getZan());
        holder.btn_cai.setText(impress.getCai());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends ViewHolder{
        public ImageView imageView;
        public TextView nick;
        public TextView date;
        public CheckBox  btn_zan;
        public CheckBox btn_cai;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
