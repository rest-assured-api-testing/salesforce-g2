/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package scenarios.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforce.auth.Authentication;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Order;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OrderScenarioHooks {

    public Logger LOGGER = LogManager.getLogger(getClass());
    public static final String DATE_FORMAT = "yyyy-mm-dd";
    private CreatedResponse createdResponse;
    public static String accountId;
    public static String orderId;

    public OrderScenarioHooks(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(order = 1)
    public  void setUp() {
        Authentication.getAuth();
    }

    @Before(order = 2)
    public void createAccount() throws JsonProcessingException {
        LOGGER.info("*** Create Account to test Orders ***");
        Map<String,String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("testAccount01");
        ApiResponse apiResponse = ApiRequestManager.create(Endpoints.ACCOUNTS.getEndpoint(), pathParams, account);
        accountId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }
    @Before(value = "@GetOrder or @UpdateOrder or @DeleteOrder", order = 3)
    public void createOrder() throws JsonProcessingException {
        LOGGER.info("*** Create an Order to test operations ***");
        Map<String,String> pathParams = new HashMap<>();
        LocalDateTime ldt = LocalDateTime.now();
        String date = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.getDefault()).format(ldt);
        Order order = new Order();
        order.setName("testOrder");
        order.setAccountId(accountId);
        order.setEffectiveDate(date);
        order.setStatus("Draft");
        ApiResponse apiResponse = ApiRequestManager.create(Endpoints.ORDERS.getEndpoint(), pathParams, order);
        orderId = apiResponse.getBody(CreatedResponse.class).getId();
    }

//    @After(value = "@GetOrder or @UpdateOrder or @CreateOrder")
//    public void setDownOrder() {
//        LOGGER.info("*** Delete created Order ***");
//        Map<String,String> pathParams = new HashMap<>();
//        pathParams.put(Endpoints.ID.getEndpoint(),orderId);
//        ApiResponse apiResponse = ApiRequestManager.delete(Endpoints.ORDER.getEndpoint(), pathParams);
//        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
//    }

    @After(value = "@GetOrder or @UpdateOrder or @CreateOrder")
    public void setDownAccount() {
        LOGGER.info("*** Delete created Account ***");
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(),accountId);
        ApiResponse apiResponse = ApiRequestManager.delete(Endpoints.ACCOUNT.getEndpoint(), pathParams);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
