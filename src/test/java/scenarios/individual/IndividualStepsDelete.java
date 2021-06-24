package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class IndividualStepsDelete {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public IndividualStepsDelete(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a delete request {string}")
    public void iBuildADeleteRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Delete Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute delete request")
    public void iAddThisEndpointAndExecuteDeleteRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Delete When <<<<<<<<=============");
        apiResponse = ApiRequestManager.delete(Endpoint.PERSON, pathParams);
    }

    @Then("the response status code should be {string} to delete request")
    public void theResponseStatusCodeShouldBeToDeleteRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Delete Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
