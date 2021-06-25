/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.auth;

import org.apache.http.HttpHeaders;
import salesforce.config.*;
import salesforce.entities.Token;

import static salesforce.config.EnvConfigurationFile.dotenv;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static Token getAuth() {
        return
                given().urlEncodingEnabled(true)
                        .param(Param.USERNAME.getParam(),dotenv.get(EnvVariable.USERNAME1.name()))
                        .param(Param.PASSWORD.getParam(), dotenv.get(EnvVariable.PASSWORD.name()))
                        .param(Param.CLIENT_ID.getParam(), dotenv.get(EnvVariable.CLIENT_ID.name()))
                        .param(Param.CLIENT_SECRET.getParam(), dotenv.get(EnvVariable.CLIENT_SECRET.name()))
                        .param(Param.GRANT_TYPE.getParam(), ParamValue.PASSWORD.getValue())
                        .header(HttpHeaders.ACCEPT, HeaderValue.APP_JSON.getValue())
                        .header(HttpHeaders.CONTENT_TYPE, HeaderValue.APP_X_FORM.getValue())
                        .log().all()
                        .when().
                        post(dotenv.get(EnvVariable.TOKEN_URL.name()))
                        .as(Token.class);
    }
}
