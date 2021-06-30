/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package rest.salesforce.com.tests;

import api.ApiMethod;
import salesforce.config.Request;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.config.Endpoints;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Account;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class AccountTest extends CommonTest {

    @BeforeMethod(onlyForGroups = {"get", "update", "delete"})
    public void create() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("First Account");
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNTS.get(), pathParams, account, ApiMethod.POST);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAllAccountTest() throws JsonProcessingException {
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNTS.get(), new HashMap<String, String>(), ApiMethod.GET);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "post")
    public void createAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("Created Account ");
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNTS.get(), pathParams, account, ApiMethod.POST);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, ApiMethod.GET);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "update")
    public void updateAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        Account account = new Account();
        account.setName("Updated Account");
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, account, ApiMethod.PATCH);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "delete")
    public void deleteAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, ApiMethod.DELETE);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @AfterMethod(onlyForGroups = {"get", "post", "update", "badDelete"})
    public void deleteCreatedOnes() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, ApiMethod.DELETE);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAllAccountTest() throws JsonProcessingException {
        ApiResponse apiResponse;

        apiResponse = Request.execute("/Accoun", new HashMap<String, String>(), ApiMethod.GET);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test
    public void doNotCreateAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNTS.get(), pathParams, account, ApiMethod.POST);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, ApiMethod.GET);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = "update")
    public void doNotUpdateAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        Account account = new Account();
        account.setName("Updated Account");
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, account, ApiMethod.PATCH);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = {"delete", "badDelete"})
    public void doNotDeleteAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        ApiResponse apiResponse;

        apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, ApiMethod.DELETE);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }
}
