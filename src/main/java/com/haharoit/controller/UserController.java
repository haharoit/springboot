package com.haharoit.controller;


import com.haharoit.entity.User;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Description: springboot构建RESTful API与单元测试
 * Author: haharoit
 * Version: 1.0
 * Create Date Time: 2018-05-29.
 * Update Date Time:
 * @see
 * @Note
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    //创建线程安全的map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * Description: 处理/users/的get请求，用来获取用户列表
     * @param
     * @return result 返回User集合
     * @throws Exception  抛出一个异常
     * @see
     * @Note: Nothing much.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() throws Exception{

        List<User> result = new ArrayList<User>(users.values());
        return result;
    }

    /**
     * Description: 处理/users/的post请求，用来创建User
     * @param user 一个user
     * @return 成功后返回success
     * @throws Exception  抛出一个异常
     * @see
     *
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) throws Exception{

        users.put(user.getId(),user);
        return "success";
    }

    /**
     * Description: 处理/users/的get请求，用来创建User
     * @param id 一个user
     * @return 成功后返回一个user
     * @throws Exception  抛出一个异常
     * @see
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) throws Exception{

        return users.get(id);
    }

    /**
     * Description: 处理/users/的put请求，用来更新User信息
     * @param id 一个 id
     * @param user 一个 user
     * @return 成功后返回 success
     * @throws Exception  抛出一个异常
     * @see
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    /**
     * Description: 处理/users/的delete请求，用来删除User
     * @param id 一个user
     * @return 成功后返回一个user
     * @throws Exception  抛出一个异常
     * @see
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }

}
