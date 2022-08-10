package com.practice.config;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
    public void printObject(){
        System.out.println("This is object");
        Object obj = null;
        System.out.println(obj.toString());
    }
}
