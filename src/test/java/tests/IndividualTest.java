/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package tests;
import api.ApiRequestManager;
import api.ApiResponse;
import auth.Authentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import config.Param;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.ModifiedResponse;
import entities.Person;
import org.apache.http.HttpStatus;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class IndividualTest extends CommonTest {

    @BeforeMethod(onlyForGroups = {"get", "update", "delete"})
    public void create() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoint.PEOPLE, pathParams, person);
        modifiedResponse =apiResponse.getResponse().as(ModifiedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAllIndividualTest() {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoint.PEOPLE, new HashMap<String,String>());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "post")
    public void createAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoint.PEOPLE, pathParams, person);
        modifiedResponse =apiResponse.getResponse().as(ModifiedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAIndividualTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, modifiedResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoint.PERSON, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "update")
    public void updateAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, modifiedResponse.getId());
        Person person = new Person();
        person.setFirstName("Pedrito");
        person.setLastName("Fantasy");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.update(Endpoint.PERSON, pathParams, person);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "delete")
    public void deleteAIndividualTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, modifiedResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.PERSON, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @AfterMethod(onlyForGroups = {"get", "post", "update"})
    public void deleteCreatedOnes() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, modifiedResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.PERSON, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

}
