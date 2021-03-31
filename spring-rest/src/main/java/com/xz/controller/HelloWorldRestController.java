package com.xz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    @GetMapping(value = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }


    //    @CrossOrigin("*"),使用这种可以,也可以在RestWebMvcConfigurer中配置
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
