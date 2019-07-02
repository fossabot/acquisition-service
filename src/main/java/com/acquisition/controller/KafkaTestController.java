package com.acquisition.controller;

import com.acquisition.kafka.KafkaSender;
import com.acquisition.service.ICjDwCrtTabDdlInfoService;
import com.acquisition.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangdongmao on 2019/6/18.
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaTestController {
    @Resource(name = "kafkaSender")
    public KafkaSender kafkaSender;

    @GetMapping(value = "/sender")
    public void getDWSystemAndSchemaFilterList() {
        kafkaSender.sendChannelMess("test","hello kafka");
    }
}
