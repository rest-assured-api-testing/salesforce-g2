/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package scenarios.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import salesforce.auth.Authentication;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.Contact;
import salesforce.entities.CreatedResponse;
import java.util.HashMap;
import java.util.Map;

public class ContactScenarioHooks {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    public static String contactId;

    public ContactScenarioHooks(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(order = 1)
    public  void setUp() {
        Authentication.getAuth();
    }

    @Before(value = "@GetContact or @UpdateContact or @DeleteContact", order = 2)
    public void createContact() throws JsonProcessingException {
        LOGGER.info("*** Create a Contact to test operations ***");
        Map<String,String> pathParams = new HashMap<>();
        Contact contact = new Contact();
        contact.setFirstName("firstname");
        contact.setLastName("lastname");
        ApiResponse apiResponse = ApiRequestManager.create(Endpoints.CONTACTS.getEndpoint(), pathParams, contact);
        contactId = apiResponse.getBody(CreatedResponse.class).getId();
    }

    @After(value = "@GetContact or @UpdateContact or @CreateContact")
    public void setDownContact() {
        LOGGER.info("*** Delete created Contact ***");
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.getEndpoint(), contactId);
        ApiResponse apiResponse = ApiRequestManager.delete(Endpoints.CONTACT.getEndpoint(), pathParams);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
