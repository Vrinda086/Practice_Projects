package Project.springproject.model.reponse;

public class UserDetailsResponse {

    private String message;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
    private String email;
    private boolean detailsVisible;

    public UserDetailsResponse(String message) {
        this.message = message;
    }
    public UserDetailsResponse(String message, String firstName, String middleName, String lastName, Integer age, String email, boolean detailsVisible) {
        this.message = message;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.detailsVisible = detailsVisible;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDetailsVisible() {
        return detailsVisible;
    }

    public void setDetailsVisible(boolean detailsVisible) {
        this.detailsVisible = detailsVisible;
    }
}
