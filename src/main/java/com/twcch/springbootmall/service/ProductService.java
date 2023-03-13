package com.twcch.springbootmall.service;

import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;

public interface ProductService {

    public Product getProductById(int productId);

    public Integer createProduct(ProductRequest productRequest);

}
