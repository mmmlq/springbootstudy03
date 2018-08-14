package com.lq.springboot.service.impl;

import com.lq.springboot.dao.UserDao;
import com.lq.springboot.model.User;
import com.lq.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wzd on 2018/8/13.
 */
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserDao userDao;


    @Override
    public User findById(User user) {

        return userDao.selectById(user.getId());
    }
}
