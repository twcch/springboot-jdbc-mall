package com.twcch.springbootmall.dao.impl;

import com.twcch.springbootmall.dao.UserDao;
import com.twcch.springbootmall.dto.UserRegisterRequest;
import com.twcch.springbootmall.model.User;
import com.twcch.springbootmall.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int createUser(UserRegisterRequest userRegisterRequest) {

        String sql = "INSERT INTO user(user_name, user_password, user_email, created_date, last_modified_date) " +
                "VALUES (:userName, :userPassword, :userEmail, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("userName", userRegisterRequest.getUserName());
        map.put("userPassword", userRegisterRequest.getUserPassword());
        map.put("userEmail", userRegisterRequest.getUserEmail());

        Date rightNow = new Date();
        map.put("createdDate", rightNow);
        map.put("lastModifiedDate", rightNow);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int userId = keyHolder.getKey().intValue();

        return userId;

    }

    @Override
    public User getUserById(int userId) {

        String sql = "SELECT user_id, user_name, user_password, user_email, created_date, last_modified_date " +
                "FROM user WHERE user_id = :userId";

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public User getUserByName(String userName) {

        String sql = "SELECT user_id, user_name, user_password, user_email, created_date, last_modified_date " +
                "FROM user WHERE user_name = :userName";

        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public User getUserByEmail(String userEmail) {

        String sql = "SELECT user_id, user_name, user_password, user_email, created_date, last_modified_date " +
                "FROM user WHERE user_email = :userEmail";

        Map<String, Object> map = new HashMap<>();
        map.put("userEmail", userEmail);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }

    }
}
