package com.twcch.springbootmall.service.impl;

import com.twcch.springbootmall.dao.UserDao;
import com.twcch.springbootmall.dto.UserRegisterRequest;
import com.twcch.springbootmall.model.User;
import com.twcch.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public int register(UserRegisterRequest userRegisterRequest) {

        // 檢核 user name 是否已經存在
        User userName = userDao.getUserByName(userRegisterRequest.getUserName());

        if (userName != null) {
            log.warn("該 user name: {} 已經被註冊", userRegisterRequest.getUserName());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 檢核 user email 是否已經存在
        User userEmail = userDao.getUserByEmail(userRegisterRequest.getUserEmail());

        if (userEmail != null) {
            log.warn("該 user email: {} 已經被註冊", userRegisterRequest.getUserEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 創建帳號
        return userDao.createUser(userRegisterRequest);

    }

    @Override
    public User getUserById(int userId) {

        return userDao.getUserById(userId);

    }

}
