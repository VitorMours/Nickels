package com.nickels.backend_core.auth.web;

import com.nickels.backend_core.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(
        @Valid @RequestBody RegisterRequest request
    ) {
        authService.register(
            request.name(),
            request.email(),
            request.password()
        );

        return ResponseEntity.ok().build();
    }
}