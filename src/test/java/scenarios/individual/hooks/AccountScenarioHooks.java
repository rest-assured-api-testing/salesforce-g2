package scenarios.individual.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.CreatedResponse;
import entities.Account;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class AccountScenarioHooks {
    private CreatedResponse createdResponse;

    public AccountScenarioHooks(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(value = "@GetAccounts or @GetAccount or @UpdateAccount or @DeleteAccount", order = 2)
    public void setUp() throws JsonProcessingException {
        System.out.println("======================= A Account Before Hook");
        Map<String, String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("First Account");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoint.ACCOUNTS, pathParams, account);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @After(value = "@GetAccounts or @GetAccount or @UpdateAccount or @CreateAccount")
    public void setDown() {
        System.out.println("======================= A Account After Hook");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
