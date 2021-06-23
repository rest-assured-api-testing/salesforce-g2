package tests;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.CreatedResponse;
import entities.Account;
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
        createdResponse =apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAllIndividualTest() {
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoint.ACCOUNTS, new HashMap<String,String>());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();
    }

    @Test(groups = "post")
    public void createAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("Created Account ");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoint.ACCOUNTS, pathParams, account);
        createdResponse =apiResponse.getResponse().as(CreatedResponse.class);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @Test(groups = "get")
    public void getAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.get(Endpoint.ACCOUNT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK).log().body();

    }

    @Test(groups = "update")
    public void updateAIndividualTest() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        Account account = new Account();
        account.setName("Updated Account");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.update(Endpoint.ACCOUNT, pathParams, account);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @Test(groups = "delete")
    public void deleteAIndividualTest(){
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }

    @AfterMethod(onlyForGroups = {"get", "post", "update"})
    public void deleteCreatedOnes() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
