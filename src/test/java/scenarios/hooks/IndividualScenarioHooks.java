package scenarios.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import salesforce.auth.Authentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.ElementParam;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Person;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class IndividualScenarioHooks {

    private CreatedResponse createdResponse;

    public IndividualScenarioHooks(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(order = 1)
    public void getToken() {
        Authentication.getAuth();
    }

    @Before(value = "@GetIndividuals or @GetIndividual or @UpdateIndividual or @DeleteIndividual", order = 2)
    public void setUp() throws JsonProcessingException {
        System.out.println("======================= A Individual Before Hook");
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoint.PEOPLE, pathParams, person);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @After(value = "@GetIndividuals or @GetIndividual or @UpdateIndividual or @CreateIndividual")
    public void setDown() {
        System.out.println("======================= A Individual After Hook");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.PERSON, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
