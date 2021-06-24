package tests;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.ElementParam;
import salesforce.endpointurl.Endpoint;
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

        apiResponse = ApiRequestManager.create(Endpoint.ACCOUNTS, pathParams, account);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAllAccountTest() {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoint.ACCOUNTS, new HashMap<String, String>());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "post")
    public void createAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("Created Account ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoint.ACCOUNTS, pathParams, account);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAAccountTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoint.ACCOUNT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "update")
    public void updateAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        Account account = new Account();
        account.setName("Updated Account");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.update(Endpoint.ACCOUNT, pathParams, account);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "delete")
    public void deleteAAccountTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @AfterMethod(onlyForGroups = {"get", "post", "update", "badDelete"})
    public void deleteCreatedOnes() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);

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

        apiResponse = ApiRequestManager.create(Endpoint.ACCOUNTS, pathParams, account);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST).log().body();
    }

    @Test(groups = "get")
    public void doNotGetAAccountTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, " ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoint.ACCOUNT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = "update")
    public void doNotUpdateAAccountTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, " ");
        Account account = new Account();
        account.setName("Updated Account");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.update(Endpoint.ACCOUNT, pathParams, account);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }

    @Test(groups = {"delete", "badDelete"})
    public void doNotDeleteAAccountTest() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, " ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).log().body();
    }
}
