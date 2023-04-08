package com.twcch.springbootjdbcmall.service;

import com.twcch.springbootjdbcmall.dto.UserLoginRequest;
import com.twcch.springbootjdbcmall.dto.UserRegisterRequest;
import com.twcch.springbootjdbcmall.model.User;

public interface UserService {

    int register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);

    User getUserById(int userId);

}
