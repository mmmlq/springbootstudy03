package com.lq.springboot.service;

import com.lq.springboot.model.User;

/**
 * Created by wzd on 2018/8/13.
 */
public interface IUserService {

    User findById (User user);
}
