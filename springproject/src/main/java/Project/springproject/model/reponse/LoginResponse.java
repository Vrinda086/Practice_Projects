package Project.springproject.model.reponse;

public class LoginResponse {

    private String message;
    private boolean success;
    private String email;
    private boolean loggedIn;


    public LoginResponse(String message, boolean success, String email, boolean loggedIn) {
        this.message = message;
        this.success = success;
        this.email = email;
        this.loggedIn = loggedIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}
