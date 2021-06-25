package scenarios.individual;

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

public class IndividualStepsGet {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public IndividualStepsGet(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a get request")
    public void iBuildAGetRequest() {
        LOGGER.info("================>>>>>>> Individual Get Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute get request")
    public void iAddThisEndpointAndExecuteGetRequest(String endpoint) {
        LOGGER.info("================>>>>>>> Individual Get When <<<<<<<<=============");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to get request")
    public void theResponseStatusCodeShouldBeToGetRequest(String status) {
        LOGGER.info("================>>>>>>> Individual Get Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
