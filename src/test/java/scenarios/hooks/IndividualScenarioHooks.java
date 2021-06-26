/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package scenarios.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Person;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class IndividualScenarioHooks {
    private Logger logger = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;

    public IndividualScenarioHooks(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(value = "@GetIndividuals or @GetIndividual or @UpdateIndividual or @DeleteIndividual", order = 2)
    public void setUp() throws JsonProcessingException {
        logger.info("======================= A Individual Before Hook");
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoints.PEOPLE.get(), pathParams, person);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @After(value = "@GetIndividuals or @GetIndividual or @UpdateIndividual or @CreateIndividual")
    public void setDown() {
        logger.info("======================= A Individual After Hook");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoints.PERSON.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
