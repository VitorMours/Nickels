package com.nickels.core.users.internal;

import java.util.UUID;
import com.nickels.core.users.internal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
}
