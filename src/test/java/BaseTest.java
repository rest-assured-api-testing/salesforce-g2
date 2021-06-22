/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
import Commons.ConfigurationManager;
import Commons.GeneralConfig;
import api.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Represents the base test with the setup to be used in a test.
 */
@SuppressWarnings("unchecked")
public class BaseTest {

    ApiRequest apiRequest = new ApiRequest();
    ApiResponse apiResponse;
    private String username;
    private String password;
    private String client_id;
    private String client_secret;
    private String security_token;
    protected String token;
    protected String base_url;
    private String login_url;
    private long token_generated_time;
    private long token_duration;

    /**
     * Sets the credential values to be used in tests.
     */
    @BeforeClass
    public void setup() {
        GeneralConfig generalConfig= ConfigurationManager.getConfiguration();
        username = generalConfig.username();
        password = generalConfig.password();
        client_id = generalConfig.client_id();
        client_secret = generalConfig.client_secret();
        security_token = generalConfig.security_token();
        base_url = generalConfig.base_url();
        login_url = generalConfig.login_url();
        token_duration = generalConfig.token_duration();
        generateToken();
    }

    /**
     * Generates a token by making a request with the set parameters and sets the time of generation for the token.
     */
    private void generateToken() {
        apiRequest = new ApiRequestBuilder()
                .setBaseUri(login_url)
                .setMethod(RequestMethod.POST)
                .addFormParam("username", this.username)
                .addFormParam("password", password + security_token)
                .addFormParam("grant_type", "password")
                .addFormParam("client_id", client_id)
                .addFormParam("client_secret", client_secret)
                .build();
        apiResponse = ApiManager.execute(apiRequest);
        token = apiResponse.getJsonPath().get("access_token");
        token_generated_time = DateTime.now(DateTimeZone.getDefault()).getMillis();
    }

    /**
     * Generates a new token if the token valid time has expired.
     */
    @BeforeMethod
    public void getToken() {
        long currentTime = DateTime.now(DateTimeZone.getDefault()).getMillis();
        if (currentTime - token_generated_time > token_duration) {
            generateToken();
        }
    }
}
