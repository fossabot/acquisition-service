package com.acquisition.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@RestController
@RequestMapping(value = "/getSourceMetaData")
public class GetSourceMetaDataController {

    @GetMapping("/ffff")
    public String bbb() {
        System.out.println("进入测试方法");
        int gg = 1 / 0;
        return "";
    }

}
