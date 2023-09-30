package com.twcch.springbootjdbcmall.service;

import java.util.List;

import com.twcch.springbootjdbcmall.dto.ProductQueryParams;
import com.twcch.springbootjdbcmall.dto.ProductRequest;
import com.twcch.springbootjdbcmall.model.Product;

public interface ProductService {
	
	public Integer createProduct(ProductRequest productRequest);
	
	public List<Product> getProducts(ProductQueryParams productQueryParams);
	
	public Product getProductById(Integer productId);
	
	public void updateProduct(Integer productId, ProductRequest productRequest);
	
	public void deleteProductById(Integer productId);
	
}
