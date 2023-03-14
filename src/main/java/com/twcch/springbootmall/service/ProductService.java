package com.twcch.springbootmall.service;

import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(int productId);

    public List<Product> getProducts();

    public Integer createProduct(ProductRequest productRequest);

    public void updateProduct(int productId, ProductRequest productRequest);

    public void deleteProduct(int productId);

}
