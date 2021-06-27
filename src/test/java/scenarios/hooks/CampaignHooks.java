/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package scenarios.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Campaign;

import java.util.HashMap;
import java.util.Map;

public class CampaignHooks {
    private Logger logger = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;

    public CampaignHooks(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(value = "@GetCampaigns or @GetCampaign or @UpdateCampaign or @DeleteCampaign", order = 2)
    public void setUp() throws JsonProcessingException {
        logger.info("~~~~~~~~~~~~~~~~~~ BeforeHook: Create a Campaign ~~~~~~~~~~~~~~~~~~~~~~~");
        Map<String, String> pathParams = new HashMap<>();
        Campaign campaign = new Campaign();
        campaign.setName("The first campaign");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.create(Endpoints.CAMPAIGNS.get(), pathParams, campaign);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @After(value = "@GetCampaigns or @GetCampaign or @UpdateCampaign or @CreateCampaign")
    public void setLast() {
        logger.info("~~~~~~~~~~~~~~~~~~ AfterHook: Delete the Campaign ~~~~~~~~~~~~~~~~~~~~~~~");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.delete(Endpoints.CAMPAIGN.get(), pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
