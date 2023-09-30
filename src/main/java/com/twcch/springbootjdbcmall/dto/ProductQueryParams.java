package com.twcch.springbootjdbcmall.dto;

import com.twcch.springbootjdbcmall.constant.ProductCategory;

public class ProductQueryParams {

	private ProductCategory category;
	private String search;

	public ProductQueryParams() {

	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "ProductQueryParams [category=" + category + ", search=" + search + "]";
	}

}
