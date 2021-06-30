/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package rest.salesforce.com.scenarios.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import salesforce.report.ReportingUtils;

public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void generateReport() {
        ReportingUtils.generateJVMReport();
    }
}