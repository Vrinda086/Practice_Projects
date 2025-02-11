package Project.springproject.service;

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
  public String registerUser(UserDetailsRequest userDetails)
 {
     if(userTempStorage.containsKey(userDetails.getEmail()))
     {
         return "Email already registered";
     }
     userTempStorage.put(userDetails.getEmail(), userDetails);
     return "Registration Successful";
 }
    public String loginUser(String email, String password) {
        UserDetailsRequest registeredUser = userTempStorage.get(email);

        if (registeredUser == null) {
            return "User with this email does not exist";
        }
        if (!registeredUser.getPassword().equals(password)) {
            return "Invalid Password";
        }

        // Mark user as logged in
        loggedInUsers.put(email, true);
        return "Login successful! Now use /show-details to choose whether to see your details.";
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
