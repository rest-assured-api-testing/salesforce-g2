/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package tests;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.endpointurl.Endpoints;
import salesforce.entities.Campaign;
import salesforce.entities.CreatedResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class CampaignTest extends CommonTest {

    @BeforeMethod(onlyForGroups = {"post", "patch", "delete"})
    public void createACampaign() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Campaign campaign = new Campaign();
        campaign.setName("First campaign");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.create(Endpoints.CAMPAIGNS.get(), pathParams, campaign);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @AfterMethod(onlyForGroups = {"post", "patch"})
    public void deleteAProduct() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.delete(Endpoints.CAMPAIGN.get(), pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void getCampaign() {
        ApiResponse apiResponse = ApiRequestManager.get(Endpoints.CAMPAIGNS.get(), new HashMap<>());
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "post")
    public void createCampaign() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Campaign campaign = new Campaign();
        campaign.setName("New campaign");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.create(Endpoints.CAMPAIGNS.get(), pathParams, campaign);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @Test(groups = "post")
    public void getACampaign() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse = ApiRequestManager.get(Endpoints.CAMPAIGN.get(), pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "patch")
    public void updateCampaign() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        Campaign campaign = new Campaign();
        campaign.setDescription("This the updated description of the campaign");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.update(Endpoints.CAMPAIGN.get(), pathParams, campaign);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = "delete")
    public void deleteCampaign() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.delete(Endpoints.CAMPAIGN.get(), pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
