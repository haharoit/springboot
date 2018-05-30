package com.haharoit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: Thymeleaf
 * Author: haharoit
 * Version: 1.0
 * Create Date Time: 2018-05-30.
 * Update Date Time:
 * @see
 * @Note
 */
@Controller
public class FreemarkerController {

    /**
     * freemarker:跳转到 freemarker.ftl
     * @author haharoit
     * @version 1.0
     * @param map
     * @retrun
     */
    @RequestMapping(value = "/freemarker")
    public String freemarker(Map<String, Object> map){
        map.put("name", "haharoit");
        map.put("sex", 1);
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "孙悟空");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "猪八戒");
        friend.put("age", 11);
        friends.add(friend);
        map.put("friends", friends);

        return "freemarker";
    }

}
