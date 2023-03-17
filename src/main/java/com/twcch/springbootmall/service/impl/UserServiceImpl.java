package com.twcch.springbootmall.service.impl;

import com.twcch.springbootmall.dao.UserDao;
import com.twcch.springbootmall.dto.UserLoginRequest;
import com.twcch.springbootmall.dto.UserRegisterRequest;
import com.twcch.springbootmall.model.User;
import com.twcch.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
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

        // 使用 MD5 生成密碼的雜湊值
        String hasdedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getUserPassword().getBytes());
        userRegisterRequest.setUserPassword(hasdedPassword);

        // 創建帳號
        return userDao.createUser(userRegisterRequest);

    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {

        User user = userDao.getUserByName(userLoginRequest.getUserName());

        // 檢核 user name 是否已經存在
        if (user == null) {
            log.warn("該 user name: {} 尚未被註冊", userLoginRequest.getUserName());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 使用 MD5 生成密碼的雜湊值
        String hasdedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getUserPassword().getBytes());

        // 比較密碼
        if (user.getUserPassword().equals(hasdedPassword)) {
            return user;
        } else {
            log.warn("該 user: {} 的密碼不正確", userLoginRequest.getUserName());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public User getUserById(int userId) {

        return userDao.getUserById(userId);

    }

}
