package Project.springproject.service;

import Project.springproject.model.reponse.LoginResponse;
import Project.springproject.model.reponse.RegistrationResponse;
import Project.springproject.model.reponse.UserDetailsResponse;
import Project.springproject.model.request.UserDetailsRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService
{
  private final Map<String, UserDetailsRequest> userTempStorage = new HashMap<>();
  private final Map<String, Boolean> loggedInUsers = new HashMap<>();
  public RegistrationResponse registerUser(UserDetailsRequest userDetails)
 {
     if(userTempStorage.containsKey(userDetails.getEmail()))
     {
         return new RegistrationResponse( "Email already registered",false);
     }
     userTempStorage.put(userDetails.getEmail(), userDetails);
     return new RegistrationResponse("Registration Successful",true);
 }
    public LoginResponse loginUser(String email, String password) {
        UserDetailsRequest registeredUser = userTempStorage.get(email);

        if (registeredUser == null) {
            return new LoginResponse("User with this email does not exist", false, email, false);
        }
        if (!registeredUser.getPassword().equals(password)) {
            return new LoginResponse("Invalid Password", false, email, false);
        }

        // Mark user as logged in
        loggedInUsers.put(email, true);
        return new LoginResponse("Login successful", true, email, true);

    }
    public UserDetailsResponse getUserDetails(String email, boolean showDetails) {
        if (!loggedInUsers.getOrDefault(email, false)) {
            return new UserDetailsResponse("You need to login first.");
        }

        UserDetailsRequest registeredUser = userTempStorage.get(email);
        if (registeredUser == null) {
            return new UserDetailsResponse("User not found.");
        }

        if (!showDetails) {
            return new UserDetailsResponse("User details are hidden.");
        }

        return new UserDetailsResponse(
                "User details retrieved successfully.",
                registeredUser.getFirstName(),
                registeredUser.getMiddleName(),
                registeredUser.getLastName(),
                registeredUser.getAge(),
                registeredUser.getEmail(),
                true
        );
    }

}
