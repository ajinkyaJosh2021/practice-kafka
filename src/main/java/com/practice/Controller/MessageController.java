package com.practice.Controller;

import com.practice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {


    @Autowired
    OrderProducer kafkaProducer;

    @GetMapping("/setMessage")
    public ResponseEntity setMessage(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return new ResponseEntity(HttpStatus.OK);
    }
}
