package com.nickels.core.auth.internal;

import jakarta.validation.constraints.*;

record LoginUserRequest(
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String password
) {}
