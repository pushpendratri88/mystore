package com.brainstorm.facades.OrderFacade;

import de.hybris.platform.commercefacades.order.data.OrderData;

import java.util.List;

public interface MyStoreOrderFacade {

    List<OrderData> getAllOrders();
    OrderData getOrder(String orderId);
}
