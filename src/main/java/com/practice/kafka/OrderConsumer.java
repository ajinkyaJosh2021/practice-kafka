package com.practice.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(groupId = "myGroup",topics = "preOrder")
    public void payment(ConsumerRecord<String,String > record){
        logger.info(String.format("PreOrder received %s and %s",record.key() ,record.value()));
    }


}
