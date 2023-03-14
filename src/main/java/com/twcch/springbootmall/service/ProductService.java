package com.twcch.springbootmall.service;

import com.twcch.springbootmall.constant.ProductCategory;
import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(int productId);

    List<Product> getProducts(ProductCategory productCategory, String searchText);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(int productId, ProductRequest productRequest);

    void deleteProduct(int productId);

}
