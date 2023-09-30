package com.twcch.springbootjdbcmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twcch.springbootjdbcmall.dao.ProductDao;
import com.twcch.springbootjdbcmall.dto.ProductRequest;
import com.twcch.springbootjdbcmall.model.Product;
import com.twcch.springbootjdbcmall.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Integer createProduct(ProductRequest productRequest) {
		
		return productDao.createProduct(productRequest);
		
	}

	@Override
	public List<Product> getProducts() {
		
		return productDao.getProducts();
		
	}

	@Override
	public Product getProductById(Integer productId) {
		
		return productDao.getProductById(productId);
		
	}

	@Override
	public void updateProduct(Integer productId, ProductRequest productRequest) {
		
		productDao.updateProduct(productId, productRequest);
		
	}

	@Override
	public void deleteProductById(Integer productId) {
		
		productDao.deleteProductById(productId);
		
	}
	
}
