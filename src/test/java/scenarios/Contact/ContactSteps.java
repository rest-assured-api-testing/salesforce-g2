/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package scenarios.Contact;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.entities.Contact;
import salesforce.entities.CreatedResponse;
import java.util.HashMap;
import java.util.Map;
import static scenarios.hooks.ContactScenarioHooks.contactId;

public class ContactSteps {
    private CreatedResponse createdResponse;
    private ApiResponse apiResponse;
    private Contact contact;
    private Map<String, String> pathParams = new HashMap<>();

    public ContactSteps(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I create a contact body payload")
    public void iCreateAContactBodyPayload(final DataTable jsonData) throws JsonProcessingException {
        contact = new Contact();
        String body = new ObjectMapper().writeValueAsString(jsonData.asMap(String.class, String.class));
        Contact contactAssistant = new ObjectMapper().readValue(body, Contact.class);
        contact.setFirstName(contactAssistant.getFirstName());
        contact.setLastName(contactAssistant.getLastName());
        contact.setBirthdate(contactAssistant.getBirthdate());
        contact.setDepartment(contactAssistant.getDepartment());
        contact.setDescription(contactAssistant.getDescription());
        contact.setEmail(contactAssistant.getEmail());
        contact.setHomePhone(contactAssistant.getHomePhone());
        contact.setPhone(contactAssistant.getPhone());
    }

    @When("I execute a {string} request with the {string} contact endpoint")
    public void iExecuteARequestWithTheContactEndpoint(final String method, final String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.create(endpoint, pathParams, contact);
        try {
            createdResponse = apiResponse.getBody(CreatedResponse.class);
            contactId = createdResponse.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("The response status code must be {int}")
    public void theResponseStatusCodeMustBe(int expectedStatus) {
        apiResponse.getResponse().then().assertThat().statusCode(expectedStatus).log().body();
    }
}
