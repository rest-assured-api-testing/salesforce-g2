package scenarios.individual.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import auth.Authentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.CreatedResponse;
import entities.Person;
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
        System.out.println("======================= A Before Hooks");
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
        System.out.println("======================= A After Hooks");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.PERSON, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
