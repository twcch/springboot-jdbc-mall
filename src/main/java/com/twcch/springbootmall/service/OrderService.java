package com.twcch.springbootmall.service;

import com.twcch.springbootmall.dto.CreateOrderRequest;
import com.twcch.springbootmall.model.Order;

public interface OrderService {

    int createOrder(int userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(int orderId);

}
