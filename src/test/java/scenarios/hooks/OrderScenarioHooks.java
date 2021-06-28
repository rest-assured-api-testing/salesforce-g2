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
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    private Logger logger = LogManager.getLogger(getClass());
    public static final String DATE_FORMAT = "yyyy-mm-dd";
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private String accountId;

    public OrderScenarioHooks(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(value = "@CreateOrder", order = 2)
    public void createAccount() throws JsonProcessingException {
        logger.info("*** Create Account to test Orders ***");
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("testAccount01");
        ApiResponse apiResponse = ApiRequestManager.create(Endpoints.ACCOUNTS.get(), pathParams, account);
        createdResponse.setId(apiResponse.getBody(CreatedResponse.class).getId());
        accountId = createdResponse.getId();
    }

    @Before(value = "@GetOrder or @UpdateOrder or @DeleteOrder", order = 3)
    public void createOrder() throws JsonProcessingException {
        logger.info("*** Create an Order to test operations ***");
        Map<String, String> pathParams = new HashMap<>();
        LocalDateTime ldt = LocalDateTime.now();
        String date = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.getDefault()).format(ldt);
        Order order = new Order();
        order.setName("testOrder");
        order.setAccountId(accountId);
        order.setEffectiveDate(date);
        order.setStatus("Draft");
        ApiResponse apiResponse = ApiRequestManager.create(Endpoints.ORDERS.get(), pathParams, order);
        createdResponse.setId(apiResponse.getBody(CreatedResponse.class).getId());
    }

    @After(value = "@GetOrder or @UpdateOrder or @CreateOrder")
    public void setDownAccount() {
        logger.info("*** Delete created Account ***");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), accountId);
        apiResponse = ApiRequestManager.delete(Endpoints.ACCOUNT.get(), pathParams);
    }
}
