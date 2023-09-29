package com.twcch.springbootjdbcmall.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.twcch.springbootjdbcmall.dao.ProductDao;
import com.twcch.springbootjdbcmall.dto.ProductRequest;
import com.twcch.springbootjdbcmall.model.Product;
import com.twcch.springbootjdbcmall.rowmapper.ProductRowMapper;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Integer createProduct(ProductRequest productRequest) {
		
		String sql = "INSERT INTO product (product_name, category, image_url, price, stock, "
				+ "description, created_date, last_modified_date) VALUES (:productName, :category, "
				+ ":imageUrl, :price, :stock, :description, :createdDate, :lastModifiedDate)";
		
		Map<String, Object> map = new HashMap<>();
		map.put("productName", productRequest.getProductName());
		map.put("category", productRequest.getCategory().toString()); // enum 要轉 String
		map.put("imageUrl", productRequest.getImageUrl());
		map.put("price", productRequest.getPrice());
		map.put("stock", productRequest.getStock());
		map.put("description", productRequest.getDescription());
		
		Date rightNow = new Date();
		map.put("createdDate", rightNow);
		map.put("lastModifiedDate", rightNow);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
		
		int productId = keyHolder.getKey().intValue();
		
		return productId;
		
	}

	@Override
	public Product getProductById(Integer productId) {

		String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, "
				+ "created_date, last_modified_date FROM product WHERE product_id = :productId;";
		
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		
		List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
		
		if (productList.size() == 0) {
			return null;
		}

		return productList.get(0);

	}

	@Override
	public void updateProduct(Integer productId, ProductRequest productRequest) {
		
		String sql = "UPDATE product SET product_name = :productName, category = :category, "
				+ "image_url = :imageUrl, price = :price, stock = :stock, description = :description, "
				+ "last_modified_date = :lastModifiedDate WHERE product_id = :productId";
		
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		
		map.put("productName", productRequest.getProductName());
		map.put("category", productRequest.getCategory().toString());
		map.put("imageUrl", productRequest.getImageUrl());
		map.put("price", productRequest.getPrice());
		map.put("stock", productRequest.getStock());
		map.put("description", productRequest.getDescription());
		
		Date rightNow = new Date();
		map.put("lastModifiedDate", rightNow);
		
		namedParameterJdbcTemplate.update(sql, map);
		
	}

}
