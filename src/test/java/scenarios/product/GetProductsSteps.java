package scenarios.product;

import api.ApiRequestManager;
import api.ApiResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import salesforce.entities.CreatedResponse;

import java.util.HashMap;
import java.util.Map;

public class GetProductsSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;

    public GetProductsSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build get products request {string}")
    public void iBuildAAllGetProductRequest() {
        pathParams = new HashMap<>();
    }

    @When("I add this {string} endpoint and execute get products request")
    public void iAddThisEndpointAndExecuteAllGetProductRequest(final String endpoint) {
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to get products request")
    public void theResponseStatusCodeShouldBeToAllGetProductRequest(final String statusCode) {
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
