package Api.base;

import io.restassured.response.Response;

public class ProductsServices extends BaseService{
    private static final String BASE_PATH="/api/ecom/product/";
    public Response addProduct(String productName, String productAddedBy, String productCategory, String productSubCategory, String productPrice, String productDescription, String productFor, String productFilePath, String token){
        setAuthToken(token);
        return postRequestWithFormParameters(productName,productAddedBy, productCategory, productSubCategory,productPrice,productDescription, productFor, productFilePath, BASE_PATH+"add-product");
    }

    public Response deleteProduct(String productId, String token){
        setAuthToken(token);
        return deleteRequest(productId,BASE_PATH+"delete-product/{productId}");
    }
}
