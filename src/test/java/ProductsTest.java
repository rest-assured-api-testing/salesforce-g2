/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
import Commons.Endpoints;
import api.ApiManager;
import api.ApiRequestBuilder;
import api.RequestMethod;
import entities.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("unchecked")
public class ProductsTest extends BaseTest {

    @Test
    public void createProductShouldReturnOk() {
        apiRequest.clear();
        Product product = new Product();
        product.setName("testProduct 001");
        apiRequest = new ApiRequestBuilder()
                .setToken(token)
                .setBaseUri(base_url)
                .setEndpoint(Endpoints.CREATE_PRODUCT)
                .setMethod(RequestMethod.POST)
                .setBody(product)
                .build();
        apiResponse = ApiManager.execute(apiRequest);
        int actual = apiResponse.getStatusCode();
        int expected = 201;
        Assert.assertEquals(actual, expected);
    }
}
