package scenarios.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import salesforce.auth.Authentication;
import salesforce.endpointurl.ElementParam;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.Account;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Order;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OrderScenarioHooks {
    private String accountId;
    private String orderId;

    public OrderScenarioHooks(String accountId, String orderId) {
        this.accountId = accountId;
        this.orderId = orderId;
    }

    @Before(order = 1)
    public void getToken() {
        Authentication.getAuth();
    }

    @Before(order = 2)
    public void setUp() throws JsonProcessingException {
        Map<String,String> pathParams = new HashMap<>();
        Account account = new Account();
        account.setName("testAccount01");
        ApiResponse apiResponse = ApiRequestManager.create(Endpoint.ACCOUNTS, pathParams, account);
        accountId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }
    @Before(value = "@GetOrder or @UpdateOrder or @DeleteOrder", order = 3)
    public void createOrder() throws JsonProcessingException {
        Map<String,String> pathParams = new HashMap<>();
        String DATE_FORMAT = "yyyy-mm-dd";
        LocalDateTime ldt = LocalDateTime.now();
        String date = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.getDefault()).format(ldt);
        Order order = new Order();
        order.setName("testOrderToUpdateAndDelete");
        order.setAccountId(accountId);
        order.setEffectiveDate(date);
        order.setStatus("Draft");
        ApiResponse apiResponse = ApiRequestManager.create(Endpoint.ORDERS, pathParams, order);
        orderId = apiResponse.getBody(CreatedResponse.class).getId();
    }

    @After(value = "@GetOrder or @UpdateOrder or @CreateOrder")
    public void setDownOrder() {
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID,orderId);
        ApiResponse apiResponse = ApiRequestManager.delete(Endpoint.ORDER, pathParams);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

    @AfterClass
    public void setDownAccount() {
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID,accountId);
        ApiResponse apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
