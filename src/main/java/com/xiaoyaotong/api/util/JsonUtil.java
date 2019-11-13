package com.xiaoyaotong.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/13 17:45
 */
public class JsonUtil {
    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }

    /**
     * JSON 转 POJO
     */
    public static <T> T getObject(String pojo, Class<T> tclass) {
        try {
            return JSONObject.parseObject(pojo, tclass);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * POJO 转 JSON
     */
    public static <T> String getJson(T tResponse){
        String pojo = JSONObject.toJSONString(tResponse);
        return pojo;
    }

}
