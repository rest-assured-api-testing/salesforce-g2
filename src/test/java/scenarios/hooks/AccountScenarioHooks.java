/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package scenarios.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.config.Endpoints;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Account;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class AccountScenarioHooks {
    private Logger logger = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;

    public AccountScenarioHooks(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(value = "@GetAccounts or @GetAccount or @UpdateAccount or @DeleteAccount", order = 2)
    public void setUp() throws JsonProcessingException {
        logger.info("======================= A Account Before Hook");
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("First Account");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoints.ACCOUNTS.get(), pathParams, account);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @After(value = "@GetAccounts or @GetAccount or @UpdateAccount or @CreateAccount")
    public void setDown() {
        logger.info("======================= A Account After Hook");
        if (createdResponse.getId() != null) {
            logger.info("======================= Inside After Hook");
            logger.info("======================= " + createdResponse.getId());
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put(Endpoints.ID.get(), createdResponse.getId());
            ApiResponse apiResponse;

            apiResponse = ApiRequestManager.delete(Endpoints.ACCOUNT.get(), pathParams);

            apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
        }
        logger.info("======================= Passed if After Hook");
    }
}
