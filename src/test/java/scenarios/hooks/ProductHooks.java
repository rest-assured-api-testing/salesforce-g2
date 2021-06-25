package scenarios.hooks;

import api.ApiRequestManager;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.endpointurl.ElementParam;
import salesforce.endpointurl.Endpoint;
import salesforce.entities.Product;
import salesforce.entities.CreatedResponse;
import java.util.HashMap;
import java.util.Map;

public class ProductHooks {
    public Logger LOGGER = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;

    public ProductHooks(final CreatedResponse createdResponse) {
        this.createdResponse = createdResponse;
    }

    @Before(value = "@GetProducts or @GetProduct or @UpdateProduct or @DeleteProduct", order = 2)
    public void setUp() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        Product product = new Product();
        product.setName("The first product");
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.create(Endpoint.PRODUCTS, pathParams, product);
        CreatedResponse createdResponseHelper = apiResponse.getResponse().as(CreatedResponse.class);
        createdResponse.setId(createdResponseHelper.getId());
        createdResponse.setSuccess(createdResponseHelper.isSuccess());
        createdResponse.setErrors(createdResponseHelper.getErrors());

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_CREATED).log().body();
    }

    @After(value = "@GetProducts or @GetProduct or @UpdateProduct or @CreateProduct")
    public void setLast() {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ElementParam.ID, createdResponse.getId());
        ApiResponse apiResponse;

        apiResponse = ApiRequestManager.delete(Endpoint.PRODUCT, pathParams);

        apiResponse.getResponse().then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT).log().body();
    }
}
