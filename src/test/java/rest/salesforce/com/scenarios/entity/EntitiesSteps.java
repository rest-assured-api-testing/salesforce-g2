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

import io.cucumber.java.sl.In;
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
    private Map<String, String> bodyMap;
    private String body;
    private ApiMethod apiMethod;

    public EntitiesSteps(final CreatedResponse createdResponse, final RequisiteElement requisiteElement) {
        this.createdResponse = createdResponse;
        this.requisiteElement = requisiteElement;
    }

    @Given("^I set a \"(GET|DELETE)\" request$")
    public void iSetAGetDeleteRequest(final String method) {
        logger.info("=================== I Set a Request ==========================");
        apiMethod = Enum.valueOf(ApiMethod.class, method);
    }

    @Given("^I set a \"(POST|PATCH)\" request with payload$")
    public void iSetAPatchPostRequestWithPayload(final String method, final DataTable jsonData) {
        logger.info("=================== Given I Set A Request With Payload ==========================");
        Map<String, String> json = jsonData.asMap(String.class, String.class);
        bodyMap = new HashMap<>(json);
        apiMethod = Enum.valueOf(ApiMethod.class, method);
        logger.info(body);
    }

    @Given("^I set the ID path parameter$")
    public void iSetTheIDPathParameter() {
        logger.info("=================== I Set The Id Path Parameter ==========================");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
    }

    @Given("^I add the required \"(.*?)\" field to the payload$")
    public void iAddTheRequiredFieldToThePayload(String key) {
        logger.info("=================== I add the required field to the Payload ==========================");
        bodyMap.put(key, requisiteElement.getId());
    }

    @When("^I send the request with the \"(.*?)\" endpoint$")
    public void iSendTheRequestWithTheEndpoint(final String endpoint) throws JsonProcessingException {
        logger.info("=================== I Send The Request ===========================");
        body = new ObjectMapper().writeValueAsString(bodyMap);
        if (apiMethod == ApiMethod.POST || apiMethod == ApiMethod.PATCH) {
            apiResponse = Request.execute(endpoint, pathParams, body, apiMethod);
        } else {
            apiResponse = Request.execute(endpoint, pathParams, apiMethod);
        }
        apiResponse.logAll();
    }

    @Then("^the response status code should be \"(.*?)\"$")
    public void theResponseStatusCodeShouldBe(final String status) {
        logger.info("=================== Validate Response Status ===========================");
        if (apiResponse.getStatusCode() == HttpStatus.SC_CREATED){
            CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
            createdResponse.setId(createdResponseHelper.getId());
        }
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }

    @Then("^its schema should match the \"(.*?)\" schema$")
    public void itsSchemaShouldMatchTheSchema(final String schema) {
        logger.info("=================== Validate Schema ===========================");
            apiResponse.validateBodySchema("schemas/" + schema + ".json");
    }
}
