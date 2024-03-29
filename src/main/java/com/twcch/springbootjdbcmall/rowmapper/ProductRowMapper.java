package com.twcch.springbootjdbcmall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.twcch.springbootjdbcmall.constant.ProductCategory;
import org.springframework.jdbc.core.RowMapper;

import com.twcch.springbootjdbcmall.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		product.setProductId(rs.getInt("product_id"));
		product.setProductName(rs.getString("product_name"));
		product.setCategory(ProductCategory.valueOf(rs.getString("category")));
		product.setImageUrl(rs.getString("image_url"));
		product.setPrice(rs.getInt("price"));
		product.setStock(rs.getInt("stock"));
		product.setDescription(rs.getString("description"));
		
		return product;
		
	}
	
	
	
}
