package Api.models_POJO.Requests;

public class SignupRequest {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userRole;
    private String occupation;
    private String gender;
    private String userMobile;
    private String userPassword;
    private String confirmPassword;

    @Override
    public String toString() {
        return "SignupRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRole='" + userRole + '\'' +
                ", occupation='" + occupation + '\'' +
                ", gender='" + gender + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", required='" + required + '\'' +
                '}';
    }

    public SignupRequest(String firstName, String lastName, String userEmail, String userRole,String occupation,String gender,String userMobile,String userPassword, String
   confirmPassword, String required) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.userEmail=userEmail;
        this.userRole=userRole;
        this.occupation=occupation;
        this.gender=gender;
        this.userMobile=userMobile;
        this.userPassword=userPassword;
        this.confirmPassword=confirmPassword;
        this.required=required;
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

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    private String required;
}
