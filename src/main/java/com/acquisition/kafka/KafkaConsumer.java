package com.acquisition.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhangdongmao on 2019/6/18.
 */
@Component
public class KafkaConsumer {
    /**
     * 监听seckill主题,有消息就读取
     * @param record
     */
    @KafkaListener(topics = {"test"})
    public void receiveMessage(ConsumerRecord<?, ?> record){
        System.out.println("pass");
        String value = (String) record.value();
        System.out.println(value);
    }
}