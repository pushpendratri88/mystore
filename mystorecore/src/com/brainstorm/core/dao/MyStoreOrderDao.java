package com.brainstorm.core.dao;

import de.hybris.platform.core.model.order.OrderModel;

import java.util.List;

public interface MyStoreOrderDao {
    List<OrderModel> getAllOrders();
    OrderModel getOrder(String orderId);
}
