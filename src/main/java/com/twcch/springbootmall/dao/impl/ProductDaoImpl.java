package com.twcch.springbootmall.dao.impl;

import com.twcch.springbootmall.dao.ProductDao;
import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;
import com.twcch.springbootmall.rowmapper.ProductRowMapper;
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
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(int productId) {

        String sql = "SELECT product_id, product_name, product_category, product_image_url, product_price, " +
                "product_stock, product_description, created_date, last_modified_date " +
                "FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {

        String sql = "INSERT INTO product(product_name, product_category, product_image_url, product_price, " +
                "product_stock, product_description, created_date, last_modified_date) " +
                "VALUES (:productName, :productCategory, :productImageUrl, :productPrice, " +
                ":productStock, :productDescription, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("productCategory", productRequest.getProductCategory().toString());
        map.put("productImageUrl", productRequest.getProductImageUrl());
        map.put("productPrice", productRequest.getProductPrice());
        map.put("productStock", productRequest.getProductStock());
        map.put("productDescription", productRequest.getProductDescription());

        Date rightNow = new Date();
        map.put("createdDate", rightNow);
        map.put("lastModifiedDate", rightNow);

        /*
         * 儲存資料庫自動生成 product_id
         */
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;

    }

    @Override
    public void updateProduct(int productId, ProductRequest productRequest) {

        String sql = "UPDATE product SET product_name = :productName, product_category = :productCategory, " +
                "product_image_url = :productImageUrl, product_price = :productPrice, " +
                "product_stock = :productStock, product_description = :productDescription, " +
                "last_modified_date = :lastModifiedDate " +
                "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("productName", productRequest.getProductName());
        map.put("productCategory", productRequest.getProductCategory().toString());
        map.put("productImageUrl", productRequest.getProductImageUrl());
        map.put("productPrice", productRequest.getProductPrice());
        map.put("productStock", productRequest.getProductStock());
        map.put("productDescription", productRequest.getProductDescription());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);

    }

}
