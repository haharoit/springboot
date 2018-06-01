package com.haharoit;


import com.haharoit.domain.JpaUserRepository;
import com.haharoit.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haharoit
 * @version 1.0.0
 * @createtime 2018-06-01 am
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JpaUserRepositoryTest {

    @Autowired
    private JpaUserRepository userRepository;

    @Test
    public void test() throws Exception {

        // 创建10条记录
        userRepository.save(new User(1L,"AAA", 10));
        userRepository.save(new User(2L,"BBB", 20));
        userRepository.save(new User(3L,"CCC", 30));
        userRepository.save(new User(4L,"DDD", 40));
        userRepository.save(new User(5L,"EEE", 50));
        userRepository.save(new User(6L,"FFF", 60));
        userRepository.save(new User(7L,"GGG", 70));
        userRepository.save(new User(8L,"HHH", 80));
        userRepository.save(new User(9L,"III", 90));
        userRepository.save(new User(10L,"JJJ", 100));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());

    }


}
