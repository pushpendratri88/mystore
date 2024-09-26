package com.brainstorm.core.service;


import de.hybris.platform.core.model.order.OrderModel;


import java.util.List;

public interface MyStoreOrderService {
    List<OrderModel> getAllOrder();
    OrderModel getOrder(String orderId);
}
