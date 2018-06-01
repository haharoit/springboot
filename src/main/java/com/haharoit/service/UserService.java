package com.haharoit.service;


/**
 * @Description: User增删改查接口
 * @author haharoit
 * @version 1.0.0
 * @createtime 2018-05-31 pm
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param id Long
     * @param name String
     * @param age Integer
     */
    void create(Long id,String name,Integer age);

    /**
     * 删除一个用户
     * @param id Long
     */
    void deleteById(Long id);

    /**
     * 查询用户总量
     */
    Integer getUserNumber();

    /**
     * 删除所有用户
     */
    void deleteAllUser();

}
