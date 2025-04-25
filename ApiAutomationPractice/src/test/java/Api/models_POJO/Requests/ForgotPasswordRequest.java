package Api.models_POJO.Requests;

public class ForgotPasswordRequest {
    private String userEmail;
    private String userPassword;
    private String confirmPassword;

    public ForgotPasswordRequest(String userEmail, String userPassword, String confirmPassword) {
        this.userEmail = userEmail;
        this.userPassword= userPassword;
        this.confirmPassword=confirmPassword;
    }

    @Override
    public String toString() {
        return "ForgotPasswordRequest{" +
                "userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
