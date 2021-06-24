package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import endpointurl.Endpoint;
import entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class IndividualStepsGetAll {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public IndividualStepsGetAll(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a all get request {string}")
    public void iBuildAAllGetRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Get All Given <<<<<<<<=============");
        pathParams = new HashMap<String,String>();
    }

    @When("I add this {string} endpoint and execute all get request")
    public void iAddThisEndpointAndExecuteAllGetRequest(String endpoint) {
        System.out.println("================>>>>>>> Individual Get All When <<<<<<<<=============");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to all get request")
    public void theResponseStatusCodeShouldBeToAllGetRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Get All Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
