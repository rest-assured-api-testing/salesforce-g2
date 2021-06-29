/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.scenarios.hooks;

import api.ApiMethod;
import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.auth.Authentication;
import salesforce.config.Endpoints;
import salesforce.entities.Contact;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Token;
import java.util.HashMap;
import java.util.Map;

public class ContactScenarioHooks {

    private CreatedResponse createdResponse;
    private Logger logger = LogManager.getLogger(getClass());

    public ContactScenarioHooks(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(order = 1)
    public  void setUp() {
        if(Token.accessToken == null) {
            Authentication.getAuth();
        }
    }

    @Before(value = "@GetContact or @UpdateContact or @DeleteContact")
    public void createContact() throws JsonProcessingException {
        logger.info("*** Create a Contact to test operations ***");
        Map<String, String> pathParams = new HashMap<>();
        Contact contact = new Contact();
        contact.setFirstName("firstname");
        contact.setLastName("lastname");
        ApiResponse apiResponse = ApiRequestManager.execute(Endpoints.CONTACTS.get(), pathParams, contact, ApiMethod.POST);
        createdResponse.setId(apiResponse.getBody(CreatedResponse.class).getId());
    }

    @After(value = "@GetContact or @UpdateContact or @CreateContact")
    public void setDownContact() throws JsonProcessingException {
        logger.info("*** Delete created Contact ***");
        if (createdResponse.getId() != null) {
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put(Endpoints.ID.get(), createdResponse.getId());
            ApiResponse apiResponse;
            apiResponse = ApiRequestManager.execute(Endpoints.CONTACT.get(), pathParams, ApiMethod.DELETE);
        }
    }
}
