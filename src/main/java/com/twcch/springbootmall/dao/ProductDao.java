package com.twcch.springbootmall.dao;

import com.twcch.springbootmall.dto.ProductQueryParams;
import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Product getProductById(int productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    int createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProduct(int productId);

    int countProduct(ProductQueryParams productQueryParams);

}
