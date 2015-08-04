package com.google.ximalayafm.app.tasks.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.google.ximalayafm.app.cache.FileCache;
import com.google.ximalayafm.app.cache.MemoryCache;
import com.google.ximalayafm.app.client.HttpUtil;
import com.google.ximalayafm.app.util.ImageUtil;
import com.google.ximalayafm.app.util.MyLog;


/**
 * 下载图片
 */
public class ImageLoadTask extends AsyncTask<String, Integer, Bitmap> {

    /**
     * 当前任务要设置的目标
     */
    private ImageView imageView;
    private String url;

    public ImageLoadTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap ret = null;

        if (params != null && params.length > 0) {
            url = params[0];
            //缓存中获取bitmap
            ret = MemoryCache.getInstance().getBitmap(url);

            //获取返回，没有直接进入文件缓存步骤
            byte[] data = FileCache.getInstance().loadFile(url);
            if (data == null) {
                data = HttpUtil.doGet(url);
                // 存文件
                FileCache.getInstance().saveFile(url, data);
            }

            // 1. 文件缓存
            // 2. 图片二次采样
            // 3. 内存缓存

            if (data != null) {
                // TODO 保存文件
                // TODO 转换图片 bitmap
                //                    //TODO 保存文件
                   //1.只获取尺寸
                    BitmapFactory.Options options = new BitmapFactory.Options();
                     options.inJustDecodeBounds = true;
                    //只解码不解析
                    ret = BitmapFactory.decodeByteArray(data, 0, data.length, options);

                    MyLog.d("Tag", " " + options.outHeight);
                    MyLog.d("Tag", " " + options.outWidth);
                    MyLog.d("Tag"," "+options.outMimeType);//比率
                    MyLog.d("Tag", " " + ret);

                    //2计算原始尺寸与目标尺寸的采样比例
                options.inJustDecodeBounds = false;

                options.inSampleSize = 2;//建议的值是2的n次方
                    //3.设置Options为实际解析图片，并且设置采样比率，能够自动缩小图片

                    //设置解码器，可以使用的界面像素颜色的配置，
                    //注意透明度与颜色的关系

                //设置解码器可以使用的像素颜色的配置,注意透明度与颜色的关系
                //如果图片不能够使用这个配置，就自动的使用ARGB_8888
                options.inPreferredConfig = Bitmap.Config.RGB_565;

                    //TODO
                    options.inSampleSize = ImageUtil.calculateInSampleSize(options,
                            options.outWidth,options.outHeight);
                    ret = BitmapFactory.decodeByteArray(data,0,data.length,options);
                    data =null;

                    MemoryCache.getInstance().putBitmap(url,ret);

            }
        }

        return ret;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            if (imageView != null) {
                Object tag = imageView.getTag();
                if (tag != null) {
                    if (tag instanceof String) {
                        String str = (String) tag;

                        if (str.equals(url)) {
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                }

            }
        }
    }
}
