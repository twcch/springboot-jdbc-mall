package com.twcch.springbootjdbcmall.service;

import com.twcch.springbootjdbcmall.dto.ProductRequest;
import com.twcch.springbootjdbcmall.model.Product;

public interface ProductService {
	
	public Integer createProduct(ProductRequest productRequest);
	
	public Product getProductById(Integer productId);
	
	public void updateProduct(Integer productId, ProductRequest productRequest);
	
}
