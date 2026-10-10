package com.nickels.core.auth.internal;

import java.util.UUID;
import com.nickels.core.auth.internal.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credentials, UUID> {

}
