package Api.tests;

import Api.base.AuthService;
import Api.models_POJO.Requests.SignupRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SignupApiTest {
    @Test
    public void signupTest(){
        SignupRequest signupRequest= new SignupRequest("raman","kumar","raman8668@gmail.com","customer","student","male","8811552266","istanbulT1*","istanbulT1*","true");
        AuthService authService= new AuthService();
        Response response = authService.signup(signupRequest);
        System.out.println(response.asPrettyString());
    }
}
