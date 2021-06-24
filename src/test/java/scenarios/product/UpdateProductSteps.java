package scenarios.product;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import salesforce.endpointurl.ElementParam;
import salesforce.entities.Product;
import salesforce.entities.CreatedResponse;

import java.util.HashMap;
import java.util.Map;

public class UpdateProductSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Product product;

    public UpdateProductSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build update product request {string}")
    public void iBuildAUpdateProductRequest() {
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        product = new Product();
        product.setName("New name of product");
    }

    @When("I add this {string} endpoint and execute patch product request")
    public void iAddThisEndpointAndExecutePatchProductRequest(final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.update(endpoint, pathParams, product);
    }

    @Then("the response status code should be {string} to patch product request")
    public void theResponseStatusCodeShouldBeToPatchProductRequest(final String statusCode) {
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
