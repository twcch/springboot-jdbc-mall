package com.twcch.springbootjdbcmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twcch.springbootjdbcmall.dao.ProductDao;
import com.twcch.springbootjdbcmall.model.Product;
import com.twcch.springbootjdbcmall.service.ProductServie;

@Component
public class ProductServiceImpl implements ProductServie {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getProductById(Integer productId) {
		
		return productDao.getProductById(productId);
		
		
	}

}
