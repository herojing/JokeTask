package com.example.wangjing.joketask.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/**
 * @author wangjing
 * @since 2016/5/25 11:20
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class StreamUtil {
    private StreamUtil() {
    }

    /**
     * 关闭IO流
     */
    public static void close(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof InputStream) {
                    ((InputStream) obj).close();
                } else if (obj instanceof OutputStream) {
                    ((OutputStream) obj).close();
                }else if (obj instanceof HttpURLConnection) {
                    ((HttpURLConnection) obj).disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static byte[] readStream(InputStream inputStream) {
        byte[] ret = null;
        if (inputStream != null) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                readStream(inputStream, bos);
                ret=bos.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(bos);
            }
        }
        return ret;
    }


    private static long readStream(InputStream in, OutputStream out) throws IOException {
        long ret = 0;
        if (in != null && out != null) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                ret += len;
            }
            StreamUtil.close(in);
        }
        return ret;
    }
}
