/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package rest.salesforce.com.tests;

import api.ApiMethod;
import salesforce.config.Request;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import salesforce.config.Endpoints;
import salesforce.entities.CreatedResponse;
import salesforce.entities.Product;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class ProductTest extends CommonTest {

    @BeforeMethod(onlyForGroups = {"post", "patch", "delete"})
    public void createAProduct() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Product product = new Product();
        product.setName("First Product");
        product.setProductCode("FP1");
        product.setDescription("The description of the product");
        ApiResponse apiResponse;
        apiResponse = Request.execute(Endpoints.PRODUCTS.get(), pathParams, product, ApiMethod.POST);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @AfterMethod(onlyForGroups = {"post", "patch"})
    public void deleteAProduct() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;
        apiResponse = Request.execute(Endpoints.PRODUCT.get(), pathParams, ApiMethod.DELETE);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void getProducts() throws JsonProcessingException {
        ApiResponse apiResponse = Request.execute(Endpoints.PRODUCTS.get(), new HashMap<>(), ApiMethod.GET);
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
        apiResponse = Request.execute(Endpoints.PRODUCTS.get(), pathParams, product, ApiMethod.POST);
        createdResponse = apiResponse.getResponse().as(CreatedResponse.class);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @Test(groups = "post")
    public void getAProduct() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse = Request.execute(Endpoints.PRODUCT.get(), pathParams, ApiMethod.GET);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "patch")
    public void updateProduct() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        Product product = new Product();
        product.setProductCode("FP1-1");
        product.setDescription("The description of the product with the description changed");
        ApiResponse apiResponse;
        apiResponse = Request.execute(Endpoints.PRODUCT.get(), pathParams, product, ApiMethod.PATCH);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = "delete")
    public void deleteProduct() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), createdResponse.getId());
        ApiResponse apiResponse;
        apiResponse = Request.execute(Endpoints.PRODUCT.get(), pathParams, ApiMethod.DELETE);
        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
