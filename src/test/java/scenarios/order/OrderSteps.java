/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package scenarios.order;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Order;
import static scenarios.hooks.OrderScenarioHooks.accountId;
import java.util.HashMap;
import java.util.Map;

public class OrderSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Order order;
    private Map<String,String> pathParams = new HashMap<>();

    public OrderSteps(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I create a body payload")
    public void iCreateABodyPayload() {
        order = new Order();
        order.setAccountId(accountId);
    }

    @And("I set the name value to {string}")
    public void iSetProjectName(String name) {
        order.setName(name);
    }

    @And("I set the effectiveDate value to {string}")
    public void iSetTheEffectiveDateValueTo(String effectiveDate) {
        order.setEffectiveDate(effectiveDate);
    }
    @And("I set the status to {string}")
    public void iSetTheStatusTo(String status) {
        order.setStatus(status);
    }

    @When("I execute a {string} request with the {string} endpoint")
    public void iExecuteARequestWithTheEndpoint(String method, String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.create(endpoint, pathParams, order);
    }

    @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatus) {
        apiResponse.getResponse().then().assertThat().statusCode(expectedStatus).log().body();
    }
}
