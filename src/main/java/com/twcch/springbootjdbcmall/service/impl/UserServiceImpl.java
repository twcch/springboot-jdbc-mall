package com.twcch.springbootjdbcmall.service.impl;

import com.twcch.springbootjdbcmall.dao.UserDao;
import com.twcch.springbootjdbcmall.dto.UserRegisterRequest;
import com.twcch.springbootjdbcmall.model.User;
import com.twcch.springbootjdbcmall.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        // 檢查 email 是否重複
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if (user != null) {
            log.warn("該 email {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 創建帳號
        return userDao.createUser(userRegisterRequest);

    }

    @Override
    public User getUserById(Integer userId) {

        return userDao.getUserById(userId);

    }

}
