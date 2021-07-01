/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package rest.salesforce.com.scenarios.hooks;

import api.ApiMethod;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.config.Endpoints;
import salesforce.config.Request;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Order;
import salesforce.entities.RequisiteElement;

/**
 * Scenario hooks for order entity.
 */
public class OrderScenarioHooks {

    private Logger logger = LogManager.getLogger(getClass());
    public static final String DATE_FORMAT = "yyyy-mm-dd";
    private CreatedResponse createdResponse;
    private RequisiteElement requisiteElement;
    private ApiResponse apiResponse;

    public OrderScenarioHooks(final CreatedResponse createdResponse, final RequisiteElement requisiteElement) {
        this.createdResponse = createdResponse;
        this.requisiteElement = requisiteElement;
    }

    @Before(value = "@CreateOrder or @GetOrder or @UpdateOrder or @DeleteOrder", order = 2)
    public void createAccount() throws JsonProcessingException {
        logger.info("*** Create Account to test Orders ***");
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("testAccount01");
        ApiResponse apiResponse = Request.execute(Endpoints.ACCOUNTS.get(), pathParams, account, ApiMethod.POST);
        requisiteElement.setId(apiResponse.getBody(CreatedResponse.class).getId());
        apiResponse.logAll();
    }

    @Before(value = "@GetOrder or @UpdateOrder or @DeleteOrder", order = 3)
    public void createOrder() throws JsonProcessingException {
        logger.info("*** Create an Order to test operations ***");
        Map<String, String> pathParams = new HashMap<>();
        LocalDateTime ldt = LocalDateTime.now();
        String date = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.getDefault()).format(ldt);
        Order order = new Order();
        order.setName("testOrder");
        order.setAccountId(requisiteElement.getId());
        order.setEffectiveDate(date);
        order.setStatus("Draft");
        ApiResponse apiResponse = Request.execute(Endpoints.ORDERS.get(), pathParams, order, ApiMethod.POST);
        apiResponse.logAll();
        createdResponse.setId(apiResponse.getBody(CreatedResponse.class).getId());
    }

    @After(value = "@GetOrder or @UpdateOrder or @CreateOrder")
    public void setDownAccount() throws JsonProcessingException {
        logger.info("*** Delete created Account ***");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), requisiteElement.getId());
        apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, ApiMethod.DELETE);
    }
}
