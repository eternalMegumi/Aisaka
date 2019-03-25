package com.blessing.aisaka.utils;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonConstant;

/**
 * json 工具类
 *
 * @author zhou.peng
 * @date 2019/03/15
 */
public class JsonUtil {

    public static JSONObject buildJson(Integer code, String message) {
        JSONObject json = new JSONObject();
        json.put(JsonConstant.STATUS, code);
        json.put(JsonConstant.MESSAGE, message);
        return json;
    }

    public static JSONObject buildJson(Integer code, String message, Object data) {
        JSONObject json = new JSONObject();
        json.put(JsonConstant.STATUS, code);
        json.put(JsonConstant.MESSAGE, message);
        json.put(JsonConstant.DATA, data);
        return json;
    }
}
