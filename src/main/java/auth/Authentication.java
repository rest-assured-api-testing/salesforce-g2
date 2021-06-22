/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package auth;

import config.*;

import static config.EnvConfigurationFile.dotenv;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static Token getAuth() {
        return
                given().urlEncodingEnabled(true)
                        .param(Param.USERNAME,dotenv.get(EnvVariable.USERNAME1.name()))
                        .param(Param.PASSWORD, dotenv.get(EnvVariable.PASSWORD.name()))
                        .param(Param.CLIENT_ID, dotenv.get(EnvVariable.CLIENT_ID.name()))
                        .param(Param.CLIENT_SECRET, dotenv.get(EnvVariable.CLIENT_SECRET.name()))
                        .param(Param.GRANT_TYPE, ParamValue.PASSWORD)
                        .header(Header.ACCEPT, HeaderValue.APP_JSON)
                        .header(Header.CONTENT_TYPE, HeaderValue.APP_X_FORM)
                        .log().all()
                        .when().
                        post(dotenv.get(EnvVariable.TOKEN_URL.name()))
                        .as(Token.class);
//                        then().assertThat().statusCode(200).log().all().extract().path("access_token");

    }
}
