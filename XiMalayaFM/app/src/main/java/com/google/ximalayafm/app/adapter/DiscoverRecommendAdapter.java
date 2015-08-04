package com.google.ximalayafm.app.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.ximalayafm.app.R;
import com.google.ximalayafm.app.module.DiscoverRecommend;
import com.google.ximalayafm.app.module.json11.*;
import com.google.ximalayafm.app.tasks.impl.ImageLoadTask;

import java.util.List;


/**
 * 发现部分 -> 推荐列表 Adapter，需要支持多布局的处理
 */
public class DiscoverRecommendAdapter extends BaseAdapter {

    private Context context;

    /**
     * 从接口获取的 discover recommend 内容，完整的推荐
     */
    private DiscoverRecommend recommend;

    /**
     * 更多、专辑点击的接口
     */
    private View.OnClickListener onClickListener;

    public DiscoverRecommendAdapter(Context context) {
        this.context = context;
    }

    /**
     * 设置实际的数据<br/>
     * 这个方法需要在主线程调用更新
     *
     * @param recommend
     */
    public void setRecommend(DiscoverRecommend recommend) {
        this.recommend = recommend;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (recommend != null) {
            int hotCount = 0;
            HotRecommends hotRecommends = recommend.getHotRecommends();
            if (hotRecommends != null) {
                // 热门推荐 子分类
                List<HotRecommend> list = hotRecommends.getList();
                if (list != null) {
                    hotCount = list.size();
                }
            }

            // 3 是 “小编推荐”，“精品听单”，“发现新奇”
            // hotCount 热门推荐的个数
            ret = 3 + hotCount;
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        Object ret = null;

        switch (position) {
            case 0:
                ret = recommend.getEditorRecommendAlbums();
                break;
            case 1:
                ret = recommend.getSpecialColumn();
                break;
            case 2:
                ret = recommend.getDiscoverColumns();
                break;
            default:
                HotRecommends hotRecommends = recommend.getHotRecommends();
                if (hotRecommends != null) {
                    ret = hotRecommends.getList().get(position - 3);
                }
                break;
        }

        return ret;
    }

    @Override
    public int getViewTypeCount() {
        // 小编推荐, 精品听单, 发现新奇, 热门推荐
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        int ret = 0;
        Object item = getItem(position);
        if (item instanceof EditorRecommendAlbums) {
            ret = 0;
        } else if (item instanceof SpecialColumn) {
            ret = 1;
        } else if (item instanceof DiscoverColumns) {
            ret = 2;
        } else if (item instanceof HotRecommend) {
            ret = 3;
        }
        return ret;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;

        Object item = getItem(position);

        int itemViewType = getItemViewType(position);


        switch (itemViewType) {
            case 0:
                ret = bindEditorRecommendView(item, convertView, parent);
                break;
            case 1:
                ret = bindSpecialColumnView(item, convertView, parent);
                break;
            case 2:
                ret = bindDiscoverColumnsView(item, convertView, parent);
                break;
            case 3:
                ret = bindHotColumnView(item, convertView, parent);
                break;
        }

        return ret;
    }

    private View bindDiscoverColumnsView(Object item, View convertView, ViewGroup parent) {
        TextView ret = new TextView(context);
        return ret;
    }

    private View bindSpecialColumnView(Object item, View convertView, ViewGroup parent) {
        View ret = null;
        if(convertView!=null){
            ret = convertView;
        }else{
            ret = LayoutInflater.from(context).inflate(R.layout.item_special_column,parent,false);
        }

        //加载布局
        SpecialViewHolder holder = (SpecialViewHolder) ret.getTag();
        if(holder==null){
            holder = new SpecialViewHolder();

            holder.txtTitle = (TextView) ret.findViewById(R.id.item_special_column_title);
            holder.txtMore = (TextView) ret.findViewById(R.id.item_special_column_more);
            //更多 ---设置监听
            holder.txtMore.setOnClickListener(onClickListener);

            holder.blocks = new ViewGroup[2];
            holder.blocks[0] = (ViewGroup) ret.findViewById(R.id.item_special_block0);
            holder.blocks[1] = (ViewGroup) ret.findViewById(R.id.item_special_block1);

            ret.setTag(holder);
        }
        //加载:精品听单----更多
        SpecialColumn special = (SpecialColumn) item;
        if(special!=null){
            String title = special.getTitle();
            holder.txtTitle.setText(title);

            boolean hasMore = special.isHasMore();
            if(hasMore){
                holder.txtMore.setVisibility(View.VISIBLE);
            }else{
                holder.txtTitle.setVisibility(View.INVISIBLE);
            }
        //加载：栏目内容和图片
            List<SpecialColumn_List> lists = special.getLists();
            if(lists!=null){
                int size = lists.size();
                if(size>2){
                    size = 2;
                }

                for (int i = 0; i < size; i++) {
                    SpecialColumn_List specialColumn_list = lists.get(i);
                    ViewGroup block = holder.blocks[i];

                    ImageView  imageView0= (ImageView) block.findViewById(R.id.item_special_column_image0);
                    TextView textView_title0 = (TextView) block.findViewById(R.id.item_special_column_textView_title0);
                    TextView textView_subTitle0 = (TextView) block.findViewById(R.id.item_special_column_textView_subtitle0);
                    TextView textView_footnote0 = (TextView) block.findViewById(R.id.item_special_column_textView_footnote0);

                    ImageView imageView1 = (ImageView) block.findViewById(R.id.item_special_column_image1);
                    TextView textView_title1 = (TextView) block.findViewById(R.id.item_special_column_textView_title1);
                    TextView textView_subTitle1 = (TextView) block.findViewById(R.id.item_special_column_textView_subtitle1);
                    TextView textView_footnote1 = (TextView) block.findViewById(R.id.item_special_column_textView_footnote1);
                    String coverPath = specialColumn_list.getCoverPath();
                    ImageView  img = null;

                    switch (i){
                        case 0:
                            //大标题
                            String title1 = specialColumn_list.getTitle();
                            textView_title0.setText(title1);
                            //子标题----内容简介
                            String subtitle = specialColumn_list.getSubtitle();
                            textView_subTitle0.setText(subtitle);
                            //6首声音
                            String footnote = specialColumn_list.getFootnote();
                            textView_footnote0.setText(footnote);
                            //图片网址

                            img = imageView0;

                            break;
                        case 1:
                            String title2 = specialColumn_list.getTitle();
                            textView_title1.setText(title2);
                            //子标题----内容简介
                            String subtitle2 = specialColumn_list.getSubtitle();
                            textView_subTitle1.setText(subtitle2);
                            //6首声音
                            String footnote2 = specialColumn_list.getFootnote();
                            textView_footnote1.setText(footnote2);
                            img = imageView1;
                            break;
                    }


                    if (img != null && coverPath != null) {

                        img.setImageResource(R.mipmap.ic_launcher);

                        // 设置ImageView的 Tag，在异步任务中，需要检查这个Tag
                        img.setTag(coverPath);

                        ImageLoadTask task = new ImageLoadTask(img);

                        // 手机版本的适配
                        if (Build.VERSION.SDK_INT >= 11) {
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, coverPath);
                        } else {
                            task.execute(coverPath);
                        }
                    }

//                    //图片网址
//                    String coverPath = specialColumn_list.getCoverPath();
                }
                }

            }

        return ret;
    }

