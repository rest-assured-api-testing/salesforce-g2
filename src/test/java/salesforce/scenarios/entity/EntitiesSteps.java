/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.scenarios.entity;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.config.Endpoints;
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

    @Given("I set the pathParams and body to request")
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
        jsonMap.put(key, createdResponse.getId());
        body = new ObjectMapper().writeValueAsString(jsonMap);
        logger.info(body);
    }
    @Given("I set the pathParams to request")
    public void iSetThePathParamsToRequest() {
        logger.info("=================== Delete and Get Given ==================");
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
    }
    @Given("I set the pathParams and updated body to request")
    public void iSetThePathParamsAndUpdatedBodyToRequest(final DataTable jsonData) throws JsonProcessingException {
        logger.info("=================== Update Given ==========================");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        body = new ObjectMapper().writeValueAsString(jsonData.asMap(String.class, String.class));
        logger.info(body);
    }

    @When("I set the {string} endpoint and send the request with body")
    public void iSetTheEndpointAndSendTheRequestWithBody(final String endpoint) throws JsonProcessingException {
        logger.info("=================== Create When ===========================");
        logger.info(body);
        apiResponse = ApiRequestManager.create(endpoint, pathParams, body);
        if (apiResponse.getStatusCode() == HttpStatus.SC_CREATED) {
            CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
            createdResponse.setId(createdResponseHelper.getId());
        }
    }

    @When("I set the {string} endpoint and send the delete request")
    public void iSetTheEndpointAndSendTheDeleteRequest(final String endpoint) {
        logger.info("=================== Delete When ===========================");
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @When("I set the {string} endpoint and send the request")
    public void iSetTheEndpointAndSendTheRequest(final String endpoint) {
        logger.info("=================== Get When ==============================");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @When("I set the {string} endpoint and send the request with updated body")
    public void iSetTheEndpointAndSendTheRequestWithUpdatedBody(final String endpoint) throws JsonProcessingException {
        logger.info("=================== Update When ===========================");
        apiResponse = ApiRequestManager.update(endpoint, pathParams, body);

    }

    @Then("the response status code should be {string}")
    public void theResponseStatusCodeShouldBe(final String status) {
        logger.info("=================== Common Then ===========================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }

    @Then("the response status code should be {string} with the {string} schema")
    public void theResponseStatusCodeShouldBe(final String status, final String schema) {
        logger.info("=================== Common Then ===========================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status));
        if (status.equals("201")) {
            apiResponse.validateBodySchema("schemas/" + schema + ".json");
        }
    }
}
