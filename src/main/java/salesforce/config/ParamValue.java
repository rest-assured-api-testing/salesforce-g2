/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.config;

public enum ParamValue {
    PASSWORD("password");
    private String value;

    ParamValue(final String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
