/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.auth;

import org.apache.http.HttpHeaders;
import salesforce.config.Param;
import salesforce.config.EnvVariable;
import salesforce.config.ParamValue;
import salesforce.config.HeaderValue;
import salesforce.entities.Token;

import static salesforce.config.EnvConfigurationFile.dotenv;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static Token getAuth() {
        return
                given().urlEncodingEnabled(true)
                        .param(Param.USERNAME.get(), dotenv.get(EnvVariable.USERNAME1.name()))
                        .param(Param.PASSWORD.get(), dotenv.get(EnvVariable.PASSWORD.name()))
                        .param(Param.CLIENT_ID.get(), dotenv.get(EnvVariable.CLIENT_ID.name()))
                        .param(Param.CLIENT_SECRET.get(), dotenv.get(EnvVariable.CLIENT_SECRET.name()))
                        .param(Param.GRANT_TYPE.get(), ParamValue.PASSWORD.get())
                        .header(HttpHeaders.ACCEPT, HeaderValue.APP_JSON.get())
                        .header(HttpHeaders.CONTENT_TYPE, HeaderValue.APP_X_FORM.get())
                        .log().all()
                        .when().
                        post(dotenv.get(EnvVariable.TOKEN_URL.name()))
                        .as(Token.class);
    }
}
