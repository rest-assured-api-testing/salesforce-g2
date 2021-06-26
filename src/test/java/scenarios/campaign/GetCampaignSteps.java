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
import salesforce.endpointurl.Endpoints;
import salesforce.entities.CreatedResponse;

import java.util.HashMap;
import java.util.Map;

public class GetCampaignSteps {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;

    public GetCampaignSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build get a campaign request")
    public void iBuildAGetCampaignRequest() {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign get Given ~~~~~~~~~~~~~~~~~~~~");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute get a campaign request")
    public void iAddThisEndpointAndExecuteGetCampaignRequest(final String endpoint) {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign get When ~~~~~~~~~~~~~~~~~~~~");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to get a campaign request")
    public void theResponseStatusCodeShouldBeToGetCampaignRequest(final String statusCode) {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign get Then ~~~~~~~~~~~~~~~~~~~~");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
