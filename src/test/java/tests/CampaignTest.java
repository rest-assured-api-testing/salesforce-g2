package tests;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.Campaign;
import entities.CreatedResponse;
import entities.Product;
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
        apiResponse = ApiRequestManager.create(Endpoint.CAMPAIGNS, pathParams, campaign);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @AfterMethod(onlyForGroups = {"post", "patch"})
    public void deleteAProduct() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.delete(Endpoint.CAMPAIGN, pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void getCampaign() {
        Map<String, String> pathParams = new HashMap<>();
        ApiResponse apiResponse = ApiRequestManager.get(Endpoint.CAMPAIGNS, pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "post")
    public void createCampaign() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Campaign campaign = new Campaign();
        campaign.setName("New campaign");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.create(Endpoint.CAMPAIGNS, pathParams, campaign);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @Test(groups = "post")
    public void getACampaign() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse = ApiRequestManager.get(Endpoint.CAMPAIGN, pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "patch")
    public void updateCampaign() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        Campaign campaign = new Campaign();
        campaign.setDescription("This the updated description of the campaign");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.update(Endpoint.CAMPAIGN, pathParams, campaign);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = "delete")
    public void deleteCampaign() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.delete(Endpoint.CAMPAIGN, pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
