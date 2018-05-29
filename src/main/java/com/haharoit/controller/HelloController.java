package com.haharoit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host", "http//www.haharoit.com");

        return "index";
    }


}
