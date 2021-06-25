/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.config;

public enum Param {
    USERNAME("username"),
    PASSWORD("password"),
    CLIENT_ID("client_id"),
    CLIENT_SECRET("client_secret"),
    GRANT_TYPE("grant_type");

    private String param;

    Param(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
