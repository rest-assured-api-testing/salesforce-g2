/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.tests;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.config.Endpoints;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Person;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
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

        apiResponse = ApiRequestManager.create(Endpoints.PEOPLE.get(), pathParams, person);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAllIndividualTest() {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoints.PEOPLE.get(), new HashMap<String, String>());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "post")
    public void createAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoints.PEOPLE.get(), pathParams, person);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAIndividualTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoints.PERSON.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "update")
    public void updateAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        Person person = new Person();
        person.setFirstName("Pedrito");
        person.setLastName("Fantasy");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.update(Endpoints.PERSON.get(), pathParams, person);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "delete")
    public void deleteAIndividualTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoints.PERSON.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @AfterMethod(onlyForGroups = {"get", "post", "update", "badDelete"})
    public void deleteCreatedOnes() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoints.PERSON.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAllIndividualTest() {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get("/Inidivua", new HashMap<String, String>());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test
    public void doNotCreateAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoints.PEOPLE.get(), pathParams, person);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAIndividualTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoints.PERSON.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = "update")
    public void doNotUpdateAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        Person person = new Person();
        person.setFirstName("Pedrito");
        person.setLastName("Fantasy 2");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.update(Endpoints.PERSON.get(), pathParams, person);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = {"delete", "badDelete"})
    public void doNotDeleteAIndividualTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoints.PERSON.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }
}
