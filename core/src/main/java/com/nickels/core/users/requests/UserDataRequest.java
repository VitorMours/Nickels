package com.nickels.core.users.requests;

import jakarta.validation.constraints.*;

public record UserDataRequest(
    @NotBlank String name,
    @NotBlank @Email String email
) {}
