package com.nickels.core.auth.internal;

import com.nickels.core.users.events.UserRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import com.nickels.core.auth.internal.CredentialRepository;
import com.nickels.core.auth.internal.Credentials;

@Component
class CredentialsListener {

    private static final Logger log = LoggerFactory.getLogger(CredentialsListener.class);

    private final CredentialRepository repository;

    CredentialsListener(CredentialRepository repository) {
        this.repository = repository;
    }

    @ApplicationModuleListener
    void on(UserRegisteredEvent event) {
        // Idempotência: o Modulith pode reentregar o evento se uma tentativa falhar
        if (repository.existsByUserEmail(event.email())) {
            log.info("Credenciais já existem para o email {}, ignorando evento", event.email());
            return;
        }

        repository.save(new Credentials(event.email(), event.passwordHash()));
        log.info("Credenciais criadas para o usuário {}", event.userId());
    }
}