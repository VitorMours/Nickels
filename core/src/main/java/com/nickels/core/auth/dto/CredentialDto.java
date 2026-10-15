package com.nickels.core.auth.dto;

import java.util.UUID;

public record CredentialDto(UUID id, String email, String password){}