package com.nickels.backend_core.auth.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(

    @NotBlank
    @Size(max = 25)
    String firstName,

    @NotBlank
    @Size(max = 50)
    String lastName,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Size(min = 8, max = 100)
    String password
) {}