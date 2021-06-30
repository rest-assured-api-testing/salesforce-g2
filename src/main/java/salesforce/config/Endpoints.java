/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */

package salesforce.config;

/**
 * Gives requested endpoint.
 */
public enum Endpoints {

    ID("id"),
    PEOPLE("/Individual"),
    PERSON("/Individual/{" + Endpoints.ID.get() + "}"),
    ACCOUNTS("/Account"),
    ACCOUNT("/Account/{" + Endpoints.ID.get() + "}"),
    ORDERS("/Order"),
    ORDER("/Order/{" + Endpoints.ID.get() + "}"),
    CONTACTS("/Contact"),
    CONTACT("/Contact/{" + Endpoints.ID.get() + "}"),
    CAMPAIGNS("/Campaign"),
    CAMPAIGN("/Campaign/{" + Endpoints.ID.get() + "}"),
    PRODUCTS("/Product2"),
    PRODUCT("/Product2/{" + Endpoints.ID.get() + "}");

    private String endpoint;

    Endpoints(final String endpoint) {
        this.endpoint = endpoint;
    }

    public String get() {
        return endpoint;
    }
}
