/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package api;

import io.restassured.http.Headers;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a container for the values to be added to a RequestSpecification.
 * Can store the values required for a RequestSpecification.
 * @param <T>, the body attribute receives an Object.
 */
public class ApiRequest<T>{

    private String baseUri;
    private String endpoint;
    private T body;
    private String token;
    private Enum<RequestMethod> method;
    private Headers headers;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;
    private Map<String, String> formParams;

    /**
     * Creates an instance of ApiRequests and initializes the parameters maps.
     */
    public ApiRequest() {
        queryParams = new HashMap<>();
        pathParams = new HashMap<>();
        formParams = new HashMap<>();
    }

    /**
     * Gets the baseUri.
     * @return a String representing the baseUri.
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Sets the baseUri
     * @param baseUri a String
     */
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    /**
     * Gets the endpoint.
     * @return a String representing the endpoint.
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the endpoint.
     * @param endpoint a String representing the endpoint.
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Gets the body.
     * @return an object representing the body.
     */
    public T getBody() {
        return body;
    }

    /**
     * Sets the body.
     * @param body an Object representing the body.
     */
    public void setBody(T body) {
        this.body = body;
    }

    /**
     * Gets the token.
     * @return a String representing the token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     * @param token, a String representing the token for a request.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets the method.
     * @return an Enum representing the method to be used for a Request.
     */
    public Enum<RequestMethod> getMethod() {
        return method;
    }

    /**
     * Sets the method.
     * @param method a String representing the method to be used for a Request.
     */
    public void setMethod(Enum<RequestMethod> method) {
        this.method = method;
    }

    /**
     * Gets the headers
     * @return Headers, a RestAssured class containing the headers.
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Sets the headers.
     * @param headers, contains the headers.
     */
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    /**
     * Gets the query parameters for a Request.
     * @return a Map of the query parameters.
     */
    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    /**
     * Sets the query parameters
     * @param queryParams, a Map containing the query parameters.
     */
    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * Gets the path parameters.
     * @return a Map containing the path parameters.
     */
    public Map<String, String> getPathParams() {
        return pathParams;
    }

    /**
     * Sets the path parameters.
     * @param pathParams, a Map containing the path parameters for a Request.
     */
    public void setPathParams(Map<String, String> pathParams) {
        this.pathParams = pathParams;
    }

    /**
     * Gets the form parameters.
     * @return a Map containing the form parameters for a Request.
     */
    public Map<String, String> getFormParams() {
        return formParams;
    }

    /**
     * Sets the form parameters.
     * @param formParams, a Map containing the form parameters for a request.
     */
    public void setFormParams(Map<String, String> formParams) {
        this.formParams = formParams;
    }

    /**
     * Clears the fields of an ApiRequests to be reused with new parameters.
     */
    public void clear() {
        baseUri = null;
        endpoint = null;
        body = null;
        token = null;
        method = null;
        headers = null;
        queryParams = null;
        pathParams = null;
        formParams = null;
    }
}
