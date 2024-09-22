package com.brainstorm.core.handler;


import com.brainstorm.core.model.MyStoreCustomerModel;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

public class CustomerAgeCalculationHandler implements DynamicAttributeHandler<String, MyStoreCustomerModel> {

    @Override
    public String get(MyStoreCustomerModel model) {
        return null;
    }

    @Override
    public void set(MyStoreCustomerModel model, String s) {

    }
}
