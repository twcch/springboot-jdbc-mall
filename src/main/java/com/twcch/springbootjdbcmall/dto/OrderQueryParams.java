package com.twcch.springbootjdbcmall.dto;

public class OrderQueryParams {

    private Integer userId;
    private Integer limit;
    private Integer offset;

    public OrderQueryParams() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "OrderQueryParams{" +
                "userId=" + userId +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }

}
