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
import salesforce.endpointurl.Endpoints;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static salesforce.config.EnvConfigurationFile.LOGGER;

public class IndividualStepsUpdate {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Person person;

    public IndividualStepsUpdate(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a update request")
    public void iBuildAUpdateRequest() {
        LOGGER.info("================>>>>>>> Individual Patch Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
        person = new Person();
        person.setFirstName("Pedrito");
        person.setLastName("Fantasy");
    }

    @When("I add this {string} endpoint and execute patch request")
    public void iAddThisEndpointAndExecutePatchRequest(final String endpoint) throws JsonProcessingException {
        LOGGER.info("================>>>>>>> Individual Patch When <<<<<<<<=============");
        apiResponse = ApiRequestManager.update(endpoint, pathParams, person);
    }

    @Then("the response status code should be {string} to patch request")
    public void theResponseStatusCodeShouldBeToPatchRequest(final String status) {
        LOGGER.info("================>>>>>>> Individual Patch Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
