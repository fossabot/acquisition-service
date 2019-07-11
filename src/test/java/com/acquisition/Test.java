package com.acquisition;

import com.acquisition.entity.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @Author : Francis Du
 * @Date : Create in 13:09 2019/5/30
 * Modified By :
 */
public class Test {
    public static void main(String[] args){

        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("abc", "String");
        multiValueMap.add("123", "String");
        multiValueMap.add("123", "String");
        multiValueMap.add("abcde", "String");
        multiValueMap.add("1234", "String");
        multiValueMap.add("abcd", "String");
        multiValueMap.add("1234", "String");
        System.out.println(multiValueMap.keySet());    }
}

//[123, abc, abcde, 1234, abcd]
