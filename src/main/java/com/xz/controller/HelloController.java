package com.xz.controller;

import com.xz.properties.HuMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz
 * @date 2020/2/13 20:57
 **/

@RestController
public class HelloController {

    @Autowired
    private HuMan huMan;

    @RequestMapping("/hello")
    public String Hello(){
        System.out.println(huMan.toString());
        return "hello springBoot";
    }
}
