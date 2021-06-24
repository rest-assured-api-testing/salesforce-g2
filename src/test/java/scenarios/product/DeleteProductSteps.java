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

public class DeleteProductSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;

    public DeleteProductSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build delete a product request {string}")
    public void iBuildADeleteProductRequest() {
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute delete a product request")
    public void iAddThisEndpointAndExecuteDeleteProductRequest(final String endpoint) {
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to delete a product request")
    public void theResponseStatusCodeShouldBeToDeleteProductRequest(final String statusCode) {
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
