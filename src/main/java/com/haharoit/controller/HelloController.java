package com.haharoit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Description: springboot构建RESTful API与单元测试
 * Author: haharoit
 * Version: 1.0
 * Create Date Time: 2018-05-29.
 * Update Date Time:
 * @see
 * @Note
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "Hello World";
    }


}
