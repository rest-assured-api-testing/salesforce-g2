/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    private String firstname;
    private String lastname;

    @JsonProperty("FirstName")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("FirstName")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("LastName")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("LastName")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
