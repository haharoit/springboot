package com.haharoit.controller;


import com.haharoit.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Description: Spring Boot中使用Swagger2构建RESTful APIs
 * @author haharoit
 * @version 1.0.0
 * @createtime 2018-05-30 pm
 * @updatetime 2018-05-31 am
 * @blog
 */
@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class Swagger2UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "query" , dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "user名称", required = true, paramType = "query" , dataType = "String"),
            @ApiImplicitParam(name = "age", value = "user年龄", required = true, paramType = "query" , dataType = "Long")
    })    @RequestMapping(value="/", method= RequestMethod.POST)
    public String postUser(@ModelAttribute User user) throws Exception{
        users.put(user.getId(), user);
        return "success";
    }

    //paramType 有五个可选值 ： path, query, body, header, form
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息",httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户ID",paramType = "path" , required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "path" , dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID",paramType = "path" , required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

}