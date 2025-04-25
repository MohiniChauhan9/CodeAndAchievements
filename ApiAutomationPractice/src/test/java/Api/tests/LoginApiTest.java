package Api.tests;

import Api.base.AuthService;
import Api.models_POJO.Requests.LoginRequest;
import Api.models_POJO.Response.LoginResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginApiTest {
    @Test
    public void loginTest(){
        LoginRequest loginRequest= new LoginRequest("raman8668@gmail.com","Raman@123");
        AuthService authService= new AuthService();
        Response response = authService.login(loginRequest);
        System.out.println(response.asPrettyString());
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.getToken();
        System.out.println(token);
    }
}
