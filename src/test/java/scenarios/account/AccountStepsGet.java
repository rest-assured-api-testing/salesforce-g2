package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import salesforce.endpointurl.ElementParam;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsGet {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public AccountStepsGet(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a get account request {string}")
    public void iBuildAGetAccountRequest(String arg0) {
        System.out.println("=================== Account Get Given ==============================");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute get account request")
    public void iAddThisEndpointAndExecuteGetAccountRequest(String arg0) {
        System.out.println("=================== Account Get When ==============================");
        apiResponse = ApiRequestManager.get(Endpoint.ACCOUNT, pathParams);
    }

    @Then("the response status code should be {string} to get account request")
    public void theResponseStatusCodeShouldBeToGetAccountRequest(String arg0) {
        System.out.println("=================== Account Get Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
