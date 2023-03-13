package com.twcch.springbootmall.dao;

import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;

public interface ProductDao {

    public Product getProductById(int productId);

    public Integer createProduct(ProductRequest productRequest);

}
