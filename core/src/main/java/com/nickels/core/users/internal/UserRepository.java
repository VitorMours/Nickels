package com.nickels.core.users.internal;

import java.util.UUID;
import org.springframework.data.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID>{}
