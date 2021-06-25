/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package salesforce.endpointurl;

public enum Endpoints {

    ID("id"),
    PEOPLE("/Individual"),
    PERSON("/Individual/{" + Endpoints.ID.getEndpoint() + "}"),
    ACCOUNTS("/Account"),
    ACCOUNT("/Account/{" + Endpoints.ID.getEndpoint() + "}"),
    ORDERS("/Order"),
    ORDER("/Order/{" + Endpoints.ID.getEndpoint() + "}"),
    CONTACTS("/Contact"),
    CONTACT("/Contact/{" + Endpoints.ID.getEndpoint() + "}"),
    CAMPAIGNS("/Campaign"),
    CAMPAIGN("/Campaign/{" + Endpoints.ID.getEndpoint() + "}"),
    PRODUCTS("/Product2"),
    PRODUCT("/Product2/{" + Endpoints.ID.getEndpoint() + "}");

    private String endpoint;

    Endpoints(final String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
