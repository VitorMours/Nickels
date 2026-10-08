package com.nickels.core.users.internal;

import jakarta.validation.constraints.*;

record CreateUserRequest(
    @NotBlank String name,
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String password
) {}
