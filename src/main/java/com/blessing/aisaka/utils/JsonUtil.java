package com.blessing.aisaka.utils;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonStatus;

/**
 * json 工具类
 *
 * @author zhou.peng
 * @date 2019/03/15
 */
public class JsonUtil {
    public static JSONObject buildJson(Integer code, String message) {
        JSONObject json = new JSONObject();
        json.put(JsonStatus.STATUS, code);
        json.put(JsonStatus.MESSAGE, message);
        return json;
    }
}
