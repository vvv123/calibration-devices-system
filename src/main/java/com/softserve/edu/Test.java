package com.softserve.edu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Test.class);
    }
}
