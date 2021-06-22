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
import entities.Person;
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
        person.setFirstname("Pepito");
        person.setLastname("Flores");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManger.create("Individual", pathParams, person);
        addedPerson =apiResponse.getResponse().as(Person.class);

        apiResponse.getResponse().then().assertThat().statusCode(200).log().body();

    }
}
