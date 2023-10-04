package com.twcch.springbootjdbcmall.service.impl;

import com.twcch.springbootjdbcmall.dao.OrderDao;
import com.twcch.springbootjdbcmall.dao.ProductDao;
import com.twcch.springbootjdbcmall.dto.BuyItem;
import com.twcch.springbootjdbcmall.dto.CreateOrderRequest;
import com.twcch.springbootjdbcmall.model.OrderItem;
import com.twcch.springbootjdbcmall.model.Product;
import com.twcch.springbootjdbcmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        // 計算訂單總花費
        int totalAmount = 0;

        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        // 建立訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return null;

    }
}
