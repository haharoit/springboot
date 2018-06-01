package com.haharoit;

import com.haharoit.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: User增删改查接口测试类
 * @author haharoit
 * @version 1.0.0
 * @createtime 2018-05-31 pm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =SpringbootdemoApplication.class )
public class UserServiceTest {

    @Autowired
    private UserService userSerivce;

    @Before
    public void setUp() {
        // 准备，清空user表
        userSerivce.deleteAllUser();
    }

    @Test
    public void test() throws Exception {
        // 插入5个用户
        userSerivce.create(Long.valueOf(1), "1",1);
        userSerivce.create(Long.valueOf(2), "2",2);
        userSerivce.create(Long.valueOf(3), "3",3);
        userSerivce.create(Long.valueOf(4), "4",4);
        userSerivce.create(Long.valueOf(5), "5",5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userSerivce.getUserNumber().intValue());

        // 删除两个用户
        userSerivce.deleteById(Long.valueOf(1));
        userSerivce.deleteById(Long.valueOf(2));

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userSerivce.getUserNumber().intValue());

    }

}
