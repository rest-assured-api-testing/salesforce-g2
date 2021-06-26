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

public class DeleteCampaignSteps {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;

    public DeleteCampaignSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build delete a campaign request")
    public void iBuildADeleteCampaignRequest() {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign delete Given ~~~~~~~~~~~~~~~~~~~~");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute delete a campaign request")
    public void iAddThisEndpointAndExecuteDeleteCampaignRequest(final String endpoint) {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign delete When ~~~~~~~~~~~~~~~~~~~~");
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to delete a campaign request")
    public void theResponseStatusCodeShouldBeToDeleteCampaignRequest(final String statusCode) {
        LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~ Campaign delete Then ~~~~~~~~~~~~~~~~~~~~");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
