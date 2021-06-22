package api;

import static io.restassured.RestAssured.given;

public class Authentication {

    private String getAuth() {
        return
                given().urlEncodingEnabled(true)
                        .param("username", "yourSalesforceUsername")
                        .param("password", "yourSalesforcePassword" + "yourSecurityToken")
                        .param("client_id", "yourConsumerKey")
                        .param("client_secret", "yourConsumerSecret")
                        .param("grant_type", "password")
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .when().
                        post("https://login.salesforce.com/services/oauth2/token").
                        then().
                        assertThat().statusCode(200).log().body().extract().path("access_token");
    }
}
