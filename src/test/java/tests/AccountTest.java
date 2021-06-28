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

        apiResponse = ApiRequestManager.create(Endpoints.ACCOUNTS.get(), pathParams, account);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAllAccountTest() {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoints.ACCOUNTS.get(), new HashMap<String, String>());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "post")
    public void createAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("Created Account ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoints.ACCOUNTS.get(), pathParams, account);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAAccountTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoints.ACCOUNT.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "update")
    public void updateAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        Account account = new Account();
        account.setName("Updated Account");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.update(Endpoints.ACCOUNT.get(), pathParams, account);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "delete")
    public void deleteAAccountTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoints.ACCOUNT.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @AfterMethod(onlyForGroups = {"get", "post", "update", "badDelete"})
    public void deleteCreatedOnes() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoints.ACCOUNT.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAllAccountTest() {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get("/Accoun", new HashMap<String, String>());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test
    public void doNotCreateAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoints.ACCOUNTS.get(), pathParams, account);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAAccountTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoints.ACCOUNT.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = "update")
    public void doNotUpdateAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        Account account = new Account();
        account.setName("Updated Account");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.update(Endpoints.ACCOUNT.get(), pathParams, account);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = {"delete", "badDelete"})
    public void doNotDeleteAAccountTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), " ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoints.ACCOUNT.get(), pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }
}
