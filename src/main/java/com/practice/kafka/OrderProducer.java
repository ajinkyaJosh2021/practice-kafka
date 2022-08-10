package com.practice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class OrderProducer {
    private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate ;

    /*public KafkaProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }*/


    public void sendMessage(String message){
        for(int i = 0;i<10;i++){
            org.springframework.util.concurrent.ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send("preOrder","data - "+ i,message);
            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onFailure(Throwable ex) {
                    logger.warn("failed to send preorder {}",ex);
                }

                @Override
                public void onSuccess(SendResult<String, String> result) {
                    logger.info("Successfully sent the message with  {} {}",result.getProducerRecord(),result.getRecordMetadata());
                }
            });
        }

    }
}
