package Api.base;

import Api.models_POJO.Requests.CreateOrderRequest;
import io.restassured.response.Response;
import org.testng.Assert;

public class CreateOrder extends BaseService{
    private static final String BASE_PATH = "/api/ecom/order/";

    public Response placeOrder(CreateOrderRequest payload, String token){
        setAuthToken(token);
        return postRequest(payload,BASE_PATH+"create-order");
    }

}
