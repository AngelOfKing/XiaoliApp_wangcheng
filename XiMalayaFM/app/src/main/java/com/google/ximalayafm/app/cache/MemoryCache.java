package com.google.ximalayafm.app.cache;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.util.LruCache;
import com.google.ximalayafm.app.util.MyLog;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2015/8/1.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/1
 * Time:10:57
 */
public class MemoryCache {
    private static MemoryCache ourInstance ;

    public static MemoryCache getInstance() {
        if(ourInstance==null){
            ourInstance = new MemoryCache();
        }
        return ourInstance;
    }

    /**
     * 使用软引用的存储区，通过这个方式，扩大内存利用率
     */
    private  HashMap<String,SoftReference<Bitmap>> softCache;
    /**
     * 使用LRU算法的，可以指定内存限制的一个图片缓存</br
     * 相当于 HashMap
     */
    private LruCache<String,Bitmap> lruCache;

    private MemoryCache() {

        // 设置内存的尺寸，通常都是最大内存数 / 8
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        int memorySize = (int) (maxMemory / 8);

        //使用内存字节数的情况，需要重写sizeOf方法
        lruCache = new LruCache<String, Bitmap>(memorySize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                int ret = 0;

                if (Build.VERSION.SDK_INT >= 19) {
                    ret = value.getAllocationByteCount();
                } else if (Build.VERSION.SDK_INT >= 12) {
                    ret = value.getByteCount();
                } else {
                    //对于低于12 的版本，需要计算 width * height * 颜色字节数
                    // 一行像素所占的字节数
                    int rowBytes = value.getRowBytes();
                    // 高度，也就是行数
                    int height = value.getHeight();
                    ret = rowBytes * height;

                }

                return ret;
            }
        };
    softCache = new LinkedHashMap<String, SoftReference<Bitmap>>();

    }

    /**
     * 获取缓存的图片
     * @param url
     * @return
     */
    public Bitmap getBitmap(String url){
        Bitmap ret = null;
        if(url!=null){
           ret= lruCache.get(url);
            if(ret ==null){
                SoftReference<Bitmap> reference = softCache.get(url);
                if(reference!=null){
                    //获取软引用指向的数据
                    ret = reference.get();
                    if(ret !=null){
                        lruCache.put(url,ret);
                    }

                }
            }

        }
        return ret;
    }

    public void putBitmap(String url,Bitmap bitmap){
        if(bitmap!=null&&url!=null){
            lruCache.put(url,bitmap);
            //更新软引用缓存
            softCache.put(url, new SoftReference<Bitmap>(bitmap));
        }
    }



}
