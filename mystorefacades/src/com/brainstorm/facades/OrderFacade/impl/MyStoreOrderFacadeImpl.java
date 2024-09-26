package com.brainstorm.facades.OrderFacade.impl;

import com.brainstorm.core.service.MyStoreOrderService;

import com.brainstorm.facades.OrderFacade.MyStoreOrderFacade;
import de.hybris.platform.commercefacades.order.data.OrderData;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyStoreOrderFacadeImpl implements MyStoreOrderFacade {

    @Autowired
    MyStoreOrderService orderService;
    @Autowired
    Converter<OrderModel,OrderData> orderConverter;

    @Override
    public List<OrderData> getAllOrders() {
        return orderConverter.convertAll(orderService.getAllOrder());
    }

    @Override
    public OrderData getOrder(String orderId) {
        return orderConverter.convert(orderService.getOrder(orderId));
    }
}
