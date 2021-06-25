package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class IndividualStepsCreate {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;
    Person person;

    public IndividualStepsCreate(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a post request")
    public void iBuildAPostRequest() {
        LOGGER.info("================>>>>>>> Individual Post Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
    }

    @When("I add this {string} endpoint and execute post request")
    public void iAddThisEndpointAndExecutePostRequest(String endpoint) throws JsonProcessingException {
        LOGGER.info("================>>>>>>> Individual Post When <<<<<<<<=============");
        apiResponse = ApiRequestManager.create(endpoint, pathParams, person);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @Then("the response status code should be {string} to post request")
    public void theResponseStatusCodeShouldBeToPostRequest(String status) {
        LOGGER.info("================>>>>>>> Individual Post Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
