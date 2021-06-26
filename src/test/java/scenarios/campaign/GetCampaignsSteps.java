/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package scenarios.campaign;

import api.ApiRequestManager;
import api.ApiResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.entities.CreatedResponse;

import java.util.HashMap;
import java.util.Map;

public class GetCampaignsSteps {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;

    public GetCampaignsSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build get campaigns request")
    public void iBuildAAllGetCampaignRequest() {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaigns get Given ~~~~~~~~~~~~~~~~~~~~");
        pathParams = new HashMap<>();
    }

    @When("I add this {string} endpoint and execute get campaigns request")
    public void iAddThisEndpointAndExecuteAllGetCampaignRequest(final String endpoint) {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaigns get When ~~~~~~~~~~~~~~~~~~~~");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to get campaigns request")
    public void theResponseStatusCodeShouldBeToAllGetCampaignRequest(final String statusCode) {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaigns get Then ~~~~~~~~~~~~~~~~~~~~");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
