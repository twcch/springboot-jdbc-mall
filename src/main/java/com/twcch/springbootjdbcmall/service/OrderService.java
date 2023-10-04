package com.twcch.springbootjdbcmall.service;

import com.twcch.springbootjdbcmall.dto.CreateOrderRequest;

public interface OrderService {

    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
