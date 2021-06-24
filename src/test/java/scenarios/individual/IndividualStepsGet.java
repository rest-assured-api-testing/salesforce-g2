package scenarios.individual;

import api.ApiRequestManager;
import api.ApiResponse;
import salesforce.endpointurl.ElementParam;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class IndividualStepsGet {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;

    public IndividualStepsGet(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a get request {string}")
    public void iBuildAGetRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Get Given <<<<<<<<=============");
        pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
    }

    @When("I add this {string} endpoint and execute get request")
    public void iAddThisEndpointAndExecuteGetRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Get When <<<<<<<<=============");
        apiResponse = ApiRequestManager.get(Endpoint.PERSON, pathParams);
    }

    @Then("the response status code should be {string} to get request")
    public void theResponseStatusCodeShouldBeToGetRequest(String arg0) {
        System.out.println("================>>>>>>> Individual Get Then <<<<<<<<=============");
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }
}
