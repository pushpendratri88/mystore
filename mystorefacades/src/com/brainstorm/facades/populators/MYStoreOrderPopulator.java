package com.brainstorm.facades.populators;

import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class MYStoreOrderPopulator implements Populator<OrderModel, OrderData> {
    @Override
    public void populate(OrderModel orderModel, OrderData orderData) throws ConversionException {

    }
}
