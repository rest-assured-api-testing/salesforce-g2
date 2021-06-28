/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.auth;

import org.apache.http.HttpHeaders;
import salesforce.config.CredentialsConfig;
import salesforce.config.HeaderValue;
import salesforce.entities.Token;

import static salesforce.config.EnvConfigurationFile.dotenv;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static Token getAuth() {
        return
                given().urlEncodingEnabled(true)
                        .param(CredentialsConfig.USERNAME1.getEnumValue(), dotenv.get(CredentialsConfig.USERNAME1.getEnumName()))
                        .param(CredentialsConfig.PASSWORD.getEnumValue(), dotenv.get(CredentialsConfig.PASSWORD.getEnumName()))
                        .param(CredentialsConfig.CLIENT_ID.getEnumValue(), dotenv.get(CredentialsConfig.CLIENT_ID.getEnumName()))
                        .param(CredentialsConfig.CLIENT_SECRET.getEnumValue(), dotenv.get(CredentialsConfig.CLIENT_SECRET.getEnumName()))
                        .param(CredentialsConfig.GRANT_TYPE.getEnumValue(), CredentialsConfig.PASSWORD.getEnumValue())
                        .header(HttpHeaders.ACCEPT, HeaderValue.APP_JSON.get())
                        .header(HttpHeaders.CONTENT_TYPE, HeaderValue.APP_X_FORM.get())
                        .log().all()
                        .when().
                        post(dotenv.get(CredentialsConfig.TOKEN_URL.getEnumName()))
                        .as(Token.class);
    }
}
