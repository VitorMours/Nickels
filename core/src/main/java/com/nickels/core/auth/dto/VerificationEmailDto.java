package com.nickels.core.auth.internal;

import java.time.Instant;
import java.util.UUID;

public record VerificationEmailDto(
        UUID credentialId,
        String email,
        String token,
        Instant expiresAt
) {}
