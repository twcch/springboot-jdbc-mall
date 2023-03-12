package com.twcch.springbootmall.rowmapper;

import com.twcch.springbootmall.constant.ProductCategory;
import com.twcch.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));

        String categoryStr = rs.getString("product_category");
        ProductCategory productCategory = ProductCategory.valueOf(categoryStr); // 將 String 轉換成 Enum
        product.setProductCategory(productCategory);

        // product.setProductCategory(ProductCategory.valueOf(rs.getString("product_category")));

        product.setProductImageUrl(rs.getString("product_image_url"));
        product.setProductPrice(rs.getInt("product_price"));
        product.setProductStock(rs.getInt("product_stock"));
        product.setProductDescription(rs.getString("product_description"));
        product.setCreatedDate(rs.getTimestamp("created_date"));
        product.setLastModifiedDate(rs.getTimestamp("last_modified_date"));

        return product;
    }
}
