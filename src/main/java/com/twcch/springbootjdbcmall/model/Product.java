package com.twcch.springbootjdbcmall.model;

import java.util.Date;

import com.twcch.springbootjdbcmall.constant.ProductCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {

    private Integer productId;
    private String productName;
    private ProductCategory category;
    private String imageUrl;
    private Integer price;
    private Integer stock;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;

    public Product() {

    }

}
