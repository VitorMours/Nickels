package com.nickels.core.users;

import java.util.UUID;


public record UserDto(UUID id, String name, String email){}
