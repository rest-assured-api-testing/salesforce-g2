package scenarios.order;

import api.ApiRequest;
import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderStepsCreate {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams = new HashMap<>();
    private String accountId;
    private String orderId;
    private Order order;

    public OrderStepsCreate(String accountId, String orderId) {
        this.accountId = accountId;
        this.orderId = orderId;
    }

    @Given("I create a body payload")
    public void iCreateABodyPayload(DataTable jsonData) throws JsonProcessingException {

        String body = new ObjectMapper().writeValueAsString(jsonData.asMap(String.class,String.class));
        ObjectMapper mapper = new ObjectMapper();
        order = mapper.convertValue(body, Order.class);
    }

    @When("I add the {string} endpoint and execute a {string} request")
    public void iAddThisEndpointAndExecuteTheRequest(String endpoint, String request) throws JsonProcessingException {
        apiResponse = ApiRequestManager.create(endpoint, pathParams, order);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);
    }

    @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatus) {
        apiResponse.getResponse().then().assertThat().statusCode(expectedStatus).log().body();
    }
}
