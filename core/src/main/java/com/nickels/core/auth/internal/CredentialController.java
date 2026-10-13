package com.nickels.core.auth.internal;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.nickels.core.auth.requests.CreateUserRequest;
import com.nickels.core.auth.requests.LoginUserRequest;
import jakarta.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("auth")
@Tag(name="Authentication", description="Endpoints related with the authentication and authorization of users within the system.")
public class CredentialController {

    @Operation(summary="Login Fields", description="Fields required to login a user.")
    @GetMapping("/login")
    public ResponseEntity<String> getLoginFields() {
        return ResponseEntity.ok().body("{'email':'string','password':'string'}");
    }

    @Operation(summary="Login user", description="Action to login a user using the data from the body and if he's already registered in the system.")
    @PostMapping("/login")
    public void loginUser(@Valid @RequestBody LoginUserRequest login) {
        //TODO: Fazer validacao de usuario para que ele possa em vias de fato fazer o login
    }

    @Operation(summary="Signup Fields", description="Fields required to signup a new user")
    @GetMapping("/signup")
    public ResponseEntity<String> getSignupFields() {
        return ResponseEntity.ok().body("");
    }

    @Operation(summary="Signup User", description="Action to signup a new user using the data from the body and if he's not already registered in the system.")
    @PostMapping("/signup")
    public void signupUser() {
        //TODO: Fazer validacao de usuario para que ele possa em vias de fato criar a sua conta
    }
}
