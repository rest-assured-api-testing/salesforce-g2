package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsCreate {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;
    Account account;

    public AccountStepsCreate(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a post account request {string}")
    public void iBuildAPostAccountRequest(String arg0) {
        System.out.println("=================== Account Create Given ==============================");
        pathParams = new HashMap<>();
        account = new Account();
        account.setName("First Account");
    }

    @When("I add this {string} endpoint and execute post account request")
    public void iAddThisEndpointAndExecutePostAccountRequest(String arg0) throws JsonProcessingException {
        System.out.println("=================== Account Create When ==============================");
        apiResponse = ApiRequestManager.create(Endpoint.ACCOUNTS, pathParams, account);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @Then("the response status code should be {string} to post account request")
    public void theResponseStatusCodeShouldBeToPostAccountRequest(String arg0) {
        System.out.println("=================== Account Create Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }
}
