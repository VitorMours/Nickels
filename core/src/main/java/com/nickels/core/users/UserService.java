package com.nickels.core.users;

import java.util.UUID;
import java.util.Optional;
import com.nickels.core.users.requests.CreatedUserRequest;

public interface UserService {
    UserDto create(CreatedUserRequest request);
    Optional<UserDto> findById(UUID id);
}
