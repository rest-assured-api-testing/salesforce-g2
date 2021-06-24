package scenarios.product;

import api.ApiRequestManager;
import api.ApiResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import salesforce.endpointurl.ElementParam;
import salesforce.entities.CreatedResponse;

import java.util.HashMap;
import java.util.Map;

public class GetProductSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;

    public GetProductSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build get a product request")
    public void iBuildAGetProductRequest() {
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute get a product request")
    public void iAddThisEndpointAndExecuteGetProductRequest(final String endpoint) {
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to get a product request")
    public void theResponseStatusCodeShouldBeToGetProductRequest(final String statusCode) {
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
