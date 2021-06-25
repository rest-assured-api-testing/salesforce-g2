package scenarios.account;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class AccountStepsCreate {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Map<String,String> pathParams;
    Account account;

    public AccountStepsCreate(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I build a post account request")
    public void iBuildAPostAccountRequest(DataTable jsonData) throws JsonProcessingException {
        LOGGER.info("=================== Account Create Given ==============================");
        pathParams = new HashMap<>();
        account = new Account();
        account.setName("First Account");
    }

    @When("I add this {string} endpoint and execute post account request")
    public void iAddThisEndpointAndExecutePostAccountRequest(String endpoint) throws JsonProcessingException {
        LOGGER.info("=================== Account Create When ==============================");
        apiResponse = ApiRequestManager.create(endpoint, pathParams, account);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
    }

    @Then("the response status code should be {string} to post account request")
    public void theResponseStatusCodeShouldBeToPostAccountRequest(String status) {
        LOGGER.info("=================== Account Create Then ==============================");
        apiResponse.getResponse().then().assertThat().statusCode(Integer.parseInt(status)).log().body();
    }
}
