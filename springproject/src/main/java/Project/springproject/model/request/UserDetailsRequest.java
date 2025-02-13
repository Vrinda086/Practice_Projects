package Project.springproject.model.request;

import jakarta.validation.constraints.*;

public class UserDetailsRequest{
    @NotNull(message = "First name cannot be null")
    @Size(min = 3, max =10, message = "Name must be between 3 and 10 characters")
    private String firstName;
    @Size(min = 3, max =10, message = "Name must be between 3 and 10 characters")
    private String middleName;
    @NotNull(message = "Last name cannot be null")
    @Size(min = 3, max =10, message = "Name must be between 3 and 10 characters")
    private String lastName;
    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be at most 100")
    private Integer age;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;
    @NotNull(message = "Password cannot be null")
    @Size(min=8, max=16, message="Password must be between 8 and 16 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$",
            message = "Invalid Password"
    )
    private String password;


    public UserDetailsRequest(String firstName, String middleName, String lastName, int age, String email, String password, boolean Details)
   {
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.age = age;
       this.email = email;
       this.password = password;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
