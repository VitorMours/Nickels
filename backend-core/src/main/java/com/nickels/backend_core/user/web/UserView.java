package com.nickels.backend_core.user.web;

import java.util.UUID;

public record UserView(
    UUID id,
    String firstName,
    String lastName,
    String email
) {}