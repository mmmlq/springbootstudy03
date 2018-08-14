package com.lq.springboot.service.impl;

import com.lq.springboot.dao.UserDao;
import com.lq.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wzd on 2018/8/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void testFindBYid(){
        User user = new User();
        user.setId(1);
        User user1 = userDao.selectById(user.getId());
        System.out.println("user1 = " + user1.getUserName());
        log.info("完成");
    }

}