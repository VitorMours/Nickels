  package com.nickels.backend_core.auth;

import com.nickels.backend_core.auth.internal.Credentials;
import com.nickels.backend_core.auth.internal.CredentialsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
        CredentialsRepository credentialsRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.credentialsRepository = credentialsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(String email, String password) {

        if (credentialsRepository.existsByEmail(email)) {
            throw new IllegalArgumentException(
                "E-mail já cadastrado"
            );
        }

        String passwordHash = passwordEncoder.encode(password);

        Credentials credentials = Credentials.create(
            email,
            passwordHash
        );

        credentialsRepository.save(credentials);
    }
}