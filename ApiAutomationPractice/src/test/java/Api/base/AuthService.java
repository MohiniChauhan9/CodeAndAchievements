package Api.base;

import Api.models_POJO.Requests.ForgotPasswordRequest;
import Api.models_POJO.Requests.LoginRequest;
import Api.models_POJO.Requests.SignupRequest;
import io.restassured.response.Response;

public class AuthService extends BaseService{
    private static final String BASE_PATH="/api/ecom/auth/";

    public Response login(LoginRequest payload){
        return postRequest(payload, BASE_PATH+"login");
    }

    public Response signup(SignupRequest payload){
        return postRequest(payload, BASE_PATH+"register");
    }
    public Response forgotPassword(ForgotPasswordRequest payload){
        return postRequest(payload, BASE_PATH+"new-password");
    }
}
