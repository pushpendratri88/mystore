package com.brainstorm.core.dao.impl;

import com.brainstorm.core.dao.MyStoreOrderDao;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStoreOrderDaoImpl implements MyStoreOrderDao {

    @Autowired
    FlexibleSearchService flexibleSearchService;

    @Override
    public List<OrderModel> getAllOrders(){
        String query = "SELECT {PK} FROM {Order} ";
        SearchResult<OrderModel> result = flexibleSearchService.search(query);
        if(!result.getResult().isEmpty()){
            return result.getResult();
        }
        return null;
    }

    @Override
    public OrderModel getOrder(String code) {
        Map<String,Object> param = new HashMap<>();
        String query = "SELECT {PK} FROM {Order} where {code} = ?code";
        param.put("code" , code);
        SearchResult<OrderModel> result = flexibleSearchService.search(query,param);
        if(!result.getResult().isEmpty()){
            return result.getResult().stream().findFirst().get();
        }
        return null;
    }

}
