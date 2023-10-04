package com.twcch.springbootjdbcmall.service;

import com.twcch.springbootjdbcmall.dto.CreateOrderRequest;
import com.twcch.springbootjdbcmall.model.Order;

public interface OrderService {

    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    public Order getOrderById(Integer orderId);

}
