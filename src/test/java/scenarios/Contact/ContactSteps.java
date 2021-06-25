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
import io.cucumber.java.en.And;
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
    private Map<String,String> pathParams = new HashMap<>();

    public ContactSteps(CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Given("I create a body payload")
    public void iCreateABodyPayload() {
        contact = new Contact();
    }

    @And("I set the firstname value to {string}")
    public void iSetFirstnameValueTo(String firstname) {
        contact.setFirstName(firstname);
    }

    @And("I set the lastname value to {string}")
    public void iSetTheLastnameValueTo(String lastname) {
        contact.setLastName(lastname);
    }

    @And("I set the birthdate value to {string}")
    public void iSetTheBirthdateValueTo(String birthdate) {
        contact.setBirthdate(birthdate);
    }

    @And("I set the department value to {string}")
    public void iSetTheDepartmentValueTo(String deparment) {
        contact.setDepartment(deparment);
    }

    @And("I set the description value to {string}")
    public void iSetTheDescriptionValueTo(String description) {
        contact.setDescription(description);
    }

    @And("I set the email value to {string}")
    public void iSetTheEmailValueTo(String email) {
        contact.setEmail(email);
    }

    @And("I set the homephone value to {string}")
    public void iSetTheHomePhoneValueTo(String homephone) {
        contact.setHomePhone(homephone);
    }

    @And("I set the phone value to {string}")
    public void iSetThePhoneValueTo(String phone) {
        contact.setPhone(phone);
    }

    @When("I execute a {string} request with the {string} contact endpoint")
    public void iExecuteARequestWithTheContactEndpoint(String method, String endpoint) throws JsonProcessingException {
        apiResponse = ApiRequestManager.create(endpoint, pathParams, contact);
        try {
            createdResponse = apiResponse.getBody(CreatedResponse.class);
            contactId = createdResponse.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatus) {
        apiResponse.getResponse().then().assertThat().statusCode(expectedStatus).log().body();
    }
}
