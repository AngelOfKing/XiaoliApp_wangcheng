package com.google.ximalayafm.app.util;

/**
 * Created by Administrator on 2015/7/28.
 * Project:XiMalayaFM
 * User:king
 * Date:2015/7/28
 * Time:12:13
 */

import java.io.*;
import java.net.HttpURLConnection;

/**
 * �����඼�Ǿ�̬��
 * IO�������Ĺ�����
 */
public final class StreamUtil {

    private StreamUtil() {
    }

    /**
     * �ر���
     * @param stream
     */
    public static void close(Object stream){
        if(stream != null){
            try {
                if(stream instanceof InputStream){
                    ((InputStream) stream).close();
                }else if(stream instanceof OutputStream){
                    ((OutputStream)stream).close();
                }else if(stream instanceof Reader){
                    ( (Reader)stream).close();
                }else if(stream instanceof Writer){
                    ((Writer)stream).close();
                }else if(stream instanceof HttpURLConnection){
                    ((HttpURLConnection)stream).disconnect();
                }

            }catch (Exception ex){

            }
        }
    }

    /**
     * 输入流-----------读出来存储在数组中
     * @param in
     * @return
     */
    public static byte[] readStream(InputStream in) throws IOException {
        byte[] ret = null;
        if(in !=null){
            byte[] buf = new byte[128];
            int len = 0;
            ByteArrayOutputStream bout = null;
                 bout = new ByteArrayOutputStream();

            while(true){
                len = in.read(buf);
                if(len==-1){
                    break;
                }
                bout.write(buf,0,len);
            }
            buf = null;
            ret = bout.toByteArray();
            bout.close();
        }

        return ret;
    }

}
