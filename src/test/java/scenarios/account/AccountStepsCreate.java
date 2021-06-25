/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static salesforce.config.EnvConfigurationFile.LOGGER;

public class AccountStepsCreate {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Account account;

    public AccountStepsCreate(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a post account request")
    public void iBuildAPostAccountRequest() {
        LOGGER.info("=================== Account Create Given ==============================");
        pathParams = new HashMap<>();
        account = new Account();
        account.setName("First Account");
    }

    @When("I add this {string} endpoint and execute post account request")
    public void iAddThisEndpointAndExecutePostAccountRequest(final String endpoint) throws JsonProcessingException {
        LOGGER.info("=================== Account Create When ==============================");
        apiResponse = ApiRequestManager.create(Endpoints.ACCOUNTS.getEndpoint(), pathParams, account);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @Then("the response status code should be {string} to post account request")
    public void theResponseStatusCodeShouldBeToPostAccountRequest(final String status) {
        LOGGER.info("=================== Account Create Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
