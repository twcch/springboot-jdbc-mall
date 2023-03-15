package com.twcch.springbootmall.service;

import com.twcch.springbootmall.dto.UserRegisterRequest;
import com.twcch.springbootmall.model.User;

public interface UserService {

    int register(UserRegisterRequest userRegisterRequest);

    User getUserById(int userId);

}
