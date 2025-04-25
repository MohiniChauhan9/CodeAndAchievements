package Api.tests;

import Api.base.AuthService;
import Api.base.CreateOrder;
import Api.base.ProductsServices;
import Api.models_POJO.Requests.CreateOrderRequest;
import Api.models_POJO.Requests.LoginRequest;
import Api.models_POJO.Requests.OrderDetails;
import Api.models_POJO.Response.LoginResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateOrderApiTest {
    @Test
    public void createOrder(){
        //login
        LoginRequest loginRequest= new LoginRequest("raman8668@gmail.com","Raman@123");
        AuthService authService= new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.getToken();
        String userId= loginResponse.getUserId();
        System.out.println(token);
        System.out.println(userId);

        //Create product
        ProductsServices productsServices= new ProductsServices();
        String filePath="C:\\Users\\mohini.c.in\\Pictures\\Screenshots\\Screenshot 2025-03-18 133236.png";
        Response productsServicesResponse = productsServices.addProduct( "puma shoes",userId,"fashion","shoes","5000","Puma Originals","men",filePath, token);
        System.out.println(productsServicesResponse.asPrettyString());
        System.out.println("Status Code: " + productsServicesResponse.getStatusCode());
        JsonPath js2= new JsonPath(productsServicesResponse.asString());
        String productId= js2.get("productId");


        //create order
        OrderDetails orderDetails= new OrderDetails("india",productId);
        List<OrderDetails> orderDetailsList= new ArrayList<>();
        orderDetailsList.add(orderDetails);
        CreateOrderRequest createOrderRequest= new CreateOrderRequest(orderDetailsList);
        System.out.println(createOrderRequest);
        CreateOrder createOrder= new CreateOrder();
        response = createOrder.placeOrder(createOrderRequest, token);
        System.out.println(response.asPrettyString());
        System.out.println(productId);

        //validating the status code
        createOrder.validateStatusCode(response,201);
        JsonPath js= new JsonPath(response.asString());
        String message=js.get("message");
        System.out.println(message);
        Assert.assertEquals(message,"Order Placed Successfully");

        //delete product

//        response = productsServices.deleteProduct(productId, token);
//        System.out.println(response.asPrettyString());
//        System.out.println(response.getStatusCode());


    }
}
