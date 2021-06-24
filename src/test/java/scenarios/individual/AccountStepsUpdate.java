package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.Account;
import entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsUpdate {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;
    Account account;

    public AccountStepsUpdate(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a update account request {string}")
    public void iBuildAUpdateAccountRequest(String arg0) {
        System.out.println("=================== Account Update Given ==============================");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        account = new Account();
        account.setName("Updated Account");
    }

    @When("I add this {string} endpoint and execute patch account request")
    public void iAddThisEndpointAndExecutePatchAccountRequest(String arg0) throws JsonProcessingException {
        System.out.println("=================== Account Update When ==============================");
        apiResponse = ApiRequestManager.update(Endpoint.ACCOUNT, pathParams, account);
    }

    @Then("the response status code should be {string} to patch account request")
    public void theResponseStatusCodeShouldBeToPatchAccountRequest(String arg0) {
        System.out.println("=================== Account Update Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
