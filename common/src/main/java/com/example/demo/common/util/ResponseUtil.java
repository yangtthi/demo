package com.example.demo.common.util;

import com.example.demo.model.ResponseModel;
import com.alibaba.fastjson.JSON;

/**
 * Created by yangtthi on 18/3/11.
 */
public class ResponseUtil {

    public static String success(Object data){
        return JSON.toJSONString((new ResponseModel(200 , "", data)));
    }

    public static String success(String message, Object data){
        return JSON.toJSONString((new ResponseModel(200 , message, data)));
    }

    public static String fail(String message){
        return JSON.toJSONString((new ResponseModel(400 , message, null)));
    }
}
