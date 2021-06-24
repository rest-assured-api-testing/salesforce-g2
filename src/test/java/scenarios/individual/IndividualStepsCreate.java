package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpointurl.Endpoint;
import entities.CreatedResponse;
import entities.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class IndividualStepsCreate {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;
    Person person;

    public IndividualStepsCreate(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a post request {string}")
    public void iBuildAPostRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Post Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
    }

    @When("I add this {string} endpoint and execute post request")
    public void iAddThisEndpointAndExecutePostRequest(String arg0) throws JsonProcessingException {
        System.out.println("================>>>>>>> Individual Post When <<<<<<<<=============");
        apiResponse = ApiRequestManager.create(Endpoint.PEOPLE, pathParams, person);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @Then("the response status code should be {string} to post request")
    public void theResponseStatusCodeShouldBeToPostRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Post Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }
}
