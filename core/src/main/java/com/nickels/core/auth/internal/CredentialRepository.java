package com.nickels.core.auth.internal;

import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, UUID> {
    boolean existsByUserEmail(String email);
    Optional<Credential> findByUserEmail(String email);
}
