/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package rest.salesforce.com.scenarios.entity;

import api.ApiMethod;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.config.Endpoints;
import salesforce.config.Request;
import salesforce.entities.CreatedResponse;
import salesforce.entities.RequisiteElement;

/**
 * Definition of the steps for all entities
 */
public class EntitiesSteps {
    private Logger logger = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private RequisiteElement requisiteElement;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams = new HashMap<>();
    private String body;

    public EntitiesSteps(final CreatedResponse createdResponse, final RequisiteElement requisiteElement) {
        this.createdResponse = createdResponse;
        this.requisiteElement = requisiteElement;
    }

    @Given("I set the post request")
    public void iSetThePathParamsAndBodyToRequest(final DataTable jsonData) throws JsonProcessingException {
        logger.info("=================== Create Given ==========================");
        body = new ObjectMapper().writeValueAsString(jsonData.asMap(String.class, String.class));
        logger.info(body);
    }

    @Given("I set the pathParams and body with the requisite key {string} for the request")
    public void iSetThePathParamsAndBodyWithTheRequisiteKeyForTheRequest(final String key, final DataTable jsonData) throws JsonProcessingException {
        logger.info("=================== Create Given ==========================");
        Map<String, String> json = jsonData.asMap(String.class, String.class);
        Map<String, String> jsonMap = new HashMap<>(json);
        jsonMap.put(key, requisiteElement.getId());
        body = new ObjectMapper().writeValueAsString(jsonMap);
        logger.info(body);
    }
    
    @Given("I set the {string} request")
    public void iSetTheRequest(final String method) {
        logger.info("=================== Delete and Get Given ==================");
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
    }

    @Given("I set the update request")
    public void iSetThePathParamsAndUpdatedBodyToRequest(final DataTable jsonData) throws JsonProcessingException {
        logger.info("=================== Update Given ==========================");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        body = new ObjectMapper().writeValueAsString(jsonData.asMap(String.class, String.class));
        logger.info(body);
    }

    @Given("I set the pathParams and updated body with the requisite key {string} for the request")
    public void iSetThePathParamsAndUpdatedBodyWithTheRequisiteKeyForTheRequest(final String key, final DataTable jsonData) throws JsonProcessingException {
        logger.info("=================== Create Given ==========================");
        Map<String, String> json = jsonData.asMap(String.class, String.class);
        Map<String, String> jsonMap = new HashMap<>(json);
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        jsonMap.put(key, requisiteElement.getId());
        body = new ObjectMapper().writeValueAsString(jsonMap);
        logger.info(body);
    }

    @When("I set the {string} endpoint and send the request with body")
    public void iSetTheEndpointAndSendTheRequestWithBody(final String endpoint) throws JsonProcessingException {
        logger.info("=================== Create When ===========================");
        logger.info(body);
        apiResponse = Request.execute(endpoint, pathParams, body, ApiMethod.POST);
        if (apiResponse.getStatusCode() == HttpStatus.SC_CREATED) {
            CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
            createdResponse.setId(createdResponseHelper.getId());
        }
    }

    @When("I send {string} delete request")
    public void iSetTheEndpointAndSendTheDeleteRequest(final String endpoint) throws JsonProcessingException {
        logger.info("=================== Delete When ===========================");
        apiResponse = Request.execute(endpoint, pathParams, ApiMethod.DELETE);
    }

    @When("I set the {string} endpoint and send the request")
    public void iSetTheEndpointAndSendTheRequest(final String endpoint) throws JsonProcessingException {
        logger.info("=================== Get When ==============================");
        apiResponse = Request.execute(endpoint, pathParams, ApiMethod.GET);
    }

    @When("I set the {string} endpoint and send the request with updated body")
    public void iSetTheEndpointAndSendTheRequestWithUpdatedBody(final String endpoint) throws JsonProcessingException {
        logger.info("=================== Update When ===========================");
        apiResponse = Request.execute(endpoint, pathParams, body, ApiMethod.PATCH);

    }

    @Then("the response status code should be {string}")
    public void theResponseStatusCodeShouldBe(final String status) {
        logger.info("=================== Common Then ===========================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }

    @Then("Validate {string} schema")
    public void validateTheSchema(final String schema) {
        logger.info("=================== Common Then ===========================");
        if (apiResponse.getStatusCode() == HttpStatus.SC_CREATED) {
            apiResponse.validateBodySchema("schemas/" + schema + ".json");
        }
    }
}
