package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.endpointurl.ElementParam;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsUpdate {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;
    Account account;

    public AccountStepsUpdate(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a update account request")
    public void iBuildAUpdateAccountRequest() {
        LOGGER.info("=================== Account Update Given ==============================");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        account = new Account();
        account.setName("Updated Account");
    }

    @When("I add this {string} endpoint and execute patch account request")
    public void iAddThisEndpointAndExecutePatchAccountRequest(String endpoint) throws JsonProcessingException {
        LOGGER.info("=================== Account Update When ==============================");
        apiResponse = ApiRequestManager.update(endpoint, pathParams, account);
    }

    @Then("the response status code should be {string} to patch account request")
    public void theResponseStatusCodeShouldBeToPatchAccountRequest(String status) {
        LOGGER.info("=================== Account Update Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
