/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

import static api.EnvConfigurationFile.dotenv;

public class ApiRequestManger {

    /**
     * Builds a basic ApiRequestBuilder
     * @param endpoint
     * @param pathParams contains names and values of params.
     * @param type of request.
     * @param <T> type of a entity.
     * @returna a ApiRequestBuilder that contains basic data of request
     */
    public static <T> ApiRequestBuilder buildRequest(String endpoint, Map<String, String> pathParams,
                                                     Enum<ApiMethod> type) {
        return new ApiRequestBuilder().header("Authorization", dotenv.get("TOKEN"))
                .baseUri(dotenv.get("BASE_URL"))
                .method((ApiMethod) type)
                .endpoint(endpoint)
                .pathParams(pathParams);
    }

    /**
     *
     * @param endpoint is complement of base url.
     * @param pathParams contains names and values of params.
     * @param entity that sends as body of request.
     * @param <T> is type of a entity.
     * @return a ApiResponse that is result of request execution.
     * @throws JsonProcessingException
     */
    public static <T> ApiResponse create(String endpoint, Map<String, String> pathParams, T entity)
            throws JsonProcessingException {
        return executeWithBody(endpoint, pathParams, entity, ApiMethod.POST);
    }

    /**
     *
     * @param endpoint is complement of base url.
     * @param pathParams contains names and values of params.
     * @param entity that sends as body of request.
     * @param <T> is type of a entity.
     * @return a ApiResponse that is result of request execution.
     * @throws JsonProcessingException
     */
    public static <T> ApiResponse update(String endpoint, Map<String, String> pathParams, T entity)
            throws JsonProcessingException {
        return executeWithBody(endpoint, pathParams, entity, ApiMethod.PUT);
    }

    /**
     *
     * @param endpoint is complement of base url.
     * @param pathParams contains names and values of params.
     * @param <T> is type of a entity.
     * @return a ApiResponse that is result of request execution
     */
    public static <T> ApiResponse get(String endpoint, Map<String, String> pathParams) {
        return execute(endpoint, pathParams, ApiMethod.GET);
    }

    /**
     *
     * @param endpoint is complement of base url.
     * @param pathParams contains names and values of params.
     * @param <T> is type of a entity.
     * @return a ApiResponse that is result of request execution.
     */
    public static <T> ApiResponse delete(String endpoint, Map<String, String> pathParams) {
        return execute(endpoint, pathParams, ApiMethod.DELETE);
    }

    /**
     *
     * @param endpoint is complement of base url.
     * @param pathParams contains names and values of params.
     * @param entity that sends as body of request.
     * @param type of request.
     * @param <T> is type of a entity.
     * @returna ApiResponse that is result of request execution.
     * @throws JsonProcessingException
     */
    public static <T> ApiResponse executeWithBody(String endpoint, Map<String, String> pathParams, T entity,
                                                  Enum<ApiMethod> type) throws JsonProcessingException {
        return ApiManager.executeWithBody(buildRequest(endpoint, pathParams, type)
                .body(new ObjectMapper().writeValueAsString(entity)).build());
    }

    /**
     *
     * @param endpoint is complement of base url.
     * @param pathParams contains names and values of params.
     * @param type of request.
     * @param <T> is type of a entity.
     * @return a ApiResponse that is result of request execution.
     */
    public static <T> ApiResponse execute(String endpoint, Map<String, String> pathParams,
                                          Enum<ApiMethod> type) {
        return ApiManager.execute(buildRequest(endpoint, pathParams, type).build());
    }
}
