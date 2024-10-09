package com.brainstorm.controller;

import com.brainstorm.facades.OrderFacade.MyStoreOrderFacade;
import com.brainstorm.returns.data.MyStoreOrderDataListWSDTO;
import com.brainstorm.returns.data.MyStoreOrderDataWSDTO;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.webservicescommons.mapping.DataMapper;
import de.hybris.platform.webservicescommons.mapping.FieldSetLevelHelper;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/{baseSiteId}")
@Api(tags="Order")
public class MyStoreOrderController {
    private static final Logger LOGGER = Logger.getLogger(MyStoreOrderController.class);
    protected static final String DEFAULT_FIELD_SET = FieldSetLevelHelper.DEFAULT_LEVEL;

    @Resource(name = "myStoreOrderFieldMapper")
    private DataMapper dataMapper;

    @Resource(name = "myStoreOrderFacade")
    private MyStoreOrderFacade myStoreOrderFacade;

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    @ApiOperation(nickname = "getOrderDetails", value = "Get a Specific Order Details",
            notes = "Return a specific order based on orderId", authorizations = {@Authorization
            (value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public MyStoreOrderDataWSDTO getOrderDetails(@ApiParam(value = "orderId", required = true)
                                                 @PathVariable final String orderId,
                                                 @ApiParam(value = "Response configuration. This is the list of fields that should be returned in the response body",
                                                         allowableValues = "BASIC,DEFAULT,FULL")
                                                 @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields) {
        LOGGER.info("Order is "+orderId);
        OrderData orderData = myStoreOrderFacade.getOrder(orderId);
        return getDataMapper().map(orderData, MyStoreOrderDataWSDTO.class,fields);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/allOrders", method = RequestMethod.GET)
    @ApiOperation(nickname = "getAllOrders", value = "Get a All Orders",
            notes = "Return a all order without filter", authorizations = {@Authorization
            (value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public MyStoreOrderDataListWSDTO getAllOrders(@ApiParam(value = "Response configuration. This is the list of fields that should be returned in the response body",
            allowableValues = "BASIC,DEFAULT,FULL")
                                                  @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields) {
        LOGGER.info("Retrieving all Order");
        List<OrderData> orderListData = myStoreOrderFacade.getAllOrders();
        return getDataMapper().map(orderListData, MyStoreOrderDataListWSDTO.class,fields);
    }

    protected DataMapper getDataMapper()
    {
        return dataMapper;
    }

    protected void setDataMapper(final DataMapper dataMapper)
    {
        this.dataMapper = dataMapper;
    }
}
