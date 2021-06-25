package scenarios.individual;

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

public class IndividualStepsGetAll {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public IndividualStepsGetAll(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a all get request")
    public void iBuildAAllGetRequest() {
        LOGGER.info("================>>>>>>> Individual Get All Given <<<<<<<<=============");
        pathParams = new HashMap<String,String>();
    }

    @When("I add this {string} endpoint and execute all get request")
    public void iAddThisEndpointAndExecuteAllGetRequest(String endpoint) {
        LOGGER.info("================>>>>>>> Individual Get All When <<<<<<<<=============");
        apiResponse = ApiRequestManager.get(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to all get request")
    public void theResponseStatusCodeShouldBeToAllGetRequest(String status) {
        LOGGER.info("================>>>>>>> Individual Get All Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
