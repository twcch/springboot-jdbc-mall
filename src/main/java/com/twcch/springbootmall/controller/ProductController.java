package com.twcch.springbootmall.controller;

import com.twcch.springbootmall.dto.ProductRequest;
import com.twcch.springbootmall.model.Product;
import com.twcch.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {

        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {

        List<Product> productList = productService.getProducts();

        /*
         * 因為 RESTful API 對於資源的定義，就算 productList 無任何商品存在，
         * 但請求 products 的資源已經存在，就算 productList.size() = 0 ，也需要回傳 OK
         */
        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        int productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {

        /*
         * 檢查 product 是否存在
         */
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        /*
         * 修改商品數據
         */
        productService.updateProduct(productId, productRequest);

        Product updatedProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);

    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int productId) {

        /*
         * 因為前端傳入 delete request 只要確認商品是否已經不存在，
         * 不論該 product id 是否存在於資料庫，只要刪除之後必定會不存在，
         * 無須再執行前判斷 product id 是否存在
         */
        productService.deleteProduct(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
