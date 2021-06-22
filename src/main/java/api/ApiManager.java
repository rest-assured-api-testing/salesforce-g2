package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Manages the creation of RequestSpecification and execution of an ApiRequest entities.
 */
public class ApiManager {

    /**
     * Builds a RequestSpecification.
     */
    private static RequestSpecification buildRequest(ApiRequest apiRequest)
    {
        return given().headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParms())
                .baseUri(apiRequest.getBaseUri())
                .contentType(ContentType.JSON)
                .log().all();
    }

    /**
     * Executes a ApiRequest without body.
     */
    public static ApiResponse execute(ApiRequest apiRequest){
        Response response = buildRequest(apiRequest)
                .request(apiRequest.getMethod().name()
                        ,apiRequest.getEndpoint());

        return new ApiResponse(response);
    }

    /**
     * Executes a ApiRequest with body.
     */
    public static ApiResponse executeWithBody(ApiRequest apiRequest){
        Response response = buildRequest(apiRequest)
                .body(apiRequest.getBody())
                .request(apiRequest.getMethod().name()
                        ,apiRequest.getEndpoint());

        return new ApiResponse(response);
    }
}
