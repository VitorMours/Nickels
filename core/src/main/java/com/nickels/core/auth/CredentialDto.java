package com.nickels.core.auth;

import java.util.UUID;

public record CredentialDto(UUID id, String email, String password){}