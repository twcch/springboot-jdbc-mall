package com.twcch.springbootjdbcmall.dao;

import com.twcch.springbootjdbcmall.dto.UserRegisterRequest;
import com.twcch.springbootjdbcmall.model.User;

public interface UserDao {

    public Integer createUser(UserRegisterRequest userRegisterRequest);

    public User getUserById(Integer userId);

    public User getUserByEmail(String email);

}
