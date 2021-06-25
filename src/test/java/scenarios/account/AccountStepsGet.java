package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.endpointurl.ElementParam;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsGet {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public AccountStepsGet(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a get account request")
    public void iBuildAGetAccountRequest() {
        LOGGER.info("=================== Account Get Given ==============================");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute get account request")
    public void iAddThisEndpointAndExecuteGetAccountRequest(String endpoint) {
        LOGGER.info("=================== Account Get When ==============================");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to get account request")
    public void theResponseStatusCodeShouldBeToGetAccountRequest(String status) {
        LOGGER.info("=================== Account Get Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
