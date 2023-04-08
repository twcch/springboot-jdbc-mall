package com.twcch.springbootjdbcmall.service;

import java.util.List;

import com.twcch.springbootjdbcmall.dto.CreateOrderRequest;
import com.twcch.springbootjdbcmall.dto.OrderQueryParams;
import com.twcch.springbootjdbcmall.model.Order;

public interface OrderService {

    int createOrder(int userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(int orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    int countOrder(OrderQueryParams orderQueryParams);

}
