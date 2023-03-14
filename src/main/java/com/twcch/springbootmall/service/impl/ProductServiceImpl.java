package com.twcch.springbootmall.service.impl;

import com.twcch.springbootmall.dao.ProductDao;
import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;
import com.twcch.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(int productId) {

        return productDao.getProductById(productId);

    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {

        return productDao.createProduct(productRequest);

    }

    @Override
    public void updateProduct(int productId, ProductRequest productRequest) {

        productDao.updateProduct(productId, productRequest);

    }

    @Override
    public void deleteProduct(int productId) {

        productDao.deleteProduct(productId);

    }

}
