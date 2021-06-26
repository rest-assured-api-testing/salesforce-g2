/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import salesforce.config.EnvVariable;

import java.util.Map;

import static salesforce.entities.Token.accessToken;
import static salesforce.config.EnvConfigurationFile.dotenv;

public class ApiRequestManager {

    /**
     * Builds a basic ApiRequestBuilder.
     *
     * @param endpoint
     * @param pathParams contains names and values of params.
     * @param type       of request.
     * @param <T>        type of a entity.
     * @returna a ApiRequestBuilder that contains basic data of request
     */
    public static <T> ApiRequestBuilder buildRequest(final String endpoint, final Map<String, String> pathParams,
                                                     final Enum<ApiMethod> type) {
        return new ApiRequestBuilder().header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", accessToken))
                .baseUri(dotenv.get(EnvVariable.BASE_URL.name()))
                .method(type)
                .endpoint(endpoint)
                .pathParams(pathParams);
    }

    /**
     * Executes a request to create an entity.
     *
     * @param endpoint   is complement of base url.
     * @param pathParams contains names and values of params.
     * @param entity     that sends as body of request.
     * @param <T>        is type of a entity.
     * @return a ApiResponse that is result of request execution.
     * @throws JsonProcessingException due to method execution.
     */
    public static <T> ApiResponse create(final String endpoint, final Map<String, String> pathParams, final T entity)
            throws JsonProcessingException {
        return executeWithBody(endpoint, pathParams, entity, ApiMethod.POST);
    }

    /**
     * Executes a request to update an entity.
     *
     * @param endpoint   is complement of base url.
     * @param pathParams contains names and values of params.
     * @param entity     that sends as body of request.
     * @param <T>        is type of a entity.
     * @return a ApiResponse that is result of request execution.
     * @throws JsonProcessingException due to method execution.
     */
    public static <T> ApiResponse update(final String endpoint, final Map<String, String> pathParams, final T entity)
            throws JsonProcessingException {
        return executeWithBody(endpoint, pathParams, entity, ApiMethod.PATCH);
    }

    /**
     * Executes a request to get an entity.
     *
     * @param endpoint   is complement of base url.
     * @param pathParams contains names and values of params.
     * @param <T>        is type of a entity.
     * @return a ApiResponse that is result of request execution
     */
    public static <T> ApiResponse get(final String endpoint, final Map<String, String> pathParams) {
        return execute(endpoint, pathParams, ApiMethod.GET);
    }

    /**
     * Executes a request to delete an entity.
     *
     * @param endpoint   is complement of base url.
     * @param pathParams contains names and values of params.
     * @param <T>        is type of a entity.
     * @return a ApiResponse that is result of request execution.
     */
    public static <T> ApiResponse delete(final String endpoint, final Map<String, String> pathParams) {
        return execute(endpoint, pathParams, ApiMethod.DELETE);
    }

    /**
     * Executes a request with body.
     *
     * @param endpoint   is complement of base url.
     * @param pathParams contains names and values of params.
     * @param entity     that sends as body of request.
     * @param type       of request.
     * @param <T>        is type of a entity.
     * @throws JsonProcessingException due to method execution.
     * @returna ApiResponse that is result of request execution.
     */
    public static <T> ApiResponse executeWithBody(final String endpoint, final Map<String, String> pathParams,
                                                  final T entity, final Enum<ApiMethod> type)
            throws JsonProcessingException {
        String convertedEntity;
        if (entity instanceof String) {
            convertedEntity = (String) entity;
        } else  {
            convertedEntity = new ObjectMapper().writeValueAsString(entity);
        }
        return ApiManager.executeWithBody(buildRequest(endpoint, pathParams, type)
                .body(convertedEntity).build());
    }

    /**
     * Executes a request.
     *
     * @param endpoint   is complement of base url.
     * @param pathParams contains names and values of params.
     * @param type       of request.
     * @param <T>        is type of a entity.
     * @return a ApiResponse that is result of request execution.
     */
    public static <T> ApiResponse execute(final String endpoint, final Map<String, String> pathParams,
                                          final Enum<ApiMethod> type) {
        return ApiManager.execute(buildRequest(endpoint, pathParams, type).build());
    }
}
