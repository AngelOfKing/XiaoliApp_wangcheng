//package com.google.ximalayafm.app.adapter;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.*;
//import com.google.ximalayafm.app.R;
//import com.google.ximalayafm.app.module.DiscoveryRecommend;
//import com.google.ximalayafm.app.module.json11.*;
//import com.google.ximalayafm.app.tasks.impl.ImageLoadTask;
//import com.google.ximalayafm.app.util.MyLog;
//
//import java.util.List;
//
///**
// * Created by Administrator on 2015/7/30.
// * Project:XiMalayaFM
// * User:king
// * Date:2015/7/30
// * Time:14:34
// */
//
//
///**
// * 发现--->推荐部分的列表adapter，需要支持多布局的处理
// * 推荐：DiscoveryRecommend:
// * 包含五个分类 :
// *  发现新奇：DiscoveryColumns
// *  小编推荐：EditRecommendAlbums----list里面有图片
// *  热门推荐：HotRecommends-----EditRecommendAlbums里面有图片----- AlbumRecommend
// *                             list_HoRecommends-----HotRecommends
// *
// *  精品听单：SpecialColumn
// *  上方的广告：FocusImages
// *
// *
// */
//public class DiscoveryRecommendAdapter extends BaseAdapter implements View.OnClickListener {
//    private Context context;
//
//    /**
//     * 从接口获取discover recommend 的内容
//     */
//    private DiscoveryRecommend recommend;
//
//    private View.OnClickListener onClickListener;
//
//    public DiscoveryRecommendAdapter(Context context) {
//        this.context = context;
//    }
//
//    public void setOnClickListener(View.OnClickListener onClickListener) {
//        this.onClickListener = onClickListener;
//    }
//
//    /**
//     * 设置实际的数据
//     * 需要在主线程更新
//     * @param recommend
//     */
//    public void setRecommend(DiscoveryRecommend recommend){
//        this.recommend = recommend;
//        notifyDataSetChanged();
//    }
//
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public int getCount() {
//        int ret = 0;
//        if(recommend!=null){
//            //小编推荐，精品听单，发现新奇
//            int hotCount = 0;
//            HotRecommends hotRecommends = new HotRecommends();
//            MyLog.d("HotRecommend"," "+(hotRecommends==null));
//            List<HotRecommends_List> lists = hotRecommends.getLists();
//            MyLog.d("+++++","hotcou"+ hotCount);
//            hotCount = lists.size();
//
//            ret = 3 + hotCount;
//            }
//        return ret;
//    }
//
//
//
//    @Override
//    public Object getItem(int position) {
//        Object ret = null;
//        switch (position){
//            case 0:
//                ret = recommend.getEditorRecommendAlbums();
//                break;
//            case 1:
//                ret = recommend.getSpecialColumn();
//                break;
//            case 2:
//                ret = recommend.getDiscoveryColumns();
//                default:
//                    HotRecommends hotRecommends = recommend.getHotRecommends();
//                    if(hotRecommends!=null){
//                            ret = hotRecommends.getLists().get(position - 3);
//                    }
//                    break;
//        }
//
//        return ret;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View ret= null;
//        Object item = getItem(position);
//        int itemViewType = getItemViewType(position);
//        switch (itemViewType){
//            case 0:
//                ret  = bindEditorRecommendAlbumsView(item, convertView, parent);
//                break;
//            case 1:
//                ret  = bindSpecialColumnView(item, convertView, parent);
//                break;
//            case 2:
//                ret  = bindDiscoveryColumnsView(item, convertView, parent);
//                break;
//            case 3:
//                ret  = bindHotCloumnView(item, convertView, parent);
//                break;
//        }
//
//
//        return ret;
//    }
//
//    private View bindSpecialColumnView(Object item, View convertView, ViewGroup parent) {
//        return null;
//    }
//
//    private View bindDiscoveryColumnsView(Object item, View convertView, ViewGroup parent) {
//        return null;
//    }
//
//
//
//    /**
//     * 热门推荐
//     * @param item
//     * @param convertView
//     * @param parent
//     * @return
//     */
//    private View bindHotCloumnView(Object item, View convertView, ViewGroup parent) {
//       View ret =null;
//       if(convertView!=null){
//           ret = convertView;
////       }else {
//           LayoutInflater inflater = LayoutInflater.from(context);
//           inflater.inflate(R.layout.item_recommend_album, parent, false);
//       }
//
//        HotRecommendViewHolder holder = ( HotRecommendViewHolder) ret.getTag();
//
//
//        if(holder !=null){
//            holder = new HotRecommendViewHolder();
//            holder.txtTitle = (TextView) ret.findViewById(R.id.editor_txt_title);
//            holder.txtMore = (TextView) ret.findViewById(R.id.editor_txt_more);
//            //"更多"---的点击事件
//            holder.txtMore.setOnClickListener(onClickListener);
//
//            holder.blocks = new LinearLayout[3];
//            holder.blocks[0] = (LinearLayout) ret.findViewById(R.id.line1);
//            holder.blocks[1] = (LinearLayout) ret.findViewById(R.id.line2);
//            holder.blocks[2] = (LinearLayout) ret.findViewById(R.id.line3);
//            ret.setTag(holder);
//        }
//        //
//        HotRecommends_List hot = (HotRecommends_List) item;
//        String title = hot.getTitle();
//        holder.txtTitle.setText(title);
//        boolean hasMore = hot.isHasMore();
//
//        //对于热门推荐----》更多点击的时候，对象中包含CategoryId,通过这个作为点击事件的入口
//        holder.txtMore.setTag("hotRecommend:"+hot.getCategoryId());
//
//
//
//
//
//        if(hasMore){
//            holder.txtMore.setVisibility(View.VISIBLE);
//        }else{
//            holder.txtMore.setVisibility(View.INVISIBLE);
//        }
////-----------------------------------------------------------
//
//        List<EditorRecommendAlbums_list> lists = hot.getLists();
//        for (int i = 0; i < lists.size(); i++) {
//            int size = lists.size();
//            if(lists!=null){
//                if(size>3){
//                    size = 3;
//                }
//                for (int j = 0; j < size; j++) {
//                    LinearLayout block = holder.blocks[i];
//                    LinearLayout[] blocks = holder.blocks;
//                    ImageButton img = (ImageButton) block.getChildAt(0);
//
//                    EditorRecommendAlbums_list editorRecommendAlbums_list = lists.get(i);
//                    // 网址
//                    String coverLarge = editorRecommendAlbums_list.getCoverLarge();
//
//                    boolean needLoad = true;
//                    Object tag = img.getTag();
//                    if (tag != null) {
//                        if(tag instanceof String){
//                            String s = (String) tag;
//                            if(s.equals(coverLarge)){
//                                needLoad = false;
//                            }
//                        }
//////                        else if(tag instanceof String[]){
////////                            String ss = (String[]) tag;
////////                            if(ss.length()>0){
////////                                String s  = ss[0];
////////                                if(s.equals(url)){
////////                                    imageView.setImageBitmap()
////
////                        设置字符串数据Tag,
////                        索引0 用于ImageView 图片错位问题
////                        其余两个，用户ImageView点击事件的处理
////                        img.setTag(
////                                new String {
////                            coverLarge,
//////                            Integer.toString(recommend.get
////                                Integer.toString(recommend.get)
////                        }
////                        );
//
////////                                }
////                            }
////                        }
//                    }
//                    if(needLoad) {
//                        // 设置“图片加载中”显示
//                        img.setImageResource(R.mipmap.ic_launcher);
//                    }
//
//                    if(needLoad) {
//                        // 设置“图片加载中”显示
//                        img.setImageResource(R.mipmap.ic_launcher);
//                    }
//
//                    img.setOnClickListener(onClickListener);
//
//                    TextView blockTitle = (TextView) block.getChildAt(1);
//
//                    // TODO 加载图片
////                    blockTitle.setText(recommend.gettrackTitle());
//
//                    // 用于在异步任务中，进行图片下载地址的识别，避免错位
//                    img.setTag(coverLarge);
//
//                    if (coverLarge != null && needLoad) {
//
//                        ImageLoadTask task = new ImageLoadTask(img);
//
//                        // 手机版本的适配
//                        if (Build.VERSION.SDK_INT >= 11) {
//                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, coverLarge);
//                        } else {
//                            task.execute(coverLarge);
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//
//
//    /**
//     * 小编推荐
//     * Item_recommend_album.xml文件，包含
//     *RelativeLayout----2 个 Text：
//     * @param item
//     * @param convertView
//     * @param parent
//     * @return
//     */
//    private View bindEditorRecommendAlbumsView(Object item, View convertView, ViewGroup parent) {
//      View ret = null;
//        if (convertView!=null){
//            ret = convertView;
//        }else{
//            LayoutInflater inflater = LayoutInflater.from(context);
//            ret = inflater.inflate(R.layout.item_recommend_album,parent,false);
//        }
//
//        AlbumRecommendViewHolder holder = (AlbumRecommendViewHolder) ret.getTag();
//
//        if(holder!=null){
//            holder = new AlbumRecommendViewHolder();
//            //TODO 加载布局
//            holder.txtTitle = (TextView) ret.findViewById(R.id.editor_txt_title);
//            holder.txtMore = (TextView) ret.findViewById(R.id.editor_txt_more);
////---------------------------------------------------------------------------
//            /*  小编推荐下的第一个图片布局  */
//            LinearLayout block0 = (LinearLayout) ret.findViewById(R.id.line1);
//            holder.block0ImageButton =
//                    (ImageButton) holder.block0.getChildAt(0);
//
//            //图片的点击事件
//            holder.block0ImageButton.setOnClickListener(onClickListener);
//            holder.block0TextView =
//                    (TextView) holder.block0.getChildAt(1);
//
////--------------------------------------------------------------------------
//            /*  小编推荐下的第二个图片布局  */
//            LinearLayout block1 = (LinearLayout) ret.findViewById(R.id.line2);
//
//            holder.block1ImageButton =
//                    (ImageButton) holder.block1.getChildAt(0);
//            //图片的点击事件
//            holder.block1ImageButton.setOnClickListener(onClickListener);
//
//            holder.block1TextView =
//                    (TextView) holder.block1.getChildAt(1);
////---------------------------------------------------------------------------
//             /*  小编推荐下的第三个图片布局  */
//            LinearLayout block2 = (LinearLayout) ret.findViewById(R.id.line3);
//
//            holder.block2ImageButton =
//                    (ImageButton) holder.block2.getChildAt(0);
//            //图片的点击事件
//            holder.block2ImageButton.setOnClickListener(onClickListener);
//
//            holder.block2TextView =
//                    (TextView) holder.block2.getChildAt(1);
//
//            ret.setTag(holder);
//        }
//
//        //获取小编推荐的对象;
//        EditorRecommendAlbums albums = (EditorRecommendAlbums)item;
//        String title = albums.getTitle();
//        MyLog.d("--EditorRecommendAlbums", title);
//        //标题----小编推荐
//        holder.txtTitle.setText(title);
//        //更多
//        boolean hasMore = albums.isHasMore();
//        holder.txtMore.setTag("editor");
//
//        MyLog.d("---EditorRecommendAlbums"," isHasMore"+(hasMore==true));
//        if(hasMore){
//            holder.txtMore.setVisibility(View.VISIBLE);
//        }else{
//            holder.txtMore.setVisibility(View.INVISIBLE);
//        }
//
////-----------------------------------------------------
//        //得到：小编推荐---->的list下面的内容
//        List<EditorRecommendAlbums_list> lists = albums.getLists();
//        if(lists!=null){
//            int size = lists.size();
//            if(size>3){
//                size=3;
//            }
//            for (int i = 0; i < size; i++) {
//                EditorRecommendAlbums_list editorRecommendAlbums_list = lists.get(i);
//               //coverLager图片的网址
//                String coverLarge = editorRecommendAlbums_list.getCoverLarge();
//                //图片的标题
//                String tit = editorRecommendAlbums_list.getTrackTitle();
//
//                ImageView imageView = null;
//
////给blocks设置内容和图片
//                switch (i){
//                    case 0:
//                        holder.block0TextView.setText(tit);//设置内容
//                        imageView = holder.block0ImageButton;
//                        break;
//                    case 1:
//                        holder.block0TextView.setText(tit);
//                        imageView = holder.block1ImageButton;
//                        break;
//                    case 2:
//                        holder.block0TextView.setText(tit);
//                        imageView= holder.block2ImageButton;
//                        break;
//                }
//                if(imageView!=null&&coverLarge!=null){
//                    imageView.setImageResource(R.mipmap.ic_launcher);
//                    //给imageview设置tag为网址----异步任务需要检查这个tag.
//                    imageView.setTag(coverLarge);
//                    ImageLoadTask task = new ImageLoadTask(imageView);
//                    if(Build.VERSION.SDK_INT>=11){
//                        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,coverLarge);
//                    }else {
//                        task.execute(coverLarge);
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
//
//
//
//
//    @Override
//    public int getItemViewType(int position) {
//        int ret= 0;
//        Object item = getItem(position);
//        if(item instanceof EditorRecommendAlbums){
//            ret = 0; //小编推荐
//        }else if(item instanceof SpecialColumn){
//            ret = 1; //精品听单
//        }else if(item instanceof DiscoveryColumns){
//            ret = 2; //发现新奇
//        }else if(item instanceof  HotRecommends){
//            ret = 3; //热门推荐
//        }
//        return ret;
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        //小编推荐，精品听单，发现新奇，热门推荐。。
//
//        return 4;
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//}
//
//
///**
// * 小编推荐和热门推荐
// */
//class AlbumRecommendViewHolder{
//    public TextView txtTitle;
//    public  TextView txtMore;
//
//    public LinearLayout block0;
//    public LinearLayout block1;
//    public LinearLayout block2;
//
//    /////每一个block的子内容
//    public ImageButton block0ImageButton;
//    public TextView block0TextView;
//
//    public ImageButton block1ImageButton;
//    public TextView block1TextView;
//
//    public ImageButton block2ImageButton;
//    public TextView block2TextView;
//
//    }
//
//class HotRecommendViewHolder{
//    public TextView txtTitle;
//    public  TextView txtMore;
//    LinearLayout[] blocks = new LinearLayout[3];
//
//    public ImageButton block0ImageButton;
//    public TextView block0TextView;
//
//    public ImageButton block1ImageButton;
//    public TextView block1TextView;
//
//    public ImageButton block2ImageButton;
//    public TextView block2TextView;
//
//}
//
//
//    /**
//    * 精品听单
//    */
//     class  SpecialViewHolder{
//
//    }
//
//    /**
//    * 发现
//    */
//     class  DiscoveryColumnsViewHolder{
//
//    }
//
