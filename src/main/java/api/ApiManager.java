/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Represents a class to manage the building and execution of an ApiRequest.
 */
public class ApiManager {

    /**
     * Builds a RequestSpecification with the parameters of an ApiRequest object.
     * @param apiRequest
     * @return RequestSpecification to execute a request
     */
    private static RequestSpecification buildRequest(ApiRequest apiRequest) {
        RequestSpecification requestSpecification = given()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .auth()
                .oauth2(apiRequest.getToken())
                .baseUri(apiRequest.getBaseUri())
                .contentType(ContentType.JSON);
        if (apiRequest.getBody() != null) {
            requestSpecification
                    .body(apiRequest.getBody());
        }
        requestSpecification.log().all();
        return requestSpecification;
    }

    /**
     * Builds a RequestSpecification with no authorization parameters out of an ApiRequest object.
     * @param apiRequest
     * @return RequestSpecification to execute a request
     */
    private static RequestSpecification buildLoginRequest(ApiRequest apiRequest) {
        return given()
                .headers(apiRequest.getHeaders())
                .formParams(apiRequest.getFormParams())
                .baseUri(apiRequest.getBaseUri())
                .log().all();
    }

    /**
     * Executes an ApiRequest after obtaining a RequestSpecification from buildRequest.
     * @param apiRequest
     * @return ApiResponse, a wrapper for a Response
     */
    public static ApiResponse execute(ApiRequest apiRequest) {
        Response response;
        if (apiRequest.getEndpoint() == null) {
            response = buildLoginRequest(apiRequest)
                    .request(apiRequest.getMethod().name());
        } else {
            response = buildRequest(apiRequest)
                    .request(apiRequest.getMethod().name()
                            , apiRequest.getEndpoint());
        }
        return new ApiResponse(response);
    }
}
