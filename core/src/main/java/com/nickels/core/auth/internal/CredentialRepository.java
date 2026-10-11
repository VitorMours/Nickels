package com.nickels.core.auth.internal;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credentials, UUID> {
    boolean existsByUserEmail(String email);
    Optional<Credentials> findByUserEmail(String email);
}
