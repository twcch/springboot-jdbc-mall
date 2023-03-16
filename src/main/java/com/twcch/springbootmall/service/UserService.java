package com.twcch.springbootmall.service;

import com.twcch.springbootmall.dto.UserLoginRequest;
import com.twcch.springbootmall.dto.UserRegisterRequest;
import com.twcch.springbootmall.model.User;

public interface UserService {

    int register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);

    User getUserById(int userId);

}
