package com.twcch.springbootmall.service;

import com.twcch.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    int createOrder(int userId, CreateOrderRequest createOrderRequest);

}
