package com.twcch.springbootjdbcmall.dao;

import com.twcch.springbootjdbcmall.dto.CreateOrderRequest;
import com.twcch.springbootjdbcmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    public Integer createOrder(Integer userId, Integer totalAmount);

    public void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

}
