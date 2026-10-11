package com.nickels.core.users.events;

import java.util.UUID;

public record UserRegisteredEvent(UUID userId, String name, String email, String passwordHash) {}