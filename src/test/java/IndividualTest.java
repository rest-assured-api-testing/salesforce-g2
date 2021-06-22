/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
import api.ApiRequestManger;
import api.ApiResponse;
import auth.Authentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.ModifiedResponse;
import entities.Person;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Tests individual endpoint of a sales-force account.
 */
public class IndividualTest {

    Person addedPerson;
    ModifiedResponse modifiedResponse;

    /**
     * Obtains the respective token.
     */
    @BeforeSuite
    public void getToken() {
        Authentication.getAuth();
    }

    /**
     * Tests that individual endpoint creates a person.
     */
    @Test
    public void createAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManger.create(Endpoint.PEOPLE, pathParams, person);
        modifiedResponse =apiResponse.getResponse().as(ModifiedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @AfterSuite
    public void deleteCreatedOnes() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, modifiedResponse.getId());
        ApiRequestManger.delete(Endpoint.PERSON, pathParams);
    }
}
