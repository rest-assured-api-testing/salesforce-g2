package tests;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.Account;
import salesforce.entities.Contact;
import salesforce.entities.CreatedResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

public class ContactsTest extends CommonTest {

    private String accountId;
    private String contactId;

    @BeforeClass
    public void createAccount() throws JsonProcessingException {
        Account account = new Account();
        account.setName("testAccount01");
        Map<String,String> pathParams = new HashMap<>();
        ApiResponse apiResponse = ApiRequestManager.create(Endpoint.ACCOUNTS, pathParams, account);
        accountId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @BeforeMethod(onlyForGroups = {"updateContact", "deleteContact"})
    public void createTestContact() throws JsonProcessingException {
        Contact contact = new Contact();
        contact.setFirstName("firstname");
        contact.setLastName("lastname");
        Map<String,String> pathParams = new HashMap<>();
        ApiResponse apiResponse = ApiRequestManager.create(Endpoint.CONTACTS, pathParams, contact);
        contactId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }
    @Test(groups="createContact")
    public void createContact() throws JsonProcessingException {
        Contact contact = new Contact();
        contact.setFirstName("firstname");
        contact.setLastName("lastname");
        Map<String,String> pathParams = new HashMap<>();
        ApiResponse apiResponse = ApiRequestManager.create(Endpoint.CONTACTS, pathParams, contact);
        contactId = apiResponse.getBody(CreatedResponse.class).getId();
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @Test(groups="updateContact")
    public void updateContact() throws JsonProcessingException {
        Contact contact = new Contact();
        contact.setFirstName("firstnameUpdated");
        contact.setLastName("lastnameUpdated");
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put("Id", contactId);
        ApiResponse apiResponse = ApiRequestManager.update(Endpoint.CONTACT, pathParams, contact);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

    @AfterMethod(onlyForGroups = {"createOrder", "updateOrder"})
    public void deleteContact() {
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put("Id", contactId);
        ApiResponse apiResponse = ApiRequestManager.delete(Endpoint.CONTACT, pathParams);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
    @AfterClass
    public void deleteAccount() throws JsonProcessingException {
        Map<String,String> pathParams = new HashMap<>();
        pathParams.put("Id",accountId);
        ApiResponse apiResponse = ApiRequestManager.delete(Endpoint.ACCOUNT, pathParams);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
