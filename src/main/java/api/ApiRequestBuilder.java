/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package api;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents an ApiRequest builder to build an ApiRequest by setting custom attributes.
 * @param <T>
 */
public class ApiRequestBuilder<T> {

    private ApiRequest apiRequest = new ApiRequest();
    private List<Header> headers;
    private Map<String, String> queryParams;
    private Map<String, String> pathParms;
    private Map<String, String> formParms;

    /**
     * Constructs the ApiRequestBuilder and initializes its attributes.
     */
    public ApiRequestBuilder() {
        headers = new ArrayList<>();
        queryParams = new HashMap<>();
        pathParms = new HashMap<>();
        formParms = new HashMap<>();
    }

    /**
     * Sets the baseUri
     * @param baseUri A String representing the baseUri
     * @return the current instance of ApiRequestBuilder
     */
    public ApiRequestBuilder setBaseUri(String baseUri) {
        apiRequest.setBaseUri(baseUri);
        return this;
    }

    /**
     * Sets the endpoint.
     * @param endpoint A String representing the endpoint.
     * @return the current instance of ApiRequestBuilder.
     */
    public ApiRequestBuilder setEndpoint(String endpoint) {
        apiRequest.setEndpoint(endpoint);
        return this;
    }

    /**
     * Sets the body.
     * @param body A String representing the body.
     * @return the current instance of ApiRequestBuilder.
     */
    public ApiRequestBuilder setBody(T body) {
        apiRequest.setBody(body);
        return this;
    }

    /**
     * Sets the token.
     * @param token A String representing the token.
     * @return the current instance of ApiRequestBuilder.
     */
    public ApiRequestBuilder setToken(String token) {
        apiRequest.setToken(token);
        return this;
    }

    /**
     * Sets the method to be used for a Request.
     * @param method A String representing the method.
     * @return the current instance of ApiRequestBuilder.
     */
    public ApiRequestBuilder setMethod(Enum<RequestMethod> method) {
        apiRequest.setMethod(method);
        return this;
    }

    /**
     * Adds a header to the headers Map.
     * @param header The key of the header.
     * @param value  The value of the header.
     * @return the current instance of ApiRequestBuilder.
     */
    public ApiRequestBuilder addHeader(final String header, final String value) {
        headers.add(new Header(header, value));
        return this;
    }

    /**
     * Adds a query to the queryParam Map.
     * @param param The key of the Query Parameter.
     * @param value  The value of the Query Parameter.
     * @return the current instance of ApiRequestBuilder.
     */
    public ApiRequestBuilder addQueryParam(final String param, final String value) {
        queryParams.put(param, value);
        return this;
    }

    /**
     * Adds a path parameter to the pathParam Map.
     * @param param The key of the Path Parameter.
     * @param value  The value of the Path Parameter.
     * @return the current instance of ApiRequestBuilder.
     */
    public ApiRequestBuilder addPathParam(final String param, final String value) {
        pathParms.put(param, value);
        return this;
    }

    /**
     * Adds a form parameter to the formParam Map.
     * @param param The key of the Form Parameter.
     * @param value  The value of the Form Parameter.
     * @return the current instance of ApiRequestBuilder.
     */
    public  ApiRequestBuilder addFormParam(final String param, final String value) {
        formParms.put(param, value);
        return this;
    }

    /**
     * Builds the ApiRequests by adding the Maps to the ApiRequest.
     * @return an ApiRequest.
     */
    public ApiRequest build() {
        apiRequest.setHeaders(new Headers(headers));
        apiRequest.setQueryParams(queryParams);
        apiRequest.setPathParams(pathParms);
        apiRequest.setFormParams(formParms);
        return apiRequest;
    }
}
