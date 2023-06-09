package com.twcch.springbootjdbcmall.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.twcch.springbootjdbcmall.constant.ProductCategory;
import com.twcch.springbootjdbcmall.dto.ProductQueryParams;
import com.twcch.springbootjdbcmall.dto.ProductRequest;
import com.twcch.springbootjdbcmall.model.Product;
import com.twcch.springbootjdbcmall.service.ProductService;
import com.twcch.springbootjdbcmall.util.Page;

import java.util.List;

@RestController
@Validated
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
    public ResponseEntity<Page<Product>> getProducts(

            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory productCategory,
            @RequestParam(required = false) String searchText,

            // 排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "DESC") String sort,

            // 分頁 Pagination
            @RequestParam(defaultValue = "10") @Max(100) @Min(0) int limit,
            @RequestParam(defaultValue = "0") @Min(0) int offset) {

        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setProductCategory(productCategory);
        productQueryParams.setSearchText(searchText);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        List<Product> productList = productService.getProducts(productQueryParams);

        // 取得 product 總數
        int total = productService.countProduct(productQueryParams);

        // 分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);

        /*
         * 因為 RESTful API 對於資源的定義，就算 productList 無任何商品存在，
         * 但請求 products 的資源已經存在，就算 productList.size() = 0 ，也需要回傳 OK
         */
        return ResponseEntity.status(HttpStatus.OK).body(page);

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

        // 檢查 product 是否存在
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改商品數據
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
