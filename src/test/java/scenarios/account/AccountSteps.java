/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;

import java.util.HashMap;
import java.util.Map;

public class AccountSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Account account;

    public AccountSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
        pathParams = new HashMap<>();
    }

    @Given("^I build \"GIVENGETDELETEACCOUNT\" request$")
    public void iBuildADeleteAccountRequest() {
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
    }

    @Given("^I build \"GIVENCREATEACCOUNT\" request$")
    public void iBuildAPostAccountRequest() {
        account = new Account();
        account.setName("First Account");
    }

    @Given("^I build \"GIVENUPDATEACCOUNT\" request$")
    public void iBuildAUpdateAccountRequest() {
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
        account = new Account();
        account.setName("Updated Account");
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"GETACCOUNTS\" request$")
    public void iAddThisEndpointAndExecuteGetAccountsRequest(final String endpoint) {
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"POSTACCOUNT\" request$")
    public void iAddThisEndpointAndExecutePostAccountRequest(final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.create(endpoint, pathParams, account);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"PATCHACCOUNT\" request$")
    public void iAddThisEndpointAndExecutePatchAccountRequest(final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.update(endpoint, pathParams, account);
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"DELETEACCOUNT\" request$")
    public void iAddThisEndpointAndExecuteDeleteAccountRequest(final String endpoint) {
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @Then("^the response status code should be \"([^\"]*)\" to \"THENACCOUNTS\" request$")
    public void theResponseStatusCodeShouldBeToAllGetAccountRequest(final String statusCode) {
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(statusCode)).log().body();
    }
}
