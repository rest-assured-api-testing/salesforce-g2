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
import salesforce.endpointurl.Endpoints;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class IndividualStepsDelete {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;

    public IndividualStepsDelete(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a delete request")
    public void iBuildADeleteRequest() {
        LOGGER.info("================>>>>>>> Individual Delete Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute delete request")
    public void iAddThisEndpointAndExecuteDeleteRequest(final String endpoint) {
        LOGGER.info("================>>>>>>> Individual Delete When <<<<<<<<=============");
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to delete request")
    public void theResponseStatusCodeShouldBeToDeleteRequest(final String status) {
        LOGGER.info("================>>>>>>> Individual Delete Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
