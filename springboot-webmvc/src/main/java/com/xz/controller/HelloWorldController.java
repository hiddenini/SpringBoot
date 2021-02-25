package com.xz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * HelloWorld {@link Controller}
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(@RequestParam int value, Model model) {
        return "index";
    }
    
}