    /**
     * 热门推荐
     *
     * @param item
     * @param convertView
     * @param parent
     * @return
     */
    private View bindHotColumnView(Object item, View convertView, ViewGroup parent) {
        View ret = null;

        if (convertView != null) {
            ret = convertView;
        } else {
            ret = LayoutInflater.from(context).inflate(R.layout.item_recommend_album, parent, false);
        }

        HotRecommendViewHolder holder =
                (HotRecommendViewHolder) ret.getTag();

        if (holder == null) {
            holder = new HotRecommendViewHolder();
            holder.txtTitle = (TextView) ret.findViewById(R.id.item_recommend_album_title);
            holder.txtMore = (TextView) ret.findViewById(R.id.item_recommend_album_more);

            holder.txtMore.setOnClickListener(onClickListener);

            holder.blocks = new ViewGroup[3];
            holder.blocks[0] = (ViewGroup) ret.findViewById(R.id.item_recommend_album_block0);
            holder.blocks[1] = (ViewGroup) ret.findViewById(R.id.item_recommend_album_block1);
            holder.blocks[2] = (ViewGroup) ret.findViewById(R.id.item_recommend_album_block2);
            ret.setTag(holder);
        }

        //////////////////////////////////

        HotRecommend hot = (HotRecommend) item;
        int categoryId = hot.getCategoryId();

        String title = hot.getTitle();
        holder.txtTitle.setText(title);

        boolean hasMore = hot.isHasMore();
        //8.1 对于热门推荐，更多点击的时候，对象中包含CategoryID
        //通过Id作为点击事件的入口
        holder.txtMore.setTag("hotRecommend:"+categoryId);
        if (hasMore) {
            holder.txtMore.setVisibility(View.VISIBLE);
        } else {
            holder.txtMore.setVisibility(View.INVISIBLE);
        }

        ///////////////////////////
        // 水平的图片

        List<AlbumRecommend> list = hot.getList();

        if (list != null) {
            int size = list.size();
            if (size > 3) {
                size = 3;
            }
            for (int i = 0; i < size; i++) {
                ViewGroup block = holder.blocks[i];

                ImageButton img = (ImageButton) block.getChildAt(0);
                AlbumRecommend recommend = list.get(i);
                // 网址
                String coverLarge = recommend.getCoverLarge();

                boolean needLoad = true;
                Object tag = img.getTag();
                if (tag != null) {
                    if(tag instanceof String) {
                        String s = (String) tag;
                        if (s.equals(coverLarge)) {
                            needLoad = false;
                        }
                    }else if (tag instanceof String[]) {
                            String[] ss = (String[]) tag;
                            if (ss.length > 0) {
                                String s = ss[0];
                                if (s.equals(coverLarge)) {
                                    //TODO
                                    needLoad = false;

                                }
                            }
                        }

                }
                if(needLoad) {
                    // 设置“图片加载中”显示
                    img.setImageResource(R.mipmap.ic_launcher);
                }

                img.setOnClickListener(onClickListener);

                TextView blockTitle = (TextView) block.getChildAt(1);

                // TODO 加载图片
                blockTitle.setText(recommend.getTrackTitle());


                //设置tag,便于监听
                // 8.1img.setTag(coverLarge);
                img.setTag(new String[]{coverLarge});

                img.setTag(new String[]{
                                coverLarge,
                                Integer.toString(recommend.getAlbumId()),
                                Integer.toString(recommend.getTrackId())
                        }
                );



                // 用于在异步任务中，进行图片下载地址的识别，避免错位
//                img.setTag(coverLarge);

                if (coverLarge != null && needLoad) {
                    ImageLoadTask task = new ImageLoadTask(img);
                    // 手机版本的适配
                    if (Build.VERSION.SDK_INT >= 11) {
                        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, coverLarge);
                    } else {
                        task.execute(coverLarge);
                    }
                }


            }
        }

