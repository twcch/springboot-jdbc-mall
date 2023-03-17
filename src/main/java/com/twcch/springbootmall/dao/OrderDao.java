package com.twcch.springbootmall.dao;

import com.twcch.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    int createOrder(int userId, int totalAmount);

    void createOrderItems(int orderId, List<OrderItem> orderItemList);

}
