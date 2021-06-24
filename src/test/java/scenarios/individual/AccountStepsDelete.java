package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsDelete {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public AccountStepsDelete(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a delete account request {string}")
    public void iBuildADeleteAccountRequest(String arg0) {
        System.out.println("=================== Account Delete Given ==============================");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
     }

    @When("I add this {string} endpoint and execute delete account request")
    public void iAddThisEndpointAndExecuteDeleteAccountRequest(String arg0) {
        System.out.println("=================== Account Delete When ==============================");
        apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);
    }

    @Then("the response status code should be {string} to delete account request")
    public void theResponseStatusCodeShouldBeToDeleteAccountRequest(String arg0) {
        System.out.println("=================== Account Delete Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
