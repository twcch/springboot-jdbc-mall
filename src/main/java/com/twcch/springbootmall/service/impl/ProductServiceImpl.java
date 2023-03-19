package com.twcch.springbootmall.service.impl;

import com.twcch.springbootmall.dao.ProductDao;
import com.twcch.springbootmall.dto.ProductQueryParams;
import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;
import com.twcch.springbootmall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private final static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(int productId) {

        return productDao.getProductById(productId);

    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {

        return productDao.getProducts(productQueryParams);

    }

    @Override
    public int createProduct(ProductRequest productRequest) {

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

    @Override
    public int countProduct(ProductQueryParams productQueryParams) {

        return productDao.countProduct(productQueryParams);

    }

}
