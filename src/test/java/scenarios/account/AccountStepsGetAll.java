package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsGetAll {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public AccountStepsGetAll(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a all get account request {string}")
    public void iBuildAAllGetAccountRequest(String arg0) {
        System.out.println("=================== Account Get All Given ==============================");
        pathParams = new HashMap<>();
    }

    @When("I add this {string} endpoint and execute all get account request")
    public void iAddThisEndpointAndExecuteAllGetAccountRequest(String arg0) {
        System.out.println("=================== Account Get All When ==============================");
        apiResponse = ApiRequestManager.get(Endpoint.ACCOUNTS, pathParams);
    }

    @Then("the response status code should be {string} to all get account request")
    public void theResponseStatusCodeShouldBeToAllGetAccountRequest(String arg0) {
        System.out.println("=================== Account Get All Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
