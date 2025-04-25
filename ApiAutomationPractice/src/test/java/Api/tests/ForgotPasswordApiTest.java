package Api.tests;

import Api.base.AuthService;
import Api.models_POJO.Requests.ForgotPasswordRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordApiTest {
    @Test
    public void ForgotPasswordTest(){
        AuthService authService=new AuthService();
        ForgotPasswordRequest forgotPasswordRequest= new ForgotPasswordRequest("raman8668@gmail.com","Raman@123","Raman@123");
        Response response = authService.forgotPassword(forgotPasswordRequest);
        System.out.println(response.asPrettyString());
    }
}
