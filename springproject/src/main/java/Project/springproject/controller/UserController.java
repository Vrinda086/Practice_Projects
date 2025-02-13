package Project.springproject.controller;


import Project.springproject.model.reponse.UserDetailsResponse;
import Project.springproject.model.request.UserDetailsRequest;
import Project.springproject.model.reponse.LoginResponse;
import Project.springproject.model.reponse.RegistrationResponse;
import Project.springproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody UserDetailsRequest userDetails, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new RegistrationResponse("Validation failed: " + bindingResult.getAllErrors(), false));
        }
        RegistrationResponse response = userService.registerUser(userDetails);
        return response.isSuccess()
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }

    @GetMapping ("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestParam String email, @RequestParam String password) {
        LoginResponse response = userService.loginUser(email, password);
        return response.isSuccess()
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/showdetails")
    public ResponseEntity<UserDetailsResponse> showUserDetails(@RequestParam String email, @RequestParam boolean showDetails) {
        UserDetailsResponse response = userService.getUserDetails(email, showDetails);
        return response.getMessage().contains("retrieved")
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }

}
