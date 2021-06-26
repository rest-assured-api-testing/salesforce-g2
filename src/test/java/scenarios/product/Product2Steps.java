/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package scenarios.product;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.entities.Product;

import java.util.HashMap;
import java.util.Map;

public class Product2Steps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Product product;

    public Product2Steps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
        pathParams = new HashMap<>();
    }

    @Given("^I build \"GIVENGETDELETEPRODUCT\" request$")
    public void iBuildADeleteProductRequest() {
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
    }

    @Given("^I build \"GIVENCREATEPRODUCT\" request$")
    public void iBuildAPostProductRequest() {
        product = new Product();
        product.setName("New incoming product");
    }

    @Given("^I build \"GIVENUPDATEPRODUCT\" request$")
    public void iBuildAUpdateProductRequest() {
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
        product = new Product();
        product.setName("New name of product");
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"GETPRODUCTS\" request$")
    public void iAddThisEndpointAndExecuteGetProductsRequest(final String endpoint) {
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"POSTPRODUCT\" request$")
    public void iAddThisEndpointAndExecutePostProductRequest(final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.create(endpoint, pathParams, product);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"PATCHPRODUCT\" request$")
    public void iAddThisEndpointAndExecutePatchProductRequest(final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.update(endpoint, pathParams, product);
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"DELETEPRODUCT\" request$")
    public void iAddThisEndpointAndExecuteDeleteProductRequest(final String endpoint) {
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @Then("^the response status code should be \"([^\"]*)\" to \"THENPRODUCTS\" request$")
    public void theResponseStatusCodeShouldBeToAllGetProductRequest(final String statusCode) {
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(statusCode)).log().body();
    }
}
