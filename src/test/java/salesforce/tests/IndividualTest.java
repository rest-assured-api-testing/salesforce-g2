/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.tests;

import api.ApiMethod;
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

        apiResponse = ApiRequestManager.execute(Endpoints.PEOPLE.get(), pathParams, person, ApiMethod.POST);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAllIndividualTest() throws JsonProcessingException {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute(Endpoints.PEOPLE.get(), new HashMap<String, String>(), ApiMethod.GET);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "post")
    public void createAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        person.setFirstName("Pepito");
        person.setLastName("Flores");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute(Endpoints.PEOPLE.get(), pathParams, person, ApiMethod.POST);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute(Endpoints.PERSON.get(), pathParams, ApiMethod.GET);

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

        apiResponse = ApiRequestManager.execute(Endpoints.PERSON.get(), pathParams, person, ApiMethod.PATCH);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "delete")
    public void deleteAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute(Endpoints.PERSON.get(), pathParams, ApiMethod.DELETE);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @AfterMethod(onlyForGroups = {"get", "post", "update", "badDelete"})
    public void deleteCreatedOnes() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute(Endpoints.PERSON.get(), pathParams, ApiMethod.DELETE);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAllIndividualTest() throws JsonProcessingException {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute("/Inidivua", new HashMap<String, String>(), ApiMethod.GET);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test
    public void doNotCreateAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Person person = new Person();
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute(Endpoints.PEOPLE.get(), pathParams, person, ApiMethod.POST);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute(Endpoints.PERSON.get(), pathParams, ApiMethod.GET);

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

        apiResponse = ApiRequestManager.execute(Endpoints.PERSON.get(), pathParams, person, ApiMethod.PATCH);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = {"delete", "badDelete"})
    public void doNotDeleteAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.execute(Endpoints.PERSON.get(), pathParams, ApiMethod.DELETE);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }
}
