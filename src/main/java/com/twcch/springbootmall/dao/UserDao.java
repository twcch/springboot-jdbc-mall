package com.twcch.springbootmall.dao;

import com.twcch.springbootmall.dto.UserRegisterRequest;
import com.twcch.springbootmall.model.User;

public interface UserDao {

    int createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(int userId);

    User getUserByName(String userName);

    User getUserByEmail(String userEmail);

}
