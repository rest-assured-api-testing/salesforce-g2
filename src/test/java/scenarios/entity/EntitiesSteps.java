/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package scenarios.entity;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.CreatedResponse;
import java.util.HashMap;
import java.util.Map;

public class EntitiesSteps {
    private Logger logger = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams = new HashMap<>();;
    private String body;

    public EntitiesSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build the pathParams and body to request")
    public void iBuildThePathParamsAndBodyToRequest(final DataTable jsonData) throws JsonProcessingException {
        logger.info("=================== Account Create Given ==============================");
        body = new ObjectMapper().writeValueAsString(jsonData.asMap(String.class, String.class));
        logger.info(body);
    }
    @Given("I build the pathParams to request")
    public void iBuildThePathParamsToRequest() {
        logger.info("=================== Account Delete Given ==============================");
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
    }
    @Given("I build the pathParams and updated body to request")
    public void iBuildThePathParamsAndUpdatedBodyToRequest(final DataTable jsonData) throws JsonProcessingException {
        logger.info("=================== Account Update Given ==============================");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
        body = new ObjectMapper().writeValueAsString(jsonData.asMap(String.class, String.class));
        logger.info(body);
    }

    @When("I add this {string} endpoint and send the request with body")
    public void iAddThisEndpointAndSendTheRequestWithBody(final String endpoint) throws JsonProcessingException {
        logger.info("=================== Account Create When ==============================");
        logger.info(body);
        apiResponse = ApiRequestManager.create(endpoint, pathParams, body);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @When("I add this {string} endpoint and send the delete request")
    public void iAddThisEndpointAndSendTheDeleteRequest(final String endpoint) {
        logger.info("=================== Account Delete When ==============================");
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @When("I add this {string} endpoint and send the request")
    public void iAddThisEndpointAndSendTheRequest(final String endpoint) {
        logger.info("=================== Account Get When ==============================");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @When("I add this {string} endpoint and send the request with updated body")
    public void iAddThisEndpointAndSendTheRequestWithUpdatedBody(final String endpoint) throws JsonProcessingException {
        logger.info("=================== Account Update When ==============================");
        apiResponse = ApiRequestManager.update(endpoint, pathParams, body);

    }

    @Then("the response status code should be {string}")
    public void theResponseStatusCodeShouldBe(final String status) {
        logger.info("=================== Account Create Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
