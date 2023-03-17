package com.twcch.springbootmall.service.impl;

import com.twcch.springbootmall.dao.OrderDao;
import com.twcch.springbootmall.dao.ProductDao;
import com.twcch.springbootmall.dto.BuyItem;
import com.twcch.springbootmall.dto.CreateOrderRequest;
import com.twcch.springbootmall.model.Order;
import com.twcch.springbootmall.model.OrderItem;
import com.twcch.springbootmall.model.Product;
import com.twcch.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public int createOrder(int userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {

            Product product = productDao.getProductById(buyItem.getProductId());

            // total amount calculator
            int amount = buyItem.getQuantity() * product.getProductPrice();
            totalAmount = totalAmount + amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);

        }

        // 創建訂單
        int orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;

    }

    @Override
    public Order getOrderById(int orderId) {

        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;

    }

}
