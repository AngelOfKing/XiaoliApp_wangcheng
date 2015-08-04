package com.google.ximalayafm.app.cache;

/**
 * Created by Administrator on 2015/7/31.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/31
 * Time:18:49
 */

import android.content.Context;
import android.os.Environment;
import com.google.ximalayafm.app.util.StreamUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 单例的文件缓存工具
 */
public class FileCache {

    private  static FileCache outInstance;
    private byte[] ret;

    public static FileCache CreatOutInstance(Context context){
            if(context!=null){
                if(outInstance ==null){
                    outInstance = new FileCache(context);
                }

                return outInstance;
            }else {
                throw new IllegalArgumentException("content must have");
            }
        }

    /**
     * 用于获取CacheDir，存储卡上main的
     */
    private Context context;

    private FileCache(Context context) {
        this.context = context;
    }

    /**
     * 通过网址，加载文件
     * @param url
     * @return
     */
    public byte[] loadFile(String url){
        File cacheDir = null;
        byte[] ret = null;
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            //外部
            cacheDir = context.getExternalCacheDir();
        }else{
            //内部
            cacheDir = context.getCacheDir();
        }
        if(url !=null){
            //TODO url 转换
            String name = md5(url);
            File file = new File(cacheDir,name);
            if(file.exists()){
                FileInputStream fin = null;
                try {
                    fin = new FileInputStream(file);
                    ret = StreamUtil.readStream(fin);
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    StreamUtil.close(fin);
                }
            }

        }
        return  ret;
    }

    /**
     * 保存文件
     * @param url
     * @param data
     */
    public void saveFile(String url,byte[] data){
        File cacheDir = null;
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            //外部
            cacheDir = context.getExternalCacheDir();
        }else{
            //内部
            cacheDir = context.getCacheDir();
        }
        if(url !=null){
            //TODO url 转换
            String name = md5(url);
            File file = new File(cacheDir,name);
            if(file.exists()){
                FileInputStream fout = null;
                try {
                    fout = new FileInputStream(file);
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    StreamUtil.close(fout);
                }
            }

        }

    }

    /**
     * 转换网址
     * @param url
     * @return
     */
    public static  String md5(String url){
        String ret = null;
        if(url != null){
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] data = digest.digest(url.getBytes());
                //经过md5的内容，字节数组无法new String
                StringBuilder sb = new StringBuilder();

                for(byte b:data){
                    int h = (b>>4)&0x0f;
                    int l = b& 0x0f;
                    sb.append(Integer.toHexString(h));
                    sb.append(Integer.toHexString(l));
                }

                ret = sb.toString();
                sb = null;
                data = null;


            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }


    public static FileCache getInstance(){
        if(outInstance!=null){
            return outInstance;
        }else{
            throw new IllegalArgumentException("you must invoke CreatOutInstance");
        }
    }



}
