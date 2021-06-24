package scenarios.product;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import salesforce.entities.Product;

import java.util.HashMap;
import java.util.Map;

public class CreateProductSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String, String> pathParams;
    private Product product;

    public CreateProductSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build post product request")
    public void iBuildAPostProductRequest() {
        pathParams = new HashMap<>();
        product = new Product();
        product.setName("New incoming product");
    }

    @When("I add this {string} endpoint and execute post product request")
    public void iAddThisEndpointAndExecutePostProductRequest(final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.create(endpoint, pathParams, product);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @Then("the response status code should be {string} to post product request")
    public void theResponseStatusCodeShouldBeToPostProductRequest(final String statusCode) {
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
        
    }
}
