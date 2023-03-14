package com.twcch.springbootmall.dto;

import com.twcch.springbootmall.constant.ProductCategory;

public class ProductQueryParams {

    private ProductCategory productCategory;
    private String searchText;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

}
