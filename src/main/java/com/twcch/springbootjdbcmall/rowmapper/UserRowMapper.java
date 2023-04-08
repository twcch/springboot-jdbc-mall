package com.twcch.springbootjdbcmall.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.twcch.springbootjdbcmall.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUserName(rs.getString("user_name"));
        user.setUserPassword(rs.getString("user_password"));
        user.setUserEmail(rs.getString("user_email"));
        user.setCreatedDate(rs.getTimestamp("created_date"));
        user.setLastModifiedDate(rs.getTimestamp("last_modified_date"));

        return user;

    }
}
