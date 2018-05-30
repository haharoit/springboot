package com.haharoit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: Thymeleaf
 * Author: haharoit
 * Version: 1.0
 * Create Date Time: 2018-05-29.
 * Update Date Time:
 * @see
 * @Note
 */

@Controller
public class ThymeleafController {

    @RequestMapping("/thymeleaf")
    public String index(ModelMap map){
        map.addAttribute("host", "Thymeleaf");

        return "thymeleaf";
    }

    @RequestMapping("/test")
    public String test(ModelMap map){
        map.addAttribute("host", "http//www.haharoit.com");
        map.put("haha","test");
        return "test";
    }
}
