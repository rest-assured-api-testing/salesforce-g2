/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */

package api;

import static salesforce.config.EnvConfigurationFile.dotenv;
import static salesforce.entities.Token.accessToken;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.apache.http.HttpHeaders;
import salesforce.config.CredentialsConfig;

/**
 * Helps to manage the basic request.
 */
public class ApiRequestManager {

    /**
     * Builds a basic ApiRequestBuilder.
     *
     * @param endpoint   is complement of base url.
     * @param pathParams contains names and values of params.
     * @param entity     contains the body of request.
     * @param type       of request.
     * @param <T>        type of a entity.
     * @return a ApiRequestBuilder that contains basic data of request
     */
    public static <T> ApiRequestBuilder buildRequest(final String endpoint, final Map<String, String> pathParams,
                                                     final String entity, final Enum<ApiMethod> type) {
        return new ApiRequestBuilder()
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", accessToken))
                .baseUri(dotenv.get(CredentialsConfig.BASE_URL.getEnumValue()))
                .method(type)
                .endpoint(endpoint)
                .pathParams(pathParams)
                .body(entity);
    }

    /**
     * Executes a request with body.
     *
     * @param endpoint   is complement of base url.
     * @param pathParams contains names and values of params.
     * @param entity     that sends as body of request.
     * @param type       of request.
     * @param <T>        is type of a entity.
     * @return ApiResponse that is result of request execution.
     * @throws JsonProcessingException due to method execution.
     */
    public static <T> ApiResponse execute(final String endpoint, final Map<String, String> pathParams, final T entity,
                                          final Enum<ApiMethod> type)
            throws JsonProcessingException {
        String convertedEntity;
        if (entity instanceof String) {
            convertedEntity = (String) entity;
        } else {
            convertedEntity = new ObjectMapper().writeValueAsString(entity);
        }
        return ApiManager.execute(buildRequest(endpoint, pathParams,
                convertedEntity, type).build());
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
                                          final Enum<ApiMethod> type)
            throws JsonProcessingException {
        return execute(endpoint, pathParams, "", type);
    }
}
