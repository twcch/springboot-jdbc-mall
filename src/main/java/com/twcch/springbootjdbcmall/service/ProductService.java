package com.twcch.springbootjdbcmall.service;

import java.util.List;

import com.twcch.springbootjdbcmall.dto.ProductQueryParams;
import com.twcch.springbootjdbcmall.dto.ProductRequest;
import com.twcch.springbootjdbcmall.model.Product;

public interface ProductService {

    Product getProductById(int productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    int createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProduct(int productId);

    int countProduct(ProductQueryParams productQueryParams);

}
