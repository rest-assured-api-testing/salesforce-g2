/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Person;

import java.util.HashMap;
import java.util.Map;

public class IndividualSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Person person;

    public IndividualSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
        pathParams = new HashMap<>();
    }

    @Given("^I build \"GIVENGETDELETEINDIVIDUAL\" request$")
    public void iBuildADeleteIndividualRequest() {
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
    }

    @Given("^I build \"GIVENCREATEINDIVIDUAL\" request$")
    public void iBuildAPostIndividualRequest() {
        person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
    }

    @Given("^I build \"GIVENUPDATEINDIVIDUAL\" request$")
    public void iBuildAUpdateIndividualRequest() {
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
        person = new Person();
        person.setFirstName("Pedrito");
        person.setLastName("Fantasy");
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"GETINDIVIDUALS\" request$")
    public void iAddThisEndpointAndExecuteGetIndividualsRequest(final String endpoint) {
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"POSTINDIVIDUAL\" request$")
    public void iAddThisEndpointAndExecutePostIndividualRequest(final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.create(endpoint, pathParams, person);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"PATCHINDIVIDUAL\" request$")
    public void iAddThisEndpointAndExecutePatchIndividualRequest(final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.update(endpoint, pathParams, person);
    }

    @When("^I add this \"([^\"].*?)\" endpoint and execute \"DELETEINDIVIDUAL\" request$")
    public void iAddThisEndpointAndExecuteDeleteIndividualRequest(final String endpoint) {
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @Then("^the response status code should be \"([^\"]*)\" to \"THENINDIVIDUALS\" request$")
    public void theResponseStatusCodeShouldBeToAllGetIndividualRequest(final String statusCode) {
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(statusCode)).log().body();
    }
}
