package Project.springproject.controller;


import Project.springproject.model.reponse.UserDetailsResponse;
import Project.springproject.model.request.UserDetailsRequest;
import Project.springproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDetailsRequest userDetails, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body("Vaidation failed: " + bindingResult.getAllErrors());
        }
        String responseMessage = userService.registerUser(userDetails);
        return responseMessage.equals("Registration Successful")
                ? ResponseEntity.ok(responseMessage)
                : ResponseEntity.badRequest().body(responseMessage);
    }

    @GetMapping ("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        String responseMessage = userService.loginUser(email, password);
        return responseMessage.contains("successful")
                ? ResponseEntity.ok(responseMessage)
                : ResponseEntity.badRequest().body(responseMessage);
    }

    @GetMapping("/showdetails")
    public ResponseEntity<UserDetailsResponse> showUserDetails(@RequestParam String email, @RequestParam boolean showDetails) {
        UserDetailsResponse response = userService.getUserDetails(email, showDetails);
        return response.getMessage().contains("retrieved")
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }

}
