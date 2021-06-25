package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsGetAll {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public AccountStepsGetAll(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a all get account request")
    public void iBuildAAllGetAccountRequest() {
        LOGGER.info("=================== Account Get All Given ==============================");
        pathParams = new HashMap<>();
    }

    @When("I add this {string} endpoint and execute all get account request")
    public void iAddThisEndpointAndExecuteAllGetAccountRequest(String endpoint) {
        LOGGER.info("=================== Account Get All When ==============================");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to all get account request")
    public void theResponseStatusCodeShouldBeToAllGetAccountRequest(String status) {
        LOGGER.info("=================== Account Get All Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
