package com.xz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloWorld {@link Controller}
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index( Model model) {
        return "index";
    }

}
