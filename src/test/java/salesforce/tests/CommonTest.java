/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.tests;

import org.testng.annotations.BeforeSuite;
import salesforce.auth.Authentication;
import salesforce.entities.CreatedResponse;

public class CommonTest {
    protected CreatedResponse createdResponse;

    @BeforeSuite
    public void getToken() {
        Authentication.getAuth();
    }
}
