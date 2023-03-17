package com.twcch.springbootmall.dao;

import com.twcch.springbootmall.dto.OrderQueryParams;
import com.twcch.springbootmall.model.Order;
import com.twcch.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    int createOrder(int userId, int totalAmount);

    void createOrderItems(int orderId, List<OrderItem> orderItemList);

    Order getOrderById(int orderId);

    List<OrderItem> getOrderItemsByOrderId(int orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    int countOrder(OrderQueryParams orderQueryParams);

}
