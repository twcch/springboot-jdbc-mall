package com.twcch.springbootjdbcmall.dao;

import com.twcch.springbootjdbcmall.dto.UserRegisterRequest;
import com.twcch.springbootjdbcmall.model.User;

public interface UserDao {

    int createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(int userId);

    User getUserByName(String userName);

    User getUserByEmail(String userEmail);

}
