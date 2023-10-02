package com.twcch.springbootjdbcmall.service;

import com.twcch.springbootjdbcmall.dto.UserLoginRequest;
import com.twcch.springbootjdbcmall.dto.UserRegisterRequest;
import com.twcch.springbootjdbcmall.model.User;

public interface UserService {

    public Integer register(UserRegisterRequest userRegisterRequest);

    public User login(UserLoginRequest userLoginRequest);

    public User getUserById(Integer userId);

}
