package scenarios.product;

import api.ApiRequestManager;
import api.ApiResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import salesforce.endpointurl.ElementParam;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.CreatedResponse;

import java.util.HashMap;
import java.util.Map;

public class GetProductSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public GetProductSteps(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build get a product request {string}")
    public void iBuildAGetProductRequest(String arg0) {
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute get a product request")
    public void iAddThisEndpointAndExecuteGetProductRequest(String arg0) {
        apiResponse = ApiRequestManager.get(Endpoint.PRODUCT, pathParams);
    }

    @Then("the response status code should be {string} to get a product request")
    public void theResponseStatusCodeShouldBeToGetProductRequest(String arg0) {
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
