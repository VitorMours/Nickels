package com.nickels.core.auth.requests;

import jakarta.validation.constraints.*;

/**
 * Represents the request body for logging in a user
 * 
 * 
 * @param email Email of the user 
 * @param password Password of the user
 * 
 * 
 * @author Joao Vitor Rezende Moura
 * @version 0.0.1 
 * @since 2026-12-10
 */
public record LoginUserRequest(
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String password
) {}
