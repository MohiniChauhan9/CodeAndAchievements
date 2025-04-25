package Api.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BaseService {
    private static final String BASE_URL="https://rahulshettyacademy.com";
    RequestSpecification requestSpecification;

    public BaseService(){
        this.requestSpecification=given().baseUri(BASE_URL);
    }

    protected void setAuthToken(String token){
        requestSpecification.header("Authorization",token);
    }

    protected Response postRequest(Object payload, String endpoint){
        return requestSpecification.log().all().header("Content-Type","Application/json")
                .body(payload)
                .post(endpoint);
    }

    protected Response postRequestWithFormParameters(String productName, String productAddedBy, String productCategory, String productSubCategory, String productPrice, String productDescription, String productFor, String productFilePath, String endpoint){
        return requestSpecification.log().all()
                .param("productName",productName)
                .param("productAddedBy",productAddedBy)
                .param("productCategory",productCategory)
                .param("productSubCategory",productSubCategory)
                .param("productPrice",productPrice)
                .param("productDescription",productDescription)
                .param("productFor",productFor)
                .multiPart("productImage",new File(productFilePath))
                .post(endpoint);
    }

    public void validateStatusCode(Response response, int expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(),expectedStatusCode);
    }

    protected void attachFile(String filePath){
        requestSpecification.multiPart("productImage", new File(filePath));
    }

    protected Response deleteRequest(String productId, String endpoint){
        return requestSpecification
                .log().all().pathParam("productId",productId)
                .delete(endpoint);
    }
}
