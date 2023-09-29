package com.twcch.springbootjdbcmall.dto;

import com.twcch.springbootjdbcmall.constant.ProductCategory;

import jakarta.validation.constraints.NotNull;

public class ProductRequest {
	
	@NotNull
	private String productName;
	
	@NotNull
	private ProductCategory category;
	
	@NotNull
	private String imageUrl;
	
	@NotNull
	private Integer price;
	
	@NotNull
	private Integer stock;
	
	private String description;

	public ProductRequest() {

	}

	public ProductRequest(String productName, ProductCategory category, String imageUrl, Integer price, Integer stock,
			String description) {
		super();
		this.productName = productName;
		this.category = category;
		this.imageUrl = imageUrl;
		this.price = price;
		this.stock = stock;
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductRequest [productName=" + productName + ", category=" + category + ", imageUrl=" + imageUrl
				+ ", price=" + price + ", stock=" + stock + ", description=" + description + "]";
	}

}
