package com.twcch.springbootmall.service;

import com.twcch.springbootmall.dto.CreateOrderRequest;
import com.twcch.springbootmall.dto.OrderQueryParams;
import com.twcch.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    int createOrder(int userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(int orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    int countOrder(OrderQueryParams orderQueryParams);

}
