package com.twcch.springbootmall.service.impl;

import com.twcch.springbootmall.dao.UserDao;
import com.twcch.springbootmall.dto.UserRegisterRequest;
import com.twcch.springbootmall.model.User;
import com.twcch.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(UserRegisterRequest userRegisterRequest) {

        return userDao.createUser(userRegisterRequest);

    }

    @Override
    public User getUserById(int userId) {

        return userDao.getUserById(userId);

    }

}
