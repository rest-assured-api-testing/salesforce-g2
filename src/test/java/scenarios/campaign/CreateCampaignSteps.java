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
import salesforce.entities.CreatedResponse;
import salesforce.entities.Campaign;

import java.util.HashMap;
import java.util.Map;

public class CreateCampaignSteps {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Campaign campaign;

    public CreateCampaignSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build post campaign request")
    public void iBuildAPostCampaignRequest() {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign create Given ~~~~~~~~~~~~~~~~~~~~");
        pathParams = new HashMap<>();
        campaign = new Campaign();
        campaign.setName("New incoming campaign");
    }

    @When("I add this {string} endpoint and execute post campaign request")
    public void iAddThisEndpointAndExecutePostCampaignRequest(final String endpoint) throws JsonProcessingException {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign create When ~~~~~~~~~~~~~~~~~~~~");
        apiResponse = ApiRequestManager.create(endpoint, pathParams, campaign);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @Then("the response status code should be {string} to post campaign request")
    public void theResponseStatusCodeShouldBeToPostCampaignRequest(final String statusCode) {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign create Then ~~~~~~~~~~~~~~~~~~~~");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();

    }
}
