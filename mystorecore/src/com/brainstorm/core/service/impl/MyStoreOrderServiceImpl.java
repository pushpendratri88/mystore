package com.brainstorm.core.service.impl;

import com.brainstorm.core.dao.MyStoreOrderDao;
import com.brainstorm.core.service.MyStoreOrderService;
import de.hybris.platform.core.model.order.OrderModel;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyStoreOrderServiceImpl implements MyStoreOrderService {
    @Autowired
    MyStoreOrderDao orderDao;
    @Override
    public List<OrderModel> getAllOrder() {
        return orderDao.getAllOrders();
    }

    @Override
    public OrderModel getOrder(String orderId) {
        return orderDao.getOrder(orderId);
    }
}
