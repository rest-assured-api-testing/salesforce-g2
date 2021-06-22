/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/**
 * This class represents a RestAssured Response
 */
public class ApiResponse {

    private Response response;

    /**
     * Creates an instance of ApiResponse.
     * @param response
     */
    public ApiResponse(Response response) {
        this.response = response;
    }

    /**
     * Gets the Response.
     * @return a Response.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Gets the status code of the response.
     * @return an int representing the status code.
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Gets the body
     * @param cls An object to deserialize a JSON response to..
     * @return an Object instance representing the JSON body of a response.
     */
    public <T> T getBody(Class<T> cls) {
        return response.getBody().as(cls);
    }

    /**
     * Validates that a Response schema matches the given schema.
     * @param schema a schema for the JSON response.
     */
    public void validateBodySchema(String schema) {
        response.then().log().body().assertThat().body(matchesJsonSchemaInClasspath(schema));
    }

    /**
     * Gets the JSON path.
     * @return a JSON path for the Response's JSON content.
     */
    public JsonPath getJsonPath() {
        return response.jsonPath();
    }
}
