package com.twcch.springbootjdbcmall.dao;

import com.twcch.springbootjdbcmall.dto.ProductRequest;
import com.twcch.springbootjdbcmall.model.Product;

public interface ProductDao {
	
	public Integer createProduct(ProductRequest productRequest);
	
	public Product getProductById(Integer productId);
	
	public void updateProduct(Integer productId, ProductRequest productRequest);
	
	public void deleteProductById(Integer productId);
	
}
