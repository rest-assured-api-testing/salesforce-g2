package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.ElementParam;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class IndividualStepsUpdate {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;
    Person person;

    public IndividualStepsUpdate(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a update request {string}")
    public void iBuildAUpdateRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Patch Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        person = new Person();
        person.setFirstName("Pedrito");
        person.setLastName("Fantasy");
    }

    @When("I add this {string} endpoint and execute patch request")
    public void iAddThisEndpointAndExecutePatchRequest(String arg0) throws JsonProcessingException {
        System.out.println("================>>>>>>> Individual Patch When <<<<<<<<=============");
        apiResponse = ApiRequestManager.update(Endpoint.PERSON, pathParams, person);
    }

    @Then("the response status code should be {string} to patch request")
    public void theResponseStatusCodeShouldBeToPatchRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Patch Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
