package Project.springproject.controller;


import Project.springproject.model.request.UserDetailsRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class RegistrationController {
    private HashMap<String,UserDetailsRequest> userTempStorage = new HashMap<>();
    @PostMapping("/register")
    public ResponseEntity<String> getDetails(@Valid @RequestBody UserDetailsRequest userDetails, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body("Vaidation failed: " + bindingResult.getAllErrors());
        }
        if(userTempStorage.containsKey(userDetails.getEmail()))
        {
            return ResponseEntity.badRequest().body("Email already registered");

        }
        userTempStorage.put(userDetails.getEmail(),userDetails);
        return ResponseEntity.ok("Registration Successful");

    }
    @PostMapping("/login")
    public String loginUser(@RequestBody UserDetailsRequest userDetails)
    {
        UserDetailsRequest registeredUser = userTempStorage.get(userDetails.getEmail());

        if(registeredUser==null)
        {
            return "username with this email does not exist";
        }
        if(!registeredUser.getPassword().equals(userDetails.getPassword()))
        {
            return "Invalid Password";
        }

        if(registeredUser.isDetails())
        {
           return "Login successful! User Details: " +
                   "\n First Name: " +registeredUser.getFirstName() +
                   "\n Middle Name: " + registeredUser.getMiddleName() +
                   "\n Last Name: " + registeredUser.getLastName() +
                   "\n Age: " + registeredUser.getAge() +
                   "\n Email: " + registeredUser.getEmail() +
                   "\n Password: " + registeredUser.getPassword();
        }
        else {
            return "Login successful! Details are hidden.";
        }
    }

}
