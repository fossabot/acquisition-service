package com.acquisition;

import com.acquisition.entity.Result;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author : Francis Du
 * @Date : Create in 13:09 2019/5/30
 * Modified By :
 */
public class Test {
    public static void main(String[] args){
        System.out.println(Result.ok(JSONObject.toJSON("成功")));
    }
}
