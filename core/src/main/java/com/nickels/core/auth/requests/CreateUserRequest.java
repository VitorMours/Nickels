package com.nickels.core.auth.requests;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents the request body for creating a new user in the system
 * 
 * @param name Name of the user
 * @param email Email of the user 
 * @param password Password of the user
 * 
 * @author Joao Vitor Rezende Moura
 * @version 0.0.1 
 * @since 2026-12-10
 */
public record CreateUserRequest(
    @NotBlank String name,
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String password
) {}
