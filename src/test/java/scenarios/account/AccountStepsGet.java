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
import salesforce.endpointurl.Endpoints;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsGet {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;

    public AccountStepsGet(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a get account request")
    public void iBuildAGetAccountRequest() {
        LOGGER.info("=================== Account Get Given ==============================");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute get account request")
    public void iAddThisEndpointAndExecuteGetAccountRequest(final String endpoint) {
        LOGGER.info("=================== Account Get When ==============================");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to get account request")
    public void theResponseStatusCodeShouldBeToGetAccountRequest(final String status) {
        LOGGER.info("=================== Account Get Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
