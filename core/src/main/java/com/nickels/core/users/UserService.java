package com.nickels.core.users;

import java.util.UUID;
import java.util.Optional;
import com.nickels.core.users.requests.UserDataRequest;

public interface UserService {
    UserDto create(UserDataRequest request);
    Optional<UserDto> findById(UUID id);
}
