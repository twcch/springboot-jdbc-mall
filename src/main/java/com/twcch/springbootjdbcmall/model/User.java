package com.twcch.springbootjdbcmall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data // 隱含 @Getter, @Setter, @ToString
public class User {

    private Integer userId;

    @JsonProperty("e_mail")
    private String email;

    @JsonIgnore
    private String password;

    private Date createdDate;
    private Date lastModifiedDate;

    public User() {

    }

}
