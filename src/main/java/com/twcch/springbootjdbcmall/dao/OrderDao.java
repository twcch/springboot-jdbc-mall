package com.twcch.springbootjdbcmall.dao;

import java.util.List;

import com.twcch.springbootjdbcmall.dto.OrderQueryParams;
import com.twcch.springbootjdbcmall.model.Order;
import com.twcch.springbootjdbcmall.model.OrderItem;

public interface OrderDao {

    int createOrder(int userId, int totalAmount);

    void createOrderItems(int orderId, List<OrderItem> orderItemList);

    Order getOrderById(int orderId);

    List<OrderItem> getOrderItemsByOrderId(int orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    int countOrder(OrderQueryParams orderQueryParams);

}
