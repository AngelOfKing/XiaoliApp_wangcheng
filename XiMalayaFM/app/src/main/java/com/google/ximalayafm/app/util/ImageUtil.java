package com.google.ximalayafm.app.util;

/**
 * Created by Administrator on 2015/8/1.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/8/1
 * Time:15:16
 */


import android.graphics.BitmapFactory;

/**
 * 图片的二次采样 算法
 */
public class ImageUtil {

    /**
     * 计算采样比率 ，通过 BitmapFactory.Options 对象中包含的原始尺寸和目标尺寸、图片采样率，
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (reqWidth == 0 || reqHeight == 0) {
            return inSampleSize;
        }
        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}