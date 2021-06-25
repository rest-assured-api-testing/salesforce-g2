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

public class IndividualStepsDelete {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public IndividualStepsDelete(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a delete request")
    public void iBuildADeleteRequest() {
        LOGGER.info("================>>>>>>> Individual Delete Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute delete request")
    public void iAddThisEndpointAndExecuteDeleteRequest(String endpoint) {
        LOGGER.info("================>>>>>>> Individual Delete When <<<<<<<<=============");
        apiResponse = ApiRequestManager.delete(endpoint, pathParams);
    }

    @Then("the response status code should be {string} to delete request")
    public void theResponseStatusCodeShouldBeToDeleteRequest(String status) {
        LOGGER.info("================>>>>>>> Individual Delete Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
