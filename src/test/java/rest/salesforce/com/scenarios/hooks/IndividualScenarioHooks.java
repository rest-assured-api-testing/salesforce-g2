/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */

package rest.salesforce.com.scenarios.hooks;

import api.ApiMethod;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.config.Endpoints;
import salesforce.config.Request;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Person;
import salesforce.entities.RequisiteElement;

/**
 * Scenario hooks for individual entity.
 */
public class IndividualScenarioHooks {
    private Logger logger = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private RequisiteElement requisiteElement;

    public IndividualScenarioHooks(final CreatedResponse createdResponse, final RequisiteElement requisiteElement) {
        this.createdResponse = createdResponse;
        this.requisiteElement = requisiteElement;
    }

    @Before(value = "@GetIndividuals or @GetIndividual or @UpdateIndividual or @DeleteIndividual", order = 2)
    public void setUp() throws JsonProcessingException {
        logger.info("======================= A Individual Before Hook");
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
        ApiResponse apiResponse;
        apiResponse = Request.execute(Endpoints.PEOPLE.get(), pathParams, person, ApiMethod.POST);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());

    }

    @After(value = "@GetIndividuals or @GetIndividual or @UpdateIndividual or @CreateIndividual")
    public void setDown() throws JsonProcessingException {
        logger.info("======================= A Individual After Hook");
        if (createdResponse.getId() != null) {
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put(Endpoints.ID.get(), createdResponse.getId());
            ApiResponse apiResponse;
            apiResponse = Request.execute(Endpoints.PERSON.get(), pathParams, ApiMethod.DELETE);
        }
    }
}
