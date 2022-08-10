package com.practice.service;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Service
public class CarsService {

    public CompletableFuture<String> getCars(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(5000);
                completableFuture.complete("Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return completableFuture;
    }
}
