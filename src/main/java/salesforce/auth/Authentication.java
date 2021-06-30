/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.auth;

import static io.restassured.RestAssured.given;
import static salesforce.config.EnvConfigurationFile.dotenv;

import org.apache.http.HttpHeaders;
import salesforce.config.Credentials;
import salesforce.config.Endpoints;
import salesforce.config.HeaderValue;
import salesforce.entities.Token;

/**
 * Makes the authentication to the webpage.
 */
public class Authentication {

    /**
     * Gets the authentication.
     *
     * @return the authentication.
     */
    public static Token getAuth() {
        return
                given().urlEncodingEnabled(true)
                        .param(Credentials.USERNAME1.getEnumValue(), dotenv.get(Credentials.USERNAME1.getEnumName()))
                        .param(Credentials.PASSWORD.getEnumValue(), dotenv.get(Credentials.PASSWORD.getEnumName()))
                        .param(Credentials.CLIENT_ID.getEnumValue(), dotenv.get(Credentials.CLIENT_ID.getEnumName()))
                        .param(Credentials.CLIENT_SECRET.getEnumValue(), dotenv.get(Credentials.CLIENT_SECRET.getEnumName()))
                        .param(Credentials.GRANT_TYPE.getEnumValue(), Credentials.PASSWORD.getEnumValue())
                        .header(HttpHeaders.ACCEPT, HeaderValue.APP_JSON.get())
                        .header(HttpHeaders.CONTENT_TYPE, HeaderValue.APP_X_FORM.get())
                        .log().all()
                        .when()
                        .post(Endpoints.TOKEN_URL.get())
                        .as(Token.class);
    }
}
