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
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Campaign;

import java.util.HashMap;
import java.util.Map;

public class UpdateCampaignSteps {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Campaign campaign;

    public UpdateCampaignSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build update campaign request")
    public void iBuildAUpdateCampaignRequest() {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign update Given ~~~~~~~~~~~~~~~~~~~~");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
        campaign = new Campaign();
        campaign.setName("New name of campaign");
    }

    @When("I add this {string} endpoint and execute patch campaign request")
    public void iAddThisEndpointAndExecutePatchCampaignRequest(final String endpoint) throws JsonProcessingException {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign update When ~~~~~~~~~~~~~~~~~~~~");
        apiResponse = ApiRequestManager.update(endpoint, pathParams, campaign);
    }

    @Then("the response status code should be {string} to patch campaign request")
    public void theResponseStatusCodeShouldBeToPatchCampaignRequest(final String statusCode) {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign update Then ~~~~~~~~~~~~~~~~~~~~");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
