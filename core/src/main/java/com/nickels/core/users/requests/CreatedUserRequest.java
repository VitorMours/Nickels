package com.nickels.core.users.requests;

import jakarta.validation.constraints.*;

public record CreatedUserRequest(
    @NotBlank String name,
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String password
) {}
