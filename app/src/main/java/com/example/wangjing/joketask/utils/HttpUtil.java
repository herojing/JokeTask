package com.example.wangjing.joketask.utils;

import android.os.Build;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * ============================================================ author： 王景
 * <p/>
 * time： 2015/9/22 14:11.
 * <p/>
 * email: wjontheway@163.com
 * <p/>
 * description： Http静态工作类
 * <p/>
 * ============================================================
 */
public final class HttpUtil {
    private static final int    TIMEOUT_CONNECT = 5000;
    private static final int    TIMEOUT_READ    = 20000;
    // 比如小米手机ting_4.1.7(MI@,Android17)
    // 设置User-Agent字段"ting_4.1.7(手机型号，AndroidAPILevel)"
    private static final String USER_AGENT      =
        "ting_4.1.7(" + Build.MODEL + ", Android" + Build.VERSION.SDK_INT + ")";

    private HttpUtil() {
    }

    /**
     * 实现HttpURLConnection的简单的 GET 请求
     *
     */
    public static byte[] doGet(String url) {
        byte[] ret = null;
        if (url != null) {
            HttpURLConnection conn = null;
            InputStream inputStream = null;
            try {
                URL u = new URL(url);
                conn = (HttpURLConnection) u.openConnection();
                // 请求方法
                conn.setRequestMethod("GET");
                setCommmonHttpHeaders(conn);
                conn.connect();
                int code = conn.getResponseCode();
                if (code == HttpURLConnection.HTTP_OK) {
                    // 1.响应部分
                    inputStream = conn.getInputStream();
                    // 1.1检查内容是否经过压缩
                    String encoding = conn.getContentEncoding();
                    if ("gzip".equals(encoding)) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    ret = StreamUtil.readStream(inputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                StreamUtil.close(inputStream);

                StreamUtil.close(conn);

            }
        }
        return ret;
    }

    /**
     * 设置通用的Http请求信息:超时和请求头
     *
     * @param conn
     *            HttpURLConnection
     */
    private static void setCommmonHttpHeaders(HttpURLConnection conn) {
        conn.setConnectTimeout(TIMEOUT_CONNECT);
        conn.setReadTimeout(TIMEOUT_READ);
        // 设置请求字段部分（HTTP请求头信息）
        conn.setRequestProperty("User-Agent", USER_AGENT);
        // 代表客户端能够接受服务器传回什么内容类型的格式
        conn.setRequestProperty("Accept", "application/json,application/*,image/*,*/*");
        // 设置客户端支持的压缩格式（内容编码 对应服务器返回的字段 Content-Encoding）
        conn.setRequestProperty("Accept-Encoding", "gzip");
    }

    /**
     * 请求不进行内容的读取，直接返回，直接返回InputStream
     *
     * @param url
     *            url
     * @return InputStream
     */
    public static InputStream doGetInPutStream(String url) {
        InputStream ret = null;
        if (url != null) {
            HttpURLConnection conn;
            InputStream inputStream ;
            try {
                URL u = new URL(url);
                conn = (HttpURLConnection) u.openConnection();
                // 请求方法
                conn.setRequestMethod("GET");
                setCommmonHttpHeaders(conn);
                conn.connect();
                int code = conn.getResponseCode();
                if (code == HttpURLConnection.HTTP_OK) {
                    // 1.响应部分
                    inputStream = conn.getInputStream();
                    // 1.1检查内容是否经过压缩
                    String encoding = conn.getContentEncoding();
                    if ("gzip".equals(encoding)) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    ret = inputStream;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
