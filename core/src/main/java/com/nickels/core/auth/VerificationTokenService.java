package com.nickels.core.auth;

import java.util.UUID;
import java.util.Optional;

public interface VerificationTokenService {
    sendConfirmationSignupEmail(UUID credentialId)
}
