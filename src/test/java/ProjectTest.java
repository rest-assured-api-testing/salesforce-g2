/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

import api.ApiRequestManager;
import api.ApiResponse;
import auth.Authentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpointurl.ElementParam;
import endpointurl.Endpoint;
import entities.ModifiedResponse;
import entities.Product;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ProjectTest {

    ModifiedResponse modifiedResponse;

    @BeforeSuite
    public void getToken() {
        Authentication.getAuth();
    }

    @BeforeMethod(onlyForGroups = {"patch", "delete"})
    public void createAProduct() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Product product = new Product();
        product.setName("First Product");
        product.setProductCode("FP1");
        product.setDescription("The description of the product");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.create(Endpoint.PRODUCT, pathParams, product);
        modifiedResponse = apiResponse.getResponse().as(ModifiedResponse.class);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @AfterMethod(onlyForGroups = {"post", "patch"})
    public void deleteAProduct() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, modifiedResponse.getId());
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.delete(Endpoint.PRODUCTS, pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void getProducts() {
        Map<String, String> pathParams = new HashMap<>();
        ApiResponse apiResponse = ApiRequestManager.get(Endpoint.PRODUCT, pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "post")
    public void createProduct() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Product product = new Product();
        product.setName("First Product");
        product.setProductCode("FP1");
        product.setDescription("The description of the product");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.create(Endpoint.PRODUCT, pathParams, product);
        modifiedResponse = apiResponse.getResponse().as(ModifiedResponse.class);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @Test(groups = "patch")
    public void updateProduct() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, modifiedResponse.getId());
        Product product = new Product();
        product.setProductCode("FP1-1");
        product.setDescription("The description of the product with the description changed");
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.updatePatch(Endpoint.PRODUCTS, pathParams, product);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = "delete")
    public void deleteProduct() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, modifiedResponse.getId());
        ApiResponse apiResponse;
        apiResponse = ApiRequestManager.delete(Endpoint.PRODUCTS, pathParams);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

}
