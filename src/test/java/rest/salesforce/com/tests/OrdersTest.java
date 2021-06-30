/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package rest.salesforce.com.tests;

import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import api.ApiResponse;
import salesforce.config.Request;
import salesforce.config.Endpoints;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Order;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OrdersTest extends CommonTest {

    private String accountId;
    private String orderId;
    private final String DATE_FORMAT = "yyyy-mm-dd";

    @BeforeClass
    public void createAccount() throws JsonProcessingException {
        Account account = new Account();
        account.setName("testAccount01");
        Map<String, String> pathParams = new HashMap<>();
        ApiResponse apiResponse = Request.execute(Endpoints.ACCOUNTS.get(), pathParams, account, ApiMethod.POST);
        accountId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @BeforeMethod(onlyForGroups = {"updateOrder", "deleteOrder"})
    public void createTestOrder() throws JsonProcessingException {
        LocalDateTime ldt = LocalDateTime.now();
        String date = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.getDefault()).format(ldt);
        Order order = new Order();
        order.setName("testOrderToUpdateAndDelete");
        order.setAccountId(accountId);
        order.setEffectiveDate(date);
        order.setStatus("Draft");
        Map<String, String> pathParams = new HashMap<>();
        ApiResponse apiResponse = Request.execute(Endpoints.ORDERS.get(), pathParams, order, ApiMethod.POST);
        orderId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @Test(groups = "createOrder")
    public void createOrder() throws JsonProcessingException {
        LocalDateTime ldt = LocalDateTime.now();
        String date = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.getDefault()).format(ldt);
        Order order = new Order();
        order.setName("testOrder001");
        order.setAccountId(accountId);
        order.setEffectiveDate(date);
        order.setStatus("Draft");
        Map<String, String> pathParams = new HashMap<>();
        ApiResponse apiResponse = Request.execute(Endpoints.ORDERS.get(), pathParams, order, ApiMethod.POST);
        orderId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @Test(groups = "updateOrder")
    public void updateOrder() throws JsonProcessingException {
        LocalDateTime ldt = LocalDateTime.now();
        String date = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.getDefault()).format(ldt);
        Order order = new Order();
        order.setName("testOrder02");
        order.setAccountId(accountId);
        order.setEffectiveDate(date);
        order.setStatus("Draft");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), orderId);
        ApiResponse apiResponse = Request.execute(Endpoints.ORDER.get(), pathParams, order, ApiMethod.PATCH);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

    @AfterMethod(onlyForGroups = {"createOrder", "updateOrder"})
    public void deleteOrder() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), orderId);
        ApiResponse apiResponse = Request.execute(Endpoints.ORDER.get(), pathParams, ApiMethod.DELETE);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

    @AfterClass
    public void deleteAccount() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), accountId);
        ApiResponse apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, ApiMethod.DELETE);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
