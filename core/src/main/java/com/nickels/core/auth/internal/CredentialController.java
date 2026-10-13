package com.nickels.core.auth.internal;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.UUID;
import jakarta.validation.Valid;

import com.nickels.core.auth.SignupDto;
import com.nickels.core.users.UserService;
import com.nickels.core.auth.CredentialDto;
import com.nickels.core.auth.CredentialService;
import com.nickels.core.auth.requests.LoginUserRequest;
import com.nickels.core.auth.requests.CreateUserRequest;
import com.nickels.core.shared.Exceptions.EmailAlreadyRegisteredException;

@RestController
@RequestMapping("auth")
@Tag(name="Authentication", description="Endpoints related with the authentication and authorization of users within the system.")
public class CredentialController {

    private final UserService userService;
    private final CredentialService credentialService;

    CredentialController(UserService userService, CredentialService credentialService) {
        this.userService = userService;
        this.credentialService = credentialService;
    }

    @Operation(summary="Login Fields", description="Fields required to login a user.")
    @GetMapping("/login")
    public ResponseEntity<String> getLoginFields() {
        return ResponseEntity.ok().body("{'email':'string','password':'string'}");
    }

    @Operation(summary="Login user", description="Action to login a user using the data from the body and if he's already registered in the system.")
    @PostMapping("/login")
    public void loginUser(@Valid @RequestBody LoginUserRequest login) {
    }

    @Operation(summary="Signup Fields", description="Fields required to signup a new user")
    @GetMapping("/signup")
    public ResponseEntity<String> getSignupFields() {
        return ResponseEntity.ok().body("");
    }

    @Operation(summary="Signup User", description="Action to signup a new user using the data from the body and if he's not already registered in the system.")
    @PostMapping("/signup")
    public ResponseEntity<CredentialDto> signupUser(@Valid @RequestBody CreateUserRequest request) {
        if (credentialService.isEmailRegistered(request.email())) {
            throw new EmailAlreadyRegisteredException(request.email());
        }
        CredentialDto credential = credentialService.signupUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(credential);
    }
}