        return ret;
    }

    /**
     * 小编
     *
     * @param item
     * @param convertView
     * @param parent
     * @return
     */
    private View bindEditorRecommendView(Object item, View convertView, ViewGroup parent) {
        View ret = null;

        // 加载布局
        if (convertView != null) {
            ret = convertView;
        } else {
            ret = LayoutInflater.from(context)
                    .inflate(R.layout.item_recommend_album, parent, false);
        }

        AlbumRecommendViewHolder holder =
                (AlbumRecommendViewHolder) ret.getTag();

        if (holder == null) {
            holder = new AlbumRecommendViewHolder();
            // TODO 加载View
            holder.txtTitle = (TextView) ret.findViewById(R.id.item_recommend_album_title);
            holder.txtMore = (TextView) ret.findViewById(R.id.item_recommend_album_more);

            //////////////////////////
            // 设置 更多的点击处理事件

            holder.txtMore.setOnClickListener(onClickListener);

            //////////////////////////

            holder.block0 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block0);
            holder.block1 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block1);
            holder.block2 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block2);

            holder.block0ImageButton =
                    (ImageButton) holder.block0.getChildAt(0);
            holder.block0ImageButton.setOnClickListener(onClickListener);

            holder.block0TextView =
                    (TextView) holder.block0.getChildAt(1);

            holder.block1ImageButton =
                    (ImageButton) holder.block1.getChildAt(0);
            holder.block1ImageButton.setOnClickListener(onClickListener);

            holder.block1TextView =
                    (TextView) holder.block1.getChildAt(1);

            holder.block2ImageButton =
                    (ImageButton) holder.block2.getChildAt(0);
            holder.block2ImageButton.setOnClickListener(onClickListener);

            holder.block2TextView =
                    (TextView) holder.block2.getChildAt(1);

            ret.setTag(holder);
        }

        EditorRecommendAlbums albums =
                (EditorRecommendAlbums) item;

        String title = albums.getTitle();
        holder.txtTitle.setText(title);

        //////////////////////////////////////////

        boolean hasMore = albums.isHasMore();
        //设置tag便于识别是editor,还是hotRecommend
        holder.txtMore.setTag("editor");
        if (hasMore) {
            holder.txtMore.setVisibility(View.VISIBLE);
        } else {
            holder.txtMore.setVisibility(View.INVISIBLE);
        }


        List<AlbumRecommend> list = albums.getList();

        if (list != null) {

            int size = list.size();

            if (size > 3) {
                size = 3;
            }

            for (int i = 0; i < size; i++) {

                AlbumRecommend recommend = list.get(i);

                // 图片的网址
                String coverLarge = recommend.getCoverLarge();

                String tit = recommend.getTrackTitle();

                ImageView imageView = null;

                switch (i) {
                    case 0:
                        // TODO 需要显示图片
                        holder.block0TextView.setText(tit);
                        imageView = holder.block0ImageButton;
                        holder.block0ImageButton.setOnClickListener(onClickListener);
                        break;
                    case 1:
                        // TODO 需要显示图片
                        holder.block1TextView.setText(tit);
                        imageView = holder.block1ImageButton;
                        holder.block1ImageButton.setOnClickListener(onClickListener);

                        break;
                    case 2:
                        // TODO 需要显示图片
                        holder.block2TextView.setText(tit);
                        imageView = holder.block2ImageButton;
                        holder.block2ImageButton.setOnClickListener(onClickListener);
                        break;
                }

                if (imageView != null && coverLarge != null) {

                    imageView.setImageResource(R.mipmap.ic_launcher);

                    // 设置ImageView的 Tag，在异步任务中，需要检查这个Tag
                    imageView.setTag(coverLarge);

                    ImageLoadTask task = new ImageLoadTask(imageView);

                    // 手机版本的适配
                    if (Build.VERSION.SDK_INT >= 11) {
                        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, coverLarge);
                    } else {
                        task.execute(coverLarge);
                    }
                }

            }

        }

        return ret;
    }

    //热门推荐
    private static class HotRecommendViewHolder {
        public TextView txtTitle;
        public TextView txtMore;
        /**
         * 三块图片文字的布局 一共三个
         */
        public ViewGroup[] blocks;
    }

    /**
     * 小编推荐
     */
    private static class AlbumRecommendViewHolder {
        public TextView txtTitle;
        public TextView txtMore;
        public LinearLayout block0;
        public LinearLayout block1;
        public LinearLayout block2;

        //// 每一个 block 的子内容

        public ImageButton block0ImageButton;
        public TextView block0TextView;

        public ImageButton block1ImageButton;
        public TextView block1TextView;

        public ImageButton block2ImageButton;
        public TextView block2TextView;
    }

    /**
     * 精品听单
     */
    private static class SpecialViewHolder {
        public TextView txtTitle;
        public TextView txtMore;


        public ViewGroup blocks[];
    }

    /**
     * 发现新奇
     */
    private static class DiscoverColumnsViewHolder {

    }
}
