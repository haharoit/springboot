package com.haharoit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description: User增删改查接口impl
 * @author haharoit
 * @version 1.0.0
 * @createtime 2018-05-31 pm
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Long id, String name, Integer age) {
        jdbcTemplate.update("insert into USER (id,name,age) values (?,?,?)",id,name,age);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM USER WHERE id = ?",id);
    }

    @Override
    public Integer getUserNumber() {
        return jdbcTemplate.queryForObject("select count(1) from user",Integer.class);
    }

    @Override
    public void deleteAllUser() {
        jdbcTemplate.update("DELETE FROM USER ");
    }
}
