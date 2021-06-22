/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package api;

import static io.restassured.RestAssured.given;

public class Authentication {

    private String getAuth() {
        return
                given().urlEncodingEnabled(true)
                        .param("username", "jrojas@freeorg01.com")
                        .param("password", "THEmanofsteel21" + "8ABF037E067F9FF60561A6EBBB079C33EB26BCBEFD02879A02896223E801DFC9")
                        .param("client_id", "3MVG9cHH2bfKACZY1ZGPbQso.hc85SfFyaqUEWvnaGM.40VChcH4K0CrWB6VBGkTt4phw0cU2o8v7fyL.RvKA")
                        .param("client_secret", "8ABF037E067F9FF60561A6EBBB079C33EB26BCBEFD02879A02896223E801DFC9")
                        .param("grant_type", "password")
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .when().
                        post("https://login.salesforce.com/services/oauth2/token").
                        then().
                        assertThat().statusCode(200).log().body().extract().path("access_token");
    }
}
