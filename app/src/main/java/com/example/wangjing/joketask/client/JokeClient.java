package com.example.wangjing.joketask.client;

import com.example.wangjing.joketask.utils.HttpUtil;

import org.json.JSONObject;

/**
 * @author wangjing
 * @since 2016/5/25 10:14
 * @version 1.0
 *          <p>
 *          <strong> Features draft description.主要功能介绍
 * 
 *          </strong>
 *          </p>
 */
public class JokeClient {

    // API接口
    private static final String API_BASE_URL = "http://api.jisuapi.com/xiaohua/text?";

    public static final String  APPKEY       = "&appkey=9814b57c706d0a23";

    private JokeClient() {
    }

    /**
     * 接口 1 获取笑话内容
     * <p/>
     * //http://api.jisuapi.com/xiaohua/text?pagenum=10&pagesize=3&appkey=9814b57c706d0a23
     * 
     * @return JSONObject
     */
    public static JSONObject getJokeContent(String pNum, String pSize) {

        JSONObject ret = null;
        String url = API_BASE_URL + "pagenum=" + pNum + "&" + "pagesize=" + pSize + "&sort=addtime" + APPKEY;
        byte[] bytes = HttpUtil.doGet(url);
        if (bytes != null) {
            try {
                String str = new String(bytes, "UTF-8");
                ret = new JSONObject(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
