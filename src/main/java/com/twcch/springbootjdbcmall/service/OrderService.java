package com.twcch.springbootjdbcmall.service;

import com.twcch.springbootjdbcmall.dto.CreateOrderRequest;
import com.twcch.springbootjdbcmall.dto.OrderQueryParams;
import com.twcch.springbootjdbcmall.model.Order;

import java.util.List;

public interface OrderService {

    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    public Order getOrderById(Integer orderId);

    public List<Order> getOrders(OrderQueryParams orderQueryParams);

    public Integer countOrder(OrderQueryParams orderQueryParams);

}
