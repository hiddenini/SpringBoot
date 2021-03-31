package com.xz.bootstarp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.xz.controller",
        "com.xz.config"
})
public class SpringBootRestBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class, args);
    }
}
