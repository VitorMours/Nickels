package com.nickels.core.users;

import java.util.UUID;
import java.util.Optional;

public interface UserService {
    UserDto create(String name, String email, String rawPassword);
    Optional<UserDto> findById(UUID id);
}
