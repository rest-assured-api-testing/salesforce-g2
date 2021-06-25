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

public class AccountStepsUpdate {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Account account;

    public AccountStepsUpdate(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a update account request")
    public void iBuildAUpdateAccountRequest() {
        LOGGER.info("=================== Account Update Given ==============================");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
        account = new Account();
        account.setName("Updated Account");
    }

    @When("I add this {string} endpoint and execute patch account request")
    public void iAddThisEndpointAndExecutePatchAccountRequest(final String endpoint) throws JsonProcessingException {
        LOGGER.info("=================== Account Update When ==============================");
        apiResponse = ApiRequestManager.update(Endpoints.ACCOUNT.getEndpoint(), pathParams, account);
    }

    @Then("the response status code should be {string} to patch account request")
    public void theResponseStatusCodeShouldBeToPatchAccountRequest(final String status) {
        LOGGER.info("=================== Account Update Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
