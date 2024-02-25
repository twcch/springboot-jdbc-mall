package com.twcch.springbootjdbcmall.dto;

import jakarta.validation.constraints.NotNull;

public class BuyItem {

    @NotNull
    private Integer productId;

    @NotNull
    private Integer quantity;

    public BuyItem() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BuyItem{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }

}
