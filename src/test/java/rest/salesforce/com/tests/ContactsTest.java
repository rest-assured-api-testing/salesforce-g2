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
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import salesforce.config.Endpoints;
import salesforce.entities.Account;
import salesforce.entities.Contact;
import salesforce.entities.CreatedResponse;

public class ContactsTest extends CommonTest {

    private String accountId;
    private String contactId;

    @BeforeClass
    public void createAccount() throws JsonProcessingException {
        Account account = new Account();
        account.setName("testAccount01");
        Map<String, String> pathParams = new HashMap<>();
        ApiResponse apiResponse = Request.execute(Endpoints.ACCOUNTS.get(), pathParams, account, ApiMethod.POST);
        accountId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @BeforeMethod(onlyForGroups = {"updateContact", "deleteContact"})
    public void createTestContact() throws JsonProcessingException {
        Contact contact = new Contact();
        contact.setFirstName("firstname");
        contact.setLastName("lastname");
        Map<String, String> pathParams = new HashMap<>();
        ApiResponse apiResponse = Request.execute(Endpoints.CONTACTS.get(), pathParams, contact, ApiMethod.POST);
        contactId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @Test(groups = "createContact")
    public void createContact() throws JsonProcessingException {
        Contact contact = new Contact();
        contact.setFirstName("firstname");
        contact.setLastName("lastname");
        Map<String, String> pathParams = new HashMap<>();
        ApiResponse apiResponse = Request.execute(Endpoints.CONTACTS.get(), pathParams, contact, ApiMethod.POST);
        contactId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @Test(groups = "updateContact")
    public void updateContact() throws JsonProcessingException {
        Contact contact = new Contact();
        contact.setFirstName("firstnameUpdated");
        contact.setLastName("lastnameUpdated");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), contactId);
        ApiResponse apiResponse = Request.execute(Endpoints.CONTACT.get(), pathParams, contact, ApiMethod.PATCH);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

    @AfterMethod(onlyForGroups = {"createOrder", "updateOrder"})
    public void deleteContact() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), contactId);
        ApiResponse apiResponse = Request.execute(Endpoints.CONTACT.get(), pathParams, ApiMethod.DELETE);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

    @AfterClass
    public void deleteAccount() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), accountId);
        ApiResponse apiResponse = Request.execute(Endpoints.ACCOUNT.get(), pathParams, ApiMethod.DELETE);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
